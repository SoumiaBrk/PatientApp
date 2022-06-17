package fr.soumiabrk.patientapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ResumeFragment extends Fragment {

    private Button previousButton;
    private  Button skipButton;
    private  Button  btn_confirm;
    private TextView dose;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_resume, container, false);




        previousButton= rootView.findViewById(R.id.backbtn);
        skipButton = rootView.findViewById(R.id.skipButton);
        btn_confirm = rootView.findViewById(R.id.btn_confirm);




        return rootView;
    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        previousButton.setOnClickListener(v -> {
            ((Appointment)getActivity()).back();

        });
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent((Appointment)getActivity(), AppointmentList.class);
                startActivity(i);
            }
        });
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent((Appointment)getActivity(), AppointmentList.class);
                startActivity(i);
            }
        });

    }
}