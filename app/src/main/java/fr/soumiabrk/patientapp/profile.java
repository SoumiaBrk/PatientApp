package fr.soumiabrk.patientapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class profile extends AppCompatActivity {

    private  TextView SeDeconnecter;
    private TextView nom,prenom,email,dateNaissance,sexe;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        nom=(TextView) findViewById(R.id.nom);
        prenom=(TextView) findViewById(R.id.prenom);
        email=(TextView) findViewById(R.id.email);
        dateNaissance=(TextView) findViewById(R.id.dateNaissance);
        sexe=(TextView) findViewById(R.id.sexe);


        // Obtenez les données transférées de l'activité source.
        Intent intent = getIntent();

        nom.setText(intent.getStringExtra("nom"));
        prenom.setText(intent.getStringExtra("prenom"));
        email.setText(intent.getStringExtra("email"));
        dateNaissance.setText(intent.getStringExtra("date_naissance"));
        sexe.setText(intent.getStringExtra("sexe"));

    }

    public void ReturnBack(View view){
        Intent intent= new Intent(getApplicationContext(), editProfile.class);
        finish();
        startActivity(intent);

        SeDeconnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(profile.this, Login.class);
                startActivity(i);
                finish();
            }
        });

    }
}