package fr.soumiabrk.patientapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SetPassword extends AppCompatActivity {

    ImageView arrow;
    AppCompatButton changerpass;
    TextView annuler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);

        arrow = findViewById(R.id.setpasssword_arrow);
        annuler = findViewById(R.id.setpassword_button_annuler);
        changerpass = findViewById(R.id.setpasssword_changerMotpasse);


        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetPassword.this,ForgotPassword.class);
                startActivity(intent);
                finish();
            }
        });

        annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetPassword.this,ForgotPassword.class);
                startActivity(intent);
                finish();
            }
        });
        changerpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetPassword.this,Profile.class);
                startActivity(intent);
                finish();
            }
        });
    }
}