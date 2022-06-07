package fr.soumiabrk.patientapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class CenterFragment extends Fragment{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_center, container, false);

        Button button = (Button) rootView.findViewById(R.id.nextbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment DoseFragment= new Fragment();
                FragmentTransaction nextFrag= getActivity().getSupportFragmentManager().beginTransaction();
                nextFrag.replace(R.id.fitDose, DoseFragment, "findThisFragment").commit();

            }
        });

        return rootView;
    }


}


