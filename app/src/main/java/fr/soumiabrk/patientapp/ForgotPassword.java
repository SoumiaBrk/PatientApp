package fr.soumiabrk.patientapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ForgotPassword extends AppCompatActivity {

    TextView retour;
    AppCompatButton pageModifierPass;
    ImageView arrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        retour = findViewById(R.id.forgotpass_retour);
        pageModifierPass = findViewById(R.id.forgotpass_rĂ©initiakiserMotPasse);
        arrow = findViewById(R.id.forgotpass_arrow);

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotPassword.this,Profile.class);
                startActivity(intent);
                finish();
            }
        });
        pageModifierPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotPassword.this,SetPassword.class);
                startActivity(intent);
                finish();
            }
        });
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotPassword.this,Profile.class);
                startActivity(intent);
                finish();
            }
        });
    }
}