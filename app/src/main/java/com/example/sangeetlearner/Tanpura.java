package com.example.sangeetlearner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Tanpura extends AppCompatActivity {
    View back_image4;
    TextView key_textView;
    Spinner spinner1,spinner2;
    String[] type={"Indian","Western"};
    String[] western_swar={"C","C#","D","D#","E","F","F#","G","G#","A","A#","B"};
    String[] indian_swar={"Sa","re","Re","ga","Ga","ma","Ma","Pa","dha","Dha","ni","Ni"};
    String[] keyboard_key={"White 1","Black 1","White 2","Black 2","White 3","White 4","Black 3","White 5","Black 4","White 6","Black 5","White 7"};
    ArrayAdapter<String> arrayAdapter,arrayAdapter2;
    MediaPlayer mediaPlayer;
    Button button2,tanpura_stop_button;
    String user_swar;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanpura);

        back_image4=findViewById(R.id.back_image4);
        key_textView=findViewById(R.id.key_textView);
        spinner1=findViewById(R.id.drop_Text_tanpura);
        spinner2=findViewById(R.id.drop_Text_tanpura2);


        arrayAdapter=new ArrayAdapter<String>(this,R.layout.list_sur,type);
        spinner1.setAdapter(arrayAdapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item=parent.getItemAtPosition(position).toString();

                if (item.equals("Indian")) {
                    arrayAdapter2=new ArrayAdapter<String>(getBaseContext(),R.layout.list_sur,indian_swar);
                    spinner2.setAdapter(arrayAdapter2);
                }
                else {
                    arrayAdapter2=new ArrayAdapter<String>(getBaseContext(),R.layout.list_sur,western_swar);
                    spinner2.setAdapter(arrayAdapter2);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                for (int i=0; i<13;i++) {
                    if (position==i) {
                        key_textView.setText(keyboard_key[i]);
                    }
                }

                user_swar=parent.getItemAtPosition(position).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        arrayAdapter=new ArrayAdapter<String>(this,R.layout.list_sur,type);
        spinner2.setAdapter(arrayAdapter);



        tanpura_stop_button=findViewById(R.id.tanpura_stop_button);
        tanpura_stop_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
            }
        });


        button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user_swar.equals("Sa") || user_swar.equals("C")) {
                    mediaPlayer=MediaPlayer.create(Tanpura.this,R.raw.tanpura_c);

                }
                else if (user_swar.equals("re") || user_swar.equals("C#")) {
                    mediaPlayer=MediaPlayer.create(Tanpura.this,R.raw.tanpura_csharp);

                }
                else if (user_swar.equals("Re") || user_swar.equals("D")) {
                    mediaPlayer=MediaPlayer.create(Tanpura.this,R.raw.tanpura_d);

                }
                else if (user_swar.equals("ga") || user_swar.equals("D#")) {
                    mediaPlayer=MediaPlayer.create(Tanpura.this,R.raw.tanpura_dsharp);

                }
                else if (user_swar.equals("Ga") || user_swar.equals("E")) {
                    mediaPlayer=MediaPlayer.create(Tanpura.this,R.raw.tanpura_e);

                }
                else if (user_swar.equals("ma") || user_swar.equals("F")) {
                    mediaPlayer=MediaPlayer.create(Tanpura.this,R.raw.tanpura_f);

                }
                else if (user_swar.equals("Ma") || user_swar.equals("F#")) {
                    mediaPlayer=MediaPlayer.create(Tanpura.this,R.raw.tanpura_fsharp);

                }
                else if (user_swar.equals("Pa") || user_swar.equals("G")) {
                    mediaPlayer=MediaPlayer.create(Tanpura.this,R.raw.tanpura_g);

                }
                else if (user_swar.equals("dha") || user_swar.equals("G#")) {
                    mediaPlayer=MediaPlayer.create(Tanpura.this,R.raw.tanpura_gsharp);

                }
                else if (user_swar.equals("Dha") || user_swar.equals("A")) {
                    mediaPlayer=MediaPlayer.create(Tanpura.this,R.raw.tanpura_a);

                }
                else if (user_swar.equals("ni") || user_swar.equals("A#")) {
                    mediaPlayer=MediaPlayer.create(Tanpura.this,R.raw.tanpura_asharp);

                }
                else if (user_swar.equals("Ni") || user_swar.equals("B")) {
                    mediaPlayer=MediaPlayer.create(Tanpura.this,R.raw.tanpura_b);

                }
                mediaPlayer.start();


            }
        });


        back_image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                Intent intent=new Intent(Tanpura.this,MainActivity.class);
                startActivity(intent);

            }
        });

    }
}