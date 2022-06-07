package fr.soumiabrk.patientapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListAppointments extends AppCompatActivity {
    
        FloatingActionButton floatingActionButton;
        private ImageView profile;
        private TextView NameUser;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_appointments);

        profile = findViewById(R.id.listappointement_image_profil);
        floatingActionButton = findViewById(R.id.floatingbutton);
        NameUser = findViewById(R.id.listAppointment_NameUser);

        String s = getIntent().getStringExtra(EditProfile.MSG);  //récupérer le nom envoyé par EditProfil
        NameUser.setText(s);  //afficher le nom dans un TextView

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListAppointments.this, Profile.class);
                startActivity(i);
                finish();
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(ListAppointments.this, Appointment.class);
                startActivity(i);
                finish();
                Toast.makeText(ListAppointments.this, "Prendre un-vous!", Toast.LENGTH_SHORT).show();
                
            }

        }); 
        
        
    }


}