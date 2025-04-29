package com.example.sangeetlearner;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Default extends Fragment {
    View linearLayout;

    CardView tranpuraCardView, scaleChordCardView, transposeCardView, scaleCardView;
    CardView guitarChordCardView, harmoniumChordCardView, pianoChordCardView;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_default, container, false);



        scaleChordCardView=view.findViewById(R.id.scaleChordCardView);
        scaleChordCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intnent=new Intent(getContext(), ScaleChords.class);
                startActivity(intnent);
            }
        });

        transposeCardView=view.findViewById(R.id.transposeCardView);
        transposeCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intnent=new Intent(getContext(), Transpose.class);
                startActivity(intnent);
            }
        });

        scaleCardView=view.findViewById(R.id.scaleCardView);
        scaleCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intnent=new Intent(getContext(), Scale.class);
                startActivity(intnent);
            }
        });

        tranpuraCardView=view.findViewById(R.id.tranpuraCardView);
        tranpuraCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intnent=new Intent(getContext(), Tanpura.class);
                startActivity(intnent);
            }
        });


//Click Listener for Chords CardView.
        guitarChordCardView=view.findViewById(R.id.guitarChordCardView);
        guitarChordCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Guitar_LinearLayout.class);
                startActivity(intent);

            }
        });

        harmoniumChordCardView=view.findViewById(R.id.harmoniumChordCardView);
        harmoniumChordCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Harmonium_LinearLayout.class);
                startActivity(intent);

            }
        });

        pianoChordCardView=view.findViewById(R.id.pianoChordCardView);
        pianoChordCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Piano_LinearLayout.class);
                startActivity(intent);

            }
        });

        return view;
    }
}