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


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CenterFragment extends Fragment{
    private Button nextButton;
    private  Button skipButton;


    RecyclerView recyclerView;
    List<ModelClass> centreList;
    Adapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_center, container, false);
        nextButton= rootView.findViewById(R.id.nextbtn);
        skipButton = rootView.findViewById(R.id.skipButton);

        recyclerView = rootView.findViewById(R.id.recyclerView);

        initData();
        initRecyclerView();

        return rootView;
    }

    private void initRecyclerView() {

        //recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(centreList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void initData() {
        centreList = new ArrayList<>();

        centreList.add(new ModelClass(R.drawable.covid1,"Centre 1", "Adresse","Polyclinique","--------------------------------------"));
        centreList.add(new ModelClass(R.drawable.covid2,"Centre 2", "Adresse","Centre de vaccination","--------------------------------------"));
        centreList.add(new ModelClass(R.drawable.covid3,"Centre 3", "Adresse","Polyclinique","--------------------------------------"));
        centreList.add(new ModelClass(R.drawable.covid4,"Centre 4", "Adresse","Centre de vaccination","--------------------------------------"));
        centreList.add(new ModelClass(R.drawable.covid2,"Centre 5", "Adresse","Polyclinique","--------------------------------------"));
        centreList.add(new ModelClass(R.drawable.covid2,"Centre 5", "Adresse","Polyclinique","--------------------------------------"));
        centreList.add(new ModelClass(R.drawable.covid2,"Centre 5", "Adresse","Polyclinique","--------------------------------------"));
        centreList.add(new ModelClass(R.drawable.covid2,"Centre 5", "Adresse","Polyclinique","--------------------------------------"));
        centreList.add(new ModelClass(R.drawable.covid2,"Centre 5", "Adresse","Polyclinique","--------------------------------------"));
        centreList.add(new ModelClass(R.drawable.covid2,"Centre 5", "Adresse","Polyclinique","--------------------------------------"));
        centreList.add(new ModelClass(R.drawable.covid2,"Centre 5", "Adresse","Polyclinique","--------------------------------------"));
        centreList.add(new ModelClass(R.drawable.covid2,"Centre 5", "Adresse","Polyclinique","--------------------------------------"));
        centreList.add(new ModelClass(R.drawable.covid2,"Centre 5", "Adresse","Polyclinique","--------------------------------------"));
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nextButton.setOnClickListener(v -> {
            ((Appointment)getActivity()).next();
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

