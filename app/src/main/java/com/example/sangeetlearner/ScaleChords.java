package com.example.sangeetlearner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ScaleChords extends AppCompatActivity {
    private final String [] scale={"A","A#","B","C","C#","D","D#","E","F","F#","G","G#","A","A#","B","C","C#","D","D#","E","F","F#","G","G#"};
    private final String [] major_scale={"A","A#","B","C","C#","D","D#","E","F","F#","G","G#"};
    private final String [] minor_scale={"Am","A#m","Bm","Cm","C#m","Dm","D#m","Em","Fm","F#m","Gm","G#m"};
    TextView textView;
    Button button;
    Spinner spinner;
    ArrayAdapter<String> arrayAdapter;
    View back_image1;
    String user_input;
    RadioGroup radioGroup;
    RadioButton radioButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_chords);

        back_image1=findViewById(R.id.back_image1);
        spinner=findViewById(R.id.drop_Text1);
        button=findViewById(R.id.scaleChordButton);
        textView=findViewById(R.id.ScaleChordTextView);
        radioGroup=findViewById(R.id.radioGroup);


        arrayAdapter=new ArrayAdapter<String>(this,R.layout.list_sur,major_scale);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                user_input=parent.getItemAtPosition(position).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        button.setOnClickListener(v -> {
            try {
                int Id=radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(Id);
                String radioText= String.valueOf(radioButton.getText());

                if (radioText.equals("Major Scale")) {
                    for(int i=0; i<12; i++) {
                        if(scale[i].equals(user_input)) {
                            textView.setText(scale[i]+" Major\n\n"+scale[i + 2]+" Minor\n\n"+scale[i + 4]+" Minor\n\n"+scale[i + 5]+" Major\n\n"+scale[i + 7]+" Major\n\n"+scale[i + 9]+" Minor\n\n"+scale[i + 11]+" Diminished");
                            break;
                        }
                    }
                }
                else {
                    for(int i=0; i<12; i++) {
                        if(scale[i].equals(user_input)) {
                            textView.setText(scale[i]+" Minor\n\n"+scale[i + 2]+" Diminished\n\n"+scale[i + 3]+" Major\n\n"+scale[i + 5]+" Minor\n\n"+scale[i + 7]+" Minor\n\n"+scale[i + 8]+" Major\n\n"+scale[i + 10]+" Major");
                            break;
                        }
                    }

                }

            } catch (Exception e) {
                Toast.makeText(this, "Select 'Major' or 'Minor'", Toast.LENGTH_SHORT).show();


            }

        });


        back_image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ScaleChords.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}