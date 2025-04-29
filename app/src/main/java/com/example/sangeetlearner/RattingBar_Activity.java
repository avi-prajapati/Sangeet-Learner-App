package com.example.sangeetlearner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RattingBar_Activity extends AppCompatActivity {
    RatingBar ratingBar;
    EditText editTextTextMultiLine;
    Button button;
    String userRating,userComent;
    TextView textView11;
    FirebaseDatabase database;
    DatabaseReference reference;
    String DeviceId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratting_bar);

        ratingBar=findViewById(R.id.ratingBar);
        editTextTextMultiLine=findViewById(R.id.editTextTextMultiLine);
        button=findViewById(R.id.button);
//        textView11=findViewById(R.id.textView11);

        database=FirebaseDatabase.getInstance();
        reference=database.getReference("usersRatting").child("device_id :");

        DeviceId= Settings.Secure.getString(getContentResolver(),Settings.Secure.ANDROID_ID);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = DeviceId;
                userRating=String.valueOf(ratingBar.getRating());
                userComent=String.valueOf(editTextTextMultiLine.getText());

                String user_openion=("Rating :"+userRating+"............\tComment :"+userComent);

                reference.child(userId).setValue(user_openion).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(RattingBar_Activity.this, "Rating submitted!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(RattingBar_Activity.this, "Failed to submit rating.", Toast.LENGTH_SHORT).show();
                    }

                });

//                textView11.setText(userRating);



            }
        });

    }
}