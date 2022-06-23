package fr.soumiabrk.patientapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class VaccinList extends AppCompatActivity {


    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<VaccinListModel> vaccinList;
    AdapterListVaccin adapter;
    View arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccin_list);

        arrow = findViewById(R.id.editprofil_image_arrow);

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VaccinList.this, AppointmentListActivity.class);
                startActivity(i);
                finish();
            }
        });

        initData();
        initRecyclerView();
    }

    private void initRecyclerView() {

        recyclerView = findViewById(R.id.vaccinlist_recyclerView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AdapterListVaccin(vaccinList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initData() {

        vaccinList = new ArrayList<>();
        vaccinList.add(new VaccinListModel("sinovac", "la première dose", "18-05-2022","bras droit"));
        vaccinList.add(new VaccinListModel("sinovac", "la deuxiéme dose", "18-08-2022","bras gauche"));
        vaccinList.add(new VaccinListModel("sinovac", "la troisiéme dose", "18-11-2022","bras droit"));
        vaccinList.add(new VaccinListModel("AstraZeneca", "la première dose", "18-05-2022","bras droit"));
        vaccinList.add(new VaccinListModel("AstraZeneca", "la deuxiéme dose", "18-05-2022","bras droit"));
        vaccinList.add(new VaccinListModel("AstraZeneca", "la troisiéme dose", "18-05-2022","bras gauche"));


    }
}