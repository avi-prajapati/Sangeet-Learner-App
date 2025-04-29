package com.example.sangeetlearner;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;


public class Piano_Fragment extends Fragment {
    Button button5;
    PDFView pdfView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_piano_, container, false);

        pdfView=view.findViewById(R.id.pdfView);
        pdfView.fromAsset("piano.pdf").load();

        button5=view.findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment defaultfragment=new Default();
                FragmentTransaction ft=getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragmentContainerView,defaultfragment).commit();
            }
        });

        return view;


    }
}