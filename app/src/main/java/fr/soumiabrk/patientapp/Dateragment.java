package fr.soumiabrk.patientapp;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.TimePicker;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;

import kotlin.jvm.internal.Intrinsics;


public class Dateragment extends Fragment {

    private Button nextButton;
    private Button previousButton;
    private  Button skipButton;


    private CalendarView calendarview;
    private TextView mydate;
    private Button enregistrer;
    private  Button buttonhour;
    int  hour , minute ;
    private Context applicationContext;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_dateragment, container, false);


        buttonhour = rootView.findViewById(R.id.pick_time_button);




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


            buttonhour.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                            hour = selectedHour;
                            minute = selectedMinute;
                            buttonhour.setText(String.format(Locale.getDefault(), "%02d:%02d", hour, minute));
                        }
                    };
                    TimePickerDialog timePickerDialog = new TimePickerDialog(
                            applicationContext,
                            /*style,*/ onTimeSetListener,
                            hour,
                            minute,
                            true);

                    timePickerDialog.setTitle("Sélectionnez l'heure");
                    timePickerDialog.show();

                }
            });
                }




    }



