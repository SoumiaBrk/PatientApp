package fr.soumiabrk.patientapp;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Locale;


public class Dateragment extends Fragment {

    private Button nextButton;
    private Button previousButton;
    private  Button skipButton;


    private CalendarView calendarview;
    private TextView mydate;
    private Button enregistrer;
    private  Button buttonhour;
    private TextView textHour;
   private int mHour,mMin;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_dateragment, container, false);


        buttonhour = rootView.findViewById(R.id.pick_time_button);

        textHour = rootView.findViewById(R.id.txtView_hour);


        nextButton= rootView.findViewById(R.id.nextbtn);
        previousButton= rootView.findViewById(R.id.backbtn);
        skipButton = rootView.findViewById(R.id.skipButton);
        calendarview = rootView.findViewById(R.id.date_calendar_DateAppointment);
        mydate = rootView.findViewById(R.id.myDate);




        return rootView;

    }

        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
        nextButton.setOnClickListener(v -> {
            ((Appointment)getActivity()).next();
        });
        previousButton.setOnClickListener(v -> {
            ((Appointment)getActivity()).back();

        });


            buttonhour.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Calendar c = Calendar.getInstance();
                    mHour = c.get(Calendar.HOUR_OF_DAY);
                    mMin = c.get(Calendar.MINUTE);



                    TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            textHour.setText(String.format(Locale.getDefault(), "%02d:%02d",hourOfDay, minute));
                        }
                    },mHour,mMin, false);
                    timePickerDialog.show();
                }

            });

        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent((Appointment)getActivity(), AppointmentList.class);
                startActivity(i);
            }
        });


        calendarview.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = (month+1)+"/"+(dayOfMonth)+"/"+year;
                mydate.setText(date);
            }
        });



                }




    }



