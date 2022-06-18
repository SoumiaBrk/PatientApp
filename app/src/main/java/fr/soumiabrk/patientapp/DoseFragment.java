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
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class DoseFragment extends Fragment {

    private Button nextButton;
    private Button previousButton;
    private  Button skipButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_dose, container, false);

        nextButton= rootView.findViewById(R.id.nextbtn);
        previousButton= rootView.findViewById(R.id.backbtn);
        skipButton = rootView.findViewById(R.id.skipButton);



        RadioGroup radioGroup = rootView.findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
                    case R.id.radioButton1:

                        break;
                    case R.id.radioButton2:

                        break;
                    case R.id.radioButton3:

                        break;
                }
            }
        });



        return rootView;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        nextButton.setOnClickListener(v -> {
            ((Appointment)getActivity()).next();
        });

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


    }
}
