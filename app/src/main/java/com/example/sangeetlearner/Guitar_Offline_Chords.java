package com.example.sangeetlearner;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.barteksc.pdfviewer.PDFView;


public class Guitar_Offline_Chords extends Fragment {
    PDFView pdfView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_guitar__offline__chords, container, false);

        pdfView=view.findViewById(R.id.pdfViewGuitarChords);
        pdfView.fromAsset("MajorMinorChords.pdf").load();

        return view;
    }
}