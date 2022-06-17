package fr.soumiabrk.patientapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mikhaellopez.circularimageview.CircularImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AppointmentList extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    CircularImageView image_vaccin;
    ImageView listappointement_image_profil;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<AppointmentListModel> appointmentList;
    AdapterListAppointment adapter;
    private TextView NameListappointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_list);
        listappointement_image_profil=findViewById(R.id.listappointement_image_profil);
        floatingActionButton = findViewById(R.id.floatingbutton);
        NameListappointment = findViewById(R.id.listAppointment_NameUser);
        image_vaccin = findViewById(R.id.ListAppointment_image_listvaccin);



        String s = getIntent().getStringExtra(EditProfile.MSG);
        TextView tv = findViewById(R.id.listAppointment_NameUser);
        tv.setText(s);

        image_vaccin.setOnClickListener(new View.OnClickListener() {;
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AppointmentList.this, VaccinList.class);
                startActivity(i);
                finish();
            }
        });

        listappointement_image_profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AppointmentList.this, Profile.class);
                startActivity(i);
                finish();
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(AppointmentList.this, Appointment.class);
                startActivity(i);
                finish();
                Toast.makeText(AppointmentList.this, "Prendre un rendez-vous!", Toast.LENGTH_SHORT).show();

            }

        });

        initData();
        initRecyclerView();
    }

    private void initData() {

        appointmentList = new ArrayList<>();
        appointmentList.add(new AppointmentListModel("hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi"));
        appointmentList.add(new AppointmentListModel("hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi"));
        appointmentList.add(new AppointmentListModel("hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi"));
        appointmentList.add(new AppointmentListModel("hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi"));
    }

    private void initRecyclerView() {

        recyclerView = findViewById(R.id.recyclerViewAppointment);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AdapterListAppointment(appointmentList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}