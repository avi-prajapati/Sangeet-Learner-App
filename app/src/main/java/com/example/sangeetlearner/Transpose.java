package com.example.sangeetlearner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class Transpose extends AppCompatActivity {
    View back_image2,plustranspose,minusTranspose;
        String[] Swaras={"Null","A","A#","B","C","C#","D","D#","E","F","F#","G","G#","Am","A#m","Bm","Cm","C#m","Dm","D#m","Em","Fm","F#m","Gm","G#m"};
    String[] majorSwaras={"A","A#","B","C","C#","D","D#","E","F","F#","G","G#","A","A#","B","C","C#","D","D#","E","F","F#","G","G#","A","A#","B","C","C#","D","D#","E","F","F#","G","G#","A","A#","B","C","C#","D","D#","E","F","F#","G","G#"};
    String[] minorSwaras={"Am","A#m","Bm","Cm","C#m","Dm","D#m","Em","Fm","F#m","Gm","G#m","Am","A#m","Bm","Cm","C#m","Dm","D#m","Em","Fm","F#m","Gm","G#m","Am","A#m","Bm","Cm","C#m","Dm","D#m","Em","Fm","F#m","Gm","G#m","Am","A#m","Bm","Cm","C#m","Dm","D#m","Em","Fm","F#m","Gm","G#m"};
    Spinner spinner,spinner2,spinner3,spinner4,spinner5,spinner6;
    ArrayAdapter<String> adapterItems;
    TextView textView20t1,textView20t4,textView20t7,textView20t10,textView20t13,textView20,transposeValue,textView24;
    String userInput1,userInput2,userInput3,userInput4,userInput5,userInput6;
    int transposeCount=0, transposeCount2=0;
    //Textview for output of transpose;
    TextView textView21t3,textView21t6,textView21t9,textView21t12,textView21t15,textView21;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transpose);

        back_image2=findViewById(R.id.back_image2);
        minusTranspose=findViewById(R.id.minusTranspose);
        plustranspose=findViewById(R.id.plustranspose);

        spinner=findViewById(R.id.drop_Text1);
        spinner2=findViewById(R.id.drop_Text2);
        spinner3=findViewById(R.id.drop_Text3);
        spinner4=findViewById(R.id.drop_Text4);
        spinner5=findViewById(R.id.drop_Text5);
        spinner6=findViewById(R.id.drop_Text6);

        textView20t1=findViewById(R.id.textView20t1);
        textView20t4=findViewById(R.id.textView20t4);
        textView20t7=findViewById(R.id.textView20t7);
        textView20t10=findViewById(R.id.textView20t10);
        textView20t13=findViewById(R.id.textView20t13);
        textView20=findViewById(R.id.textView20);

        transposeValue=findViewById(R.id.transposeValue);

        // TextView for transpose output;
        textView21t3=findViewById(R.id.textView21t3);
        textView21t6=findViewById(R.id.textView21t6);
        textView21t9=findViewById(R.id.textView21t9);
        textView21t12=findViewById(R.id.textView21t12);
        textView21t15=findViewById(R.id.textView21t15);
        textView21=findViewById(R.id.textView21);



        //Giving value to Spinner.
        adapterItems=new ArrayAdapter<String>(this,R.layout.list_sur,Swaras);
        adapterItems.setDropDownViewResource(R.layout.list_sur);
        spinner.setAdapter(adapterItems);
        spinner2.setAdapter(adapterItems);
        spinner3.setAdapter(adapterItems);
        spinner4.setAdapter(adapterItems);
        spinner5.setAdapter(adapterItems);
        spinner6.setAdapter(adapterItems);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                userInput1=parent.getItemAtPosition(position).toString();
                textView20t1.setText(userInput1);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                userInput2=parent.getItemAtPosition(position).toString();
                textView20t4.setText(userInput2);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                userInput3=parent.getItemAtPosition(position).toString();
                textView20t7.setText(userInput3);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                userInput4=parent.getItemAtPosition(position).toString();
                textView20t10.setText(userInput4);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                userInput5=parent.getItemAtPosition(position).toString();
                textView20t13.setText(userInput5);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                userInput6=parent.getItemAtPosition(position).toString();
                textView20.setText(userInput6);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //Plus Increment for transpose.
        plustranspose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userInput1.equals("Null")) {
                    Toast.makeText(Transpose.this, "'null' input", Toast.LENGTH_SHORT).show();

                }
                else {
                    if (transposeCount<11) {
                        transposeCount++;
                        if (transposeCount>0) {
                            transposeValue.setTextColor(Color.RED);
                        }

                        transposeValue.setText(""+transposeCount);

                        for (int i=0;i<12;i++) {
                            //This output for first input;
                            if (userInput1.equals(majorSwaras[i])) {
                                int postiveTranspose=Math.abs(transposeCount);
                                String output=majorSwaras[i+postiveTranspose];
                                textView21t3.setText(output);

                            }
                            else if (userInput1.equals(minorSwaras[i])) {
                                int postiveTranspose=Math.abs(transposeCount);
                                String output=minorSwaras[i+postiveTranspose];
                                textView21t3.setText(output);

                            }

                            // This output for second input;
                            if (userInput2.equals(majorSwaras[i])) {
                                int postiveTranspose=Math.abs(transposeCount);
                                String output=majorSwaras[i+postiveTranspose];
                                textView21t6.setText(output);

                            }
                            else if (userInput2.equals(minorSwaras[i])) {
                                int postiveTranspose=Math.abs(transposeCount);
                                String output=minorSwaras[i+postiveTranspose];
                                textView21t6.setText(output);

                            }

                            // This output for third input;
                            if (userInput3.equals(majorSwaras[i])) {
                                int postiveTranspose=Math.abs(transposeCount);
                                String output=majorSwaras[i+postiveTranspose];
                                textView21t9.setText(output);

                            }
                            else if (userInput3.equals(minorSwaras[i])) {
                                int postiveTranspose=Math.abs(transposeCount);
                                String output=minorSwaras[i+postiveTranspose];
                                textView21t9.setText(output);

                            }

                            // This output for fourth input;
                            if (userInput4.equals(majorSwaras[i])) {
                                int postiveTranspose=Math.abs(transposeCount);
                                String output=majorSwaras[i+postiveTranspose];
                                textView21t12.setText(output);

                            }
                            else if (userInput4.equals(minorSwaras[i])) {
                                int postiveTranspose=Math.abs(transposeCount);
                                String output=minorSwaras[i+postiveTranspose];
                                textView21t12.setText(output);

                            }

                            // This output for fifth input;
                            if (userInput5.equals(majorSwaras[i])) {
                                int postiveTranspose=Math.abs(transposeCount);
                                String output=majorSwaras[i+postiveTranspose];
                                textView21t15.setText(output);

                            }
                            else if (userInput5.equals(minorSwaras[i])) {
                                int postiveTranspose=Math.abs(transposeCount);
                                String output=minorSwaras[i+postiveTranspose];
                                textView21t15.setText(output);

                            }

                            // This output for sixth input;
                            if (userInput6.equals(majorSwaras[i])) {
                                int postiveTranspose=Math.abs(transposeCount);
                                String output=majorSwaras[i+postiveTranspose];
                                textView21.setText(output);

                            }
                            else if (userInput6.equals(minorSwaras[i])) {
                                int postiveTranspose=Math.abs(transposeCount);
                                String output=minorSwaras[i+postiveTranspose];
                                textView21.setText(output);
                            }

                        }
                    }
                    else {
                        Toast.makeText(Transpose.this, "Max Transpose", Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });

        //Minus Decrement for transpose.
        minusTranspose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userInput1.equals("Null")) {
                    Toast.makeText(Transpose.this, "'null' input", Toast.LENGTH_SHORT).show();

                }
                else {
                    if (transposeCount>-11) {
                        transposeCount--;
                        if (transposeCount<0) {
                            transposeValue.setTextColor(Color.parseColor("#127A06"));
                        }

                        transposeValue.setText(""+transposeCount);

                        for (int i=38; i>=0; i--) {
                            //This output for first input;

                                if (userInput1.equals(majorSwaras[i])) {
                                    String output=majorSwaras[i+transposeCount];
                                    textView21t3.setText(output);

                                    if(userInput2.equals("Null")) {
                                        break;
                                    }

                                }
                                else if (userInput1.equals(minorSwaras[i])) {
                                    String output=minorSwaras[i+transposeCount];
                                    textView21t3.setText(output);

                                    if(userInput2.equals("Null")) {
                                        break;
                                    }
                                }

                                //This output for second input;
                                if (userInput2.equals(majorSwaras[i])) {
                                    String output=majorSwaras[i+transposeCount];
                                    textView21t6.setText(output);

                                    if(userInput3.equals("Null")) {
                                        break;
                                    }
                                }
                                else if (userInput2.equals(minorSwaras[i])) {
                                    String output=minorSwaras[i+transposeCount];
                                    textView21t6.setText(output);

                                    if(userInput3.equals("Null")) {
                                        break;
                                    }
                                }

                                //This output for third input;
                                if (userInput3.equals(majorSwaras[i])) {
                                    String output=majorSwaras[i+transposeCount];
                                    textView21t9.setText(output);

                                    if(userInput4.equals("Null")) {
                                        break;
                                    }
                                }
                                else if (userInput3.equals(minorSwaras[i])) {
                                    String output=minorSwaras[i+transposeCount];
                                    textView21t9.setText(output);

                                    if(userInput4.equals("Null")) {
                                        break;
                                    }
                                }

                                //This output for fourth input;
                                if (userInput4.equals(majorSwaras[i])) {
                                    String output=majorSwaras[i+transposeCount];
                                    textView21t12.setText(output);

                                    if(userInput5.equals("Null")) {
                                        break;
                                    }
                                }
                                else if (userInput4.equals(minorSwaras[i])) {
                                    String output=minorSwaras[i+transposeCount];
                                    textView21t12.setText(output);

                                    if(userInput5.equals("Null")) {
                                        break;
                                    }
                                }

                                //This output for fifth input;
                                if (userInput5.equals(majorSwaras[i])) {
                                    String output=majorSwaras[i+transposeCount];
                                    textView21t15.setText(output);

                                    if(userInput6.equals("Null")) {
                                        break;
                                    }
                                }
                                else if (userInput5.equals(minorSwaras[i])) {
                                    String output=minorSwaras[i+transposeCount];
                                    textView21t15.setText(output);

                                    if(userInput6.equals("Null")) {
                                        break;
                                    }
                                }

                                //This output for sixth input;
                                if (userInput6.equals(majorSwaras[i])) {
                                    String output=majorSwaras[i+transposeCount];
                                    textView21.setText(output);
                                    break;

                                }
                                else if (userInput6.equals(minorSwaras[i])) {
                                    String output=minorSwaras[i+transposeCount];
                                    textView21.setText(output);
                                    break;

                                }




                        }

                    }
                    else {
                        Toast.makeText(Transpose.this, "Min Transpose", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });

        textView24=findViewById(R.id.textView24);
        textView24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Transpose.this,Transpose_Two.class);
                startActivity(intent);
            }
        });


        back_image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Transpose.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

}