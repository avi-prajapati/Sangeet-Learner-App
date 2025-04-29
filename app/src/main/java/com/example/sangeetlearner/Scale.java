package com.example.sangeetlearner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

public class Scale extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    Button button;
    TextView scaleTextView,hindiscaleTextView,errorTextView2;
    private final String [] scale={"A","A#","B","C","C#","D","D#","E","F","F#","G","G#","A","A#","B","C","C#","D","D#","E","F","F#","G","G#"};
    private final String [] indian_scale={"Sa","re","Re","ga","Ga","ma","Ma","Pa","dha","Dha","ni","Ni","Sa","re","Re","ga","Ga","ma","Ma","Pa","dha","Dha","ni","Ni"};
    private final String [] autoComplete={"A","A#","B","C","C#","D","D#","E","F","F#","G","G#","Sa","re","Re","ga","Ga","ma","Ma","Pa","dha","Dha","ni","Ni"};

    View back_image3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale);

        autoCompleteTextView=findViewById(R.id.autoCompleteTextView);
        scaleTextView=findViewById(R.id.scaleTextView);
        button=findViewById(R.id.scaleButton);
        hindiscaleTextView=findViewById(R.id.hindiscaleTextView);
        errorTextView2=findViewById(R.id.errorTextView2);
        back_image3=findViewById(R.id.back_image3);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,autoComplete);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(arrayAdapter);

        button.setOnClickListener(v -> {
            String user=autoCompleteTextView.getText().toString().toUpperCase();
            String hindiuser=autoCompleteTextView.getText().toString();

            try {
                for(int i=0; i<36; i++) {
                    if(scale[i].equals(user)) {
                        scaleTextView.setText(scale[i]+"\n\n"+scale[i + 2]+"\n\n"+scale[i + 4]+"\n\n"+scale[i + 5]+"\n\n"+scale[i + 7]+"\n\n"+scale[i + 9]+"\n\n"+scale[i + 11]);
                        break;
                    }
                    else if (indian_scale[i].equals(hindiuser)) {
                        hindiscaleTextView.setText(indian_scale[i]+"\n\n"+indian_scale[i + 2]+"\n\n"+indian_scale[i + 4]+"\n\n"+indian_scale[i + 5]+"\n\n"+indian_scale[i + 7]+"\n\n"+indian_scale[i + 9]+"\n\n"+indian_scale[i + 11]);
                        break;
                    }

                }

            }
            catch (Exception e) {
                errorTextView2.setText("Please enter valid Note/Swar");

            }


        });

        back_image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Scale.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}