package com.example.sangeetlearner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.security.Security;
import java.util.Objects;

public class Login_Page extends AppCompatActivity {
    EditText signIn_userId, signInPassword;
    Button signInButton, signInGoogleButton;
    TextView clickForSignUP;
    ProgressBar progressBar;
    FirebaseAuth mAuth;

    FirebaseDatabase database;
    DatabaseReference reference;
    String DeviceId;


//    @Override
//    public void onStart() {
//        super.onStart();
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if(currentUser != null){
//            Intent intent=new Intent(getApplicationContext(), MainActivity.class);
//            startActivity(intent);
//            finish();
//
//        }
//    }

//    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        signIn_userId=findViewById(R.id.signIn_userId);
        signInPassword=findViewById(R.id.signInPassword);

        signInButton=findViewById(R.id.signInButton);


        clickForSignUP=findViewById(R.id.clickForSignUP);

        //to get device id.
        DeviceId= Settings.Secure.getString(getContentResolver(),Settings.Secure.ANDROID_ID);



        //To change avtivity page from login page to registration page.
        clickForSignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), Registration.class);
                startActivity(intent);
                finish();
            }
        });


        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String signInInput_userId=signIn_userId.getText().toString().trim();
                String signInInput_password=signInPassword.getText().toString().trim();


                if(signInInput_userId.isEmpty()) {
                    Toast.makeText(Login_Page.this, "Enter UserId", Toast.LENGTH_SHORT).show();
                    signIn_userId.setError("Required");
                    return;
                }

                if(signInInput_password.isEmpty()) {
                    Toast.makeText(Login_Page.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    signInPassword.setError("Required");
                    return;
                }

                reference=FirebaseDatabase.getInstance().getReference("users");
                Query checkUserDeviceId=reference.orderByChild("db_deviceId").equalTo(DeviceId);

                checkUserDeviceId.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            checkUser();

                        }
                        else {
                            Toast.makeText(Login_Page.this, "User Not Found", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });



            }
        });


//        mAuth= FirebaseAuth.getInstance();
//
//        clickForSignUP.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(getApplicationContext(), Registration.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//
//        signInButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                progressBar.setVisibility(View.VISIBLE);
//                String email,userpassword;
//
//
//                email=String.valueOf(signInemailaddress.getText());
//                userpassword=String.valueOf(signInPassword.getText());
//
//
//                if(TextUtils.isEmpty(email)){
//                    Toast.makeText(Login_Page.this, "Please Enter your Email", Toast.LENGTH_SHORT).show();
//                }
//
//                if(TextUtils.isEmpty(userpassword)){
//                    Toast.makeText(Login_Page.this, "Enter Password", Toast.LENGTH_SHORT).show();
//                }
//
//                mAuth.signInWithEmailAndPassword(email, userpassword)
//                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                progressBar.setVisibility(View.GONE);
//                                if (task.isSuccessful()) {
//                                    Log.d("avi","Some error occured");
//                                    Toast.makeText(Login_Page.this, "Login Successfull", Toast.LENGTH_SHORT).show();
//                                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
//                                    startActivity(intent);
//                                    finish();
//
//                                }
//                                else {
//                                    Toast.makeText(Login_Page.this, "Authentication failed.",
//                                            Toast.LENGTH_SHORT).show();
//
//                                }
//                            }
//                        });
//
//
//
//            }
//        });

    }

    private void checkUser() {
        String userUserId=signIn_userId.getText().toString().trim();
        String userUserPassword=signInPassword.getText().toString().trim();

        reference=FirebaseDatabase.getInstance().getReference("users");
        Query checkUserIdFromDatabase=reference.orderByChild("db_userId").equalTo(userUserId);

        checkUserIdFromDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){

                    signIn_userId.setError(null);
                    String passwordFromDb=snapshot.child(userUserId).child("db_password").getValue(String.class);

                    if(Objects.equals(userUserPassword,passwordFromDb)){
                        Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();

                    }
                    else {
                        signInPassword.setError("Wrong Password");
                        signInPassword.requestFocus();
                    }

                }
                else {
                    signIn_userId.setError("User doesn't Exist");
                    signIn_userId.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}