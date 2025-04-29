package com.example.sangeetlearner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class Harmonium_LinearLayout extends AppCompatActivity {
    Button harmonium_music,Male_music,Female_music,stopbutton;
    Button Sa,re,Re,ga,Ga,ma,Ma,Pa,dha,Dha,ni,Ni;
    MediaPlayer mediaPlayer;
    Switch sustain;
    View back_image1;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harmonium_linear_layout);

        mediaPlayer=new MediaPlayer();

        harmonium_music=findViewById(R.id.button21);
//        Male_music=findViewById(R.id.button22);
//        Female_music=findViewById(R.id.button23);
        stopbutton=findViewById(R.id.stopbutton);
        sustain=findViewById(R.id.switch2);
        Sa=findViewById(R.id.button15);
        re=findViewById(R.id.button16);
        Re=findViewById(R.id.button17);
        ga=findViewById(R.id.button18);
        Ga=findViewById(R.id.button19);
        ma=findViewById(R.id.button20);
        Ma=findViewById(R.id.button13);
        Pa=findViewById(R.id.button12);
        dha=findViewById(R.id.button11);
        Dha=findViewById(R.id.button10);
        ni=findViewById(R.id.button9);
        Ni=findViewById(R.id.button4);


        back_image1=findViewById(R.id.back_image1);
        back_image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Harmonium_LinearLayout.this,MainActivity.class);
                startActivity(intent);
            }
        });


        Sa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.c3);
                mediaPlayer.start();
            }
        });

        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.csharp3);
                mediaPlayer.start();
            }
        });

        Re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.d3);
                mediaPlayer.start();
            }
        });

        ga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.dsharp3);
                mediaPlayer.start();
            }
        });

        Ga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.e3);
                mediaPlayer.start();
            }
        });

        ma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.f3);
                mediaPlayer.start();
            }
        });

        Ma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.fsharp3);
                mediaPlayer.start();
            }
        });

        Pa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.g3);
                mediaPlayer.start();
            }
        });

        dha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.gsharp3);
                mediaPlayer.start();
            }
        });

        Dha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.a3);
                mediaPlayer.start();
            }
        });

        ni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.asharp3);
                mediaPlayer.start();
            }
        });

        Ni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.b3);
                mediaPlayer.start();
            }
        });



        sustain.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Sa.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mediaPlayer.stop();
                            mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.c3);
                            mediaPlayer.start();
                            mediaPlayer.setLooping(true);
                        }
                    });

                    re.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mediaPlayer.stop();
                            mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.csharp3);
                            mediaPlayer.start();
                            mediaPlayer.setLooping(true);
                        }
                    });

                    Re.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mediaPlayer.stop();
                            mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.d3);
                            mediaPlayer.start();
                            mediaPlayer.setLooping(true);
                        }
                    });

                    ga.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mediaPlayer.stop();
                            mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.dsharp3);
                            mediaPlayer.start();
                            mediaPlayer.setLooping(true);
                        }
                    });

                    Ga.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mediaPlayer.stop();
                            mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.e3);
                            mediaPlayer.start();
                            mediaPlayer.setLooping(true);
                        }
                    });

                    ma.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mediaPlayer.stop();
                            mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.f3);
                            mediaPlayer.start();
                            mediaPlayer.setLooping(true);
                        }
                    });

                    Ma.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mediaPlayer.stop();
                            mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.fsharp3);
                            mediaPlayer.start();
                            mediaPlayer.setLooping(true);
                        }
                    });

                    Pa.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mediaPlayer.stop();
                            mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.g3);
                            mediaPlayer.start();
                            mediaPlayer.setLooping(true);
                        }
                    });

                    dha.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mediaPlayer.stop();
                            mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.gsharp3);
                            mediaPlayer.start();
                            mediaPlayer.setLooping(true);
                        }
                    });

                    Dha.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mediaPlayer.stop();
                            mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.a3);
                            mediaPlayer.start();
                            mediaPlayer.setLooping(true);
                        }
                    });

                    ni.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mediaPlayer.stop();
                            mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.asharp3);
                            mediaPlayer.start();
                            mediaPlayer.setLooping(true);
                        }
                    });

                    Ni.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mediaPlayer.stop();
                            mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.b3);
                            mediaPlayer.start();
                            mediaPlayer.setLooping(true);
                        }
                    });

                }
                else {
                    mediaPlayer.stop();

                    Sa.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mediaPlayer.stop();
                            mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.c3);
                            mediaPlayer.start();
                        }
                    });

                    re.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mediaPlayer.stop();
                            mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.csharp3);
                            mediaPlayer.start();
                        }
                    });

                    Re.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mediaPlayer.stop();
                            mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.d3);
                            mediaPlayer.start();
                        }
                    });

                    ga.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mediaPlayer.stop();
                            mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.dsharp3);
                            mediaPlayer.start();
                        }
                    });

                    Ga.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mediaPlayer.stop();
                            mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.e3);
                            mediaPlayer.start();
                        }
                    });

                    ma.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mediaPlayer.stop();
                            mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.f3);
                            mediaPlayer.start();
                        }
                    });

                    Ma.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mediaPlayer.stop();
                            mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.fsharp3);
                            mediaPlayer.start();
                        }
                    });

                    Pa.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mediaPlayer.stop();
                            mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.g3);
                            mediaPlayer.start();
                        }
                    });

                    dha.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mediaPlayer.stop();
                            mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.gsharp3);
                            mediaPlayer.start();
                        }
                    });

                    Dha.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mediaPlayer.stop();
                            mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.a3);
                            mediaPlayer.start();
                        }
                    });

                    ni.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mediaPlayer.stop();
                            mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.asharp3);
                            mediaPlayer.start();
                        }
                    });

                    Ni.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mediaPlayer.stop();
                            mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.b3);
                            mediaPlayer.start();
                        }
                    });

                }

            }
        });


        stopbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
            }
        });




        harmonium_music.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Sa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mediaPlayer.stop();
                        mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.c3);
                        mediaPlayer.start();
                    }
                });


                re.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mediaPlayer.stop();
                        mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.csharp3);
                        mediaPlayer.start();
                    }
                });

                Re.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mediaPlayer.stop();
                        mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.d3);
                        mediaPlayer.start();
                    }
                });

                ga.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mediaPlayer.stop();
                        mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.dsharp3);
                        mediaPlayer.start();
                    }
                });

                Ga.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mediaPlayer.stop();
                        mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.e3);
                        mediaPlayer.start();
                    }
                });

                ma.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mediaPlayer.stop();
                        mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.f3);
                        mediaPlayer.start();
                    }
                });

                Ma.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mediaPlayer.stop();
                        mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.fsharp3);
                        mediaPlayer.start();
                    }
                });

                Pa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mediaPlayer.stop();
                        mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.g3);
                        mediaPlayer.start();
                    }
                });

                dha.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mediaPlayer.stop();
                        mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.gsharp3);
                        mediaPlayer.start();
                    }
                });

                Dha.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mediaPlayer.stop();
                        mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.a3);
                        mediaPlayer.start();
                    }
                });

                ni.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mediaPlayer.stop();
                        mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.asharp3);
                        mediaPlayer.start();
                    }
                });

                Ni.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mediaPlayer.stop();
                        mediaPlayer=MediaPlayer.create(Harmonium_LinearLayout.this,R.raw.b3);
                        mediaPlayer.start();
                    }
                });

            }

        });











    }


}