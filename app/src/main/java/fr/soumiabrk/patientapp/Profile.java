package fr.soumiabrk.patientapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    private  TextView SeDeconnecter;
    private TextView nom,prenom,email,dateNaissance,sexe, changePass;
    private ImageView arrow;
    private TextView editeProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        changePass = findViewById(R.id.profil_chanagepassword);
        arrow = (ImageView) findViewById(R.id.profil_image_arrow);
        nom=(TextView) findViewById(R.id.nom);
        SeDeconnecter=(TextView) findViewById(R.id.tollbar_text_SeDeconnecter);
        prenom=(TextView) findViewById(R.id.prenom);
        email=(TextView) findViewById(R.id.email);
        dateNaissance=(TextView) findViewById(R.id.dateNaissance);
        sexe=(TextView) findViewById(R.id.sexe);
        editeProfile = (TextView) findViewById(R.id.profil_text_editerprofl);


        // Obtenez les données transférées de l'activité source.
        Intent intent = getIntent();

        nom.setText(intent.getStringExtra("nom"));
        prenom.setText(intent.getStringExtra("prenom"));
        email.setText(intent.getStringExtra("email"));
        dateNaissance.setText(intent.getStringExtra("date_naissance"));
        sexe.setText(intent.getStringExtra("sexe"));

        changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Profile.this, ForgotPassword.class);
                startActivity(i);
                finish();
            }
        });

        SeDeconnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Profile.this, Login.class);
                startActivity(i);
                finish();
            }
        });
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Profile.this, AppointmentList.class);
                startActivity(i);
                finish();
            }
        });

        editeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Profile.this, EditProfile.class);
                startActivity(i);
                finish();
            }
        });

    }

    public void ReturnBack(View view){
        Intent intent= new Intent(getApplicationContext(), EditProfile.class);
        finish();
        startActivity(intent);



    }
}