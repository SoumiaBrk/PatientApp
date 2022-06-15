package fr.soumiabrk.patientapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class EditProfile extends AppCompatActivity {

    private Button enregistrer;
    private EditText nom;
    private EditText prenom;
    private EditText email;

    private Spinner jour;
    private Spinner mois;
    private Spinner annee;

    private RadioGroup sexe;

    private ImageView arrow;

    public static String MSG="text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);


        arrow = (ImageView) findViewById(R.id.editprofil_image_arrow);
        enregistrer = (Button) findViewById(R.id.save);

        nom= (EditText) findViewById(R.id.nom);
        prenom= (EditText) findViewById(R.id.prenom);
        email= (EditText) findViewById(R.id.email);

        jour= (Spinner) findViewById(R.id.jours);
        mois= (Spinner) findViewById(R.id.mois);
        annee= (Spinner) findViewById(R.id.annee);

        sexe=(RadioGroup) findViewById(R.id.radioSex);

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditProfile.this,Profile.class);
                startActivity(intent);
                finish();
            }
        });

        enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String msg =prenom.getText().toString();    //récupérer le nom
                Intent i = new Intent(EditProfile.this,AppointmentList.class); //déclarer l'objet intent
                i.putExtra(MSG,msg);                                                      //en specifiant nom de l'activity
                startActivity(i);  //démarrer la deuxieme activity

                String str_nom="";
                String str_prenom="";
                String str_email="";

                int int_jour=0;
                int int_mois=0;
                int int_annee=0;
                String str_date="";

                String str_sexe="";




                //Validation
                boolean info_valable=true; //s'il manque quelque chose, nos changeons cette var en false.

                //s'assurer que ce n'est pas vide

                if(nom.getText().toString().trim().equals("")==false){
                    str_nom=nom.getText().toString().trim();
                }else{
                    info_valable=false;
                }

                if(prenom.getText().toString().trim().equals("")==false){
                    str_prenom=prenom.getText().toString().trim();
                }else{
                    info_valable=false;
                }


                if(email.getText().toString().trim().equals("")==false){
                    str_email=email.getText().toString().trim();
                }else{
                    info_valable=false;
                }


                int_jour=Integer.valueOf(String.valueOf(jour.getSelectedItem()));
                int_mois=Integer.valueOf(String.valueOf(mois.getSelectedItem()));
                int_annee=Integer.valueOf(String.valueOf(annee.getSelectedItem()));

                str_date=String.valueOf(int_jour) + "-" + String.valueOf(int_mois) + "-" + String.valueOf(int_annee) ;

                // obtenir le bouton radio sélectionné de radioGroup
                int selectedId = sexe.getCheckedRadioButtonId();
               // si aucun button radio n'est coché, cette fonction retourne -1

                if (selectedId != -1){
                    RadioButton radioSexButton;
                    radioSexButton = (RadioButton) findViewById(selectedId);
                    str_sexe=radioSexButton.getText().toString();
                }else{
                    info_valable=false;
                }


                // Masquer le clavier lorsque vous appuyez sur le bouton
                //Lors de l'écriture dans un EditText, un clavier apparaît.
                // Nous devons masquer ce clavier lorsque nous cliquons sur
                // un bouton dans le cas où il est toujours affiché.

                InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
//                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);


                if (info_valable==false){
                    Toast.makeText(getApplicationContext(),"Il manque des informations",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(getApplicationContext(), Profile.class);
                    intent.putExtra("nom",str_nom);
                    intent.putExtra("prenom",str_prenom);      //nos envoyons des données
                    intent.putExtra("email",str_email);        // en utilisant putExtra
                    intent.putExtra("date_naissance",str_date);
                    intent.putExtra("sexe",str_sexe);
                    finish();
                    startActivity(intent);
                }

            }
        });



    }
}