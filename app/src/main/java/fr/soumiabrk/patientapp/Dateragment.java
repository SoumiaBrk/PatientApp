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
    private TextView texthour;

    public TextView previewSelectedTimeTextView;
    private final TimePickerDialog.OnTimeSetListener timePickerDialogListener = (TimePickerDialog.OnTimeSetListener)(new TimePickerDialog.OnTimeSetListener() {

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            String formattedTime = hourOfDay == 0 ?
                    (minute < 10 ?
                      hourOfDay + 12 + ":0" + minute + " am"
                            : "" + (hourOfDay + 12) + ':' + minute + " am")
                    : (hourOfDay > 12 ?
                    (minute < 10 ?
                            hourOfDay - 12 + ":0" + minute + " pm"
                            : "" + (hourOfDay - 12) + ':' + minute + " pm") :
                    (hourOfDay == 12 ?
                            (minute < 10 ? hourOfDay + ":0" + minute + " pm"
                                    : "" + hourOfDay + ':' + minute + " pm")
                            : (minute < 10 ? "" + hourOfDay + ':' + minute + " am"
                            : "" + hourOfDay + ':' + minute + " am")));
        }
    });

    @NotNull
    public final TextView getPreviewSelectedTimeTextView() {
        TextView buttonhour = this.previewSelectedTimeTextView;
        if (buttonhour == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previewSelectedTimeTextView");
        }

        return buttonhour;
    }

    public final void setPreviewSelectedTimeTextView(@NotNull TextView var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.previewSelectedTimeTextView = var1;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_dateragment, container, false);


        buttonhour = rootView.findViewById(R.id.pick_time_button);
        texthour = rootView.findViewById(R.id.preview_picked_time_textView);



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


    }



}

