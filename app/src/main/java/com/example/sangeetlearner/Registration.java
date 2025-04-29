package com.example.sangeetlearner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Registration extends AppCompatActivity {
    EditText Signup_username,Signup_userId,Signup_password;
    Button signUpButton, signUpGoogleButton;
    TextView clickforsignin;
    ProgressBar progressBar;

    FirebaseDatabase database;
    DatabaseReference reference;
    String DeviceId;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Signup_username=findViewById(R.id.Signup_username);
        Signup_userId=findViewById(R.id.Signup_userId);
        Signup_password=findViewById(R.id.Signup_password);

        signUpButton=findViewById(R.id.signUpButton);

        clickforsignin=findViewById(R.id.clickforsignin);
        progressBar=findViewById(R.id.progressBar);

        //To get the Id of the device.
        DeviceId= Settings.Secure.getString(getContentResolver(),Settings.Secure.ANDROID_ID);

//        //If user login once then next time
//        reference=FirebaseDatabase.getInstance().getReference("users");
//        Query checkUserAlreadyLogin=reference.orderByChild("db_deviceId").equalTo(DeviceId);
//
//        checkUserAlreadyLogin.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if(snapshot.exists()){
//                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                    finish();
//                }
//                else {
//                    startActivity(new Intent(getApplicationContext(), Registration.class));
//                    finish();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });


        //To shift into a Login Page.
        clickforsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Login_Page.class);
                startActivity(intent);
                finish();
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String signupInput_username=Signup_username.getText().toString().trim();
                String signupInput_userId=Signup_userId.getText().toString().trim();
                String signupInput_password=Signup_password.getText().toString().trim();

                if(signupInput_username.isEmpty()){
                    Toast.makeText(Registration.this, "User Name can't be Null.", Toast.LENGTH_SHORT).show();
                    Signup_username.setError("Required");
                    return;
                }
                if(signupInput_userId.isEmpty()){
                    Toast.makeText(Registration.this, "UserId can't be Null.", Toast.LENGTH_SHORT).show();
                    Signup_userId.setError("Required");
                    return;
                }
                if(signupInput_password.isEmpty()){
                    Toast.makeText(Registration.this, "Create Password", Toast.LENGTH_SHORT).show();
                    Signup_password.setError("Required");
                    return;
                }

                //Lets check if the device is already used for login before.
                reference=FirebaseDatabase.getInstance().getReference("users");
                Query checkUserDeviceId=reference.orderByChild("bd_deviceId").equalTo(DeviceId);

                checkUserDeviceId.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()) {
                            Toast.makeText(Registration.this, "You Already Registered", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            //If device is not login before then check userid is already exist or not (method for this)
                            checkUserId();
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
//        clickforsignin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(getApplicationContext(),Login_Page.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//
//        signUpButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                progressBar.setVisibility(View.VISIBLE);
//                String name,email,userpassword;
//
//                name=String.valueOf(username.getText());
//                email=String.valueOf(emailaddress.getText());
//                userpassword=String.valueOf(password.getText());
//
//                if(TextUtils.isEmpty(name)){
//                    Toast.makeText(Registration.this, "Please Enter your Name", Toast.LENGTH_SHORT).show();
//                }
//
//                if(TextUtils.isEmpty(email)){
//                    Toast.makeText(Registration.this, "Please Enter your Email", Toast.LENGTH_SHORT).show();
//                }
//
//                if(TextUtils.isEmpty(userpassword)){
//                    Toast.makeText(Registration.this, "Please Create Password", Toast.LENGTH_SHORT).show();
//                }
//
//
//                mAuth.createUserWithEmailAndPassword(email, userpassword)
//                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                if (task.isSuccessful()) {
//                                    progressBar.setVisibility(View.GONE);
//                                    Toast.makeText(Registration.this, "Account Created Successfully",
//                                            Toast.LENGTH_SHORT).show();
//                                    Intent intent=new Intent(getApplicationContext(), MainActivity.class);
//                                    startActivity(intent);
//                                    finish();
//
//                                }
//                                else {
//                                    Toast.makeText(Registration.this, "some Error Occured",
//                                            Toast.LENGTH_SHORT).show();
//
//                                }
//                            }
//                        });


//            }
//        });


    }

    private void checkUserId() {
        String userUserId=Signup_userId.getText().toString().trim();

        reference=FirebaseDatabase.getInstance().getReference("users");
        Query checkUserIdDatabase=reference.orderByChild("db_userId").equalTo(userUserId);

        checkUserIdDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    Toast.makeText(Registration.this, "UserID Exist", Toast.LENGTH_SHORT).show();
                }
                else {
                    //If userId doesnot exist then continue signIn.
                    String name=Signup_username.getText().toString().trim();
                    String userid=Signup_userId.getText().toString().trim();
                    String password=Signup_password.getText().toString().trim();

                    UserModelForFireBase userModelForFireBase=new UserModelForFireBase(name,userid,password,DeviceId);
                    reference.child(userid).setValue(userModelForFireBase);

                    Toast.makeText(Registration.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),Login_Page.class));
                    finish();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}