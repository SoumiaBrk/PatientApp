package fr.soumiabrk.patientapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText email,pass;
    Button login,register;
    TextView btn;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.login_edittext_email);
        pass = findViewById(R.id.login_edittext_password);
        login = findViewById(R.id.login_button_seConnectez);
        register = findViewById(R.id.login_button_inscrire);
        btn = findViewById(R.id.login_text_title);
        image = findViewById(R.id.login_image_loginApp);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail,pas;

                mail = email.getText().toString();
                pas = pass.getText().toString();

                if(mail.equals("")){
                    Toast.makeText(Login.this, "Email est vide",Toast.LENGTH_LONG).show();
                }
                else if(pas.equals("")){
                    Toast.makeText(Login.this, "Le mot de passe est vide",Toast.LENGTH_LONG).show();
                }
                else{
                    //Authentcion
                }
            }

        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, register.class);
                startActivity(i);
                finish();
            }
        });
    }
}