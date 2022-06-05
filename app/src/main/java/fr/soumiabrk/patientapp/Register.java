package fr.soumiabrk.patientapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText Email,Pass,ConfirmPass;
    Button reg;
    TextView Ibtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Email = findViewById(R.id.register_edittext_email);
        Pass = findViewById(R.id.register_edittext_password);
        ConfirmPass= findViewById(R.id.register_edittext_Confirmpassword);
        reg = findViewById(R.id.register_button_inscrire);
        Ibtn = findViewById(R.id.register_text_title);


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Mail,passw,Cpassw;

                Mail = Email.getText().toString();
                passw = Pass.getText().toString();
                Cpassw = ConfirmPass.getText().toString();

                if(Mail.equals(""));{
                    Toast.makeText(Register.this, "Email est vide", Toast.LENGTH_SHORT).show();
                }
                if(passw.equals(""));{
                    Toast.makeText(Register.this, "mot de passe est vide", Toast.LENGTH_SHORT).show();
                }
                if(Cpassw.equals(""));{
                    Toast.makeText(Register.this, "mot de passe est vide", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Ibtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent R = new Intent(Register.this, Login.class);
                                        startActivity(R);
                                        finish();
                                    }

                                }
        );

    }
}