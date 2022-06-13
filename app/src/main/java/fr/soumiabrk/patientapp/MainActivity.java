package fr.soumiabrk.patientapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Thread thread = new Thread(){

           public void run (){
               try {
                   sleep(2000);
                   Intent intent = new Intent(getApplicationContext(), Login.class);
                   startActivity(intent);
                   finish();

               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       };

       thread.start();

    }
}
