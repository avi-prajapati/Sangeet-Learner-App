package com.example.sangeetlearner;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;


public class Riyaz_Fragment extends Fragment {
    Button button6;
    PDFView pdfView2;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_riyaz_, container, false);

        pdfView2=view.findViewById(R.id.pdfView2);
        pdfView2.fromAsset("Harmonium.pdf").load();

        button6=view.findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
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