package fr.soumiabrk.patientapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class VaccinList extends AppCompatActivity {


    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<VaccinListModel> vaccinList;
    AdapterListVaccin adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccin_list);



        initData();
        initRecyclerView();
    }

    private void initRecyclerView() {

        recyclerView = findViewById(R.id.vaccinlis_recyclerView);
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