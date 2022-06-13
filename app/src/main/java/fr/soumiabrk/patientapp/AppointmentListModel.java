package fr.soumiabrk.patientapp;

import android.widget.TextView;

public class AppointmentListModel {
    private  String appointement_month,
            appointement_day,
            appointement_day_name,time,
            doctor_view_title,
            text_view_description2,
            text_view_description,
            vaccin,
            doctor_name2,
            voir_fiche_btn2;


    AppointmentListModel(String appointement_month,
                         String appointement_day,
                         String appointement_day_name,
                         String time,
                         String doctor_view_title,
                         String text_view_description2,
                         String text_view_description,
                         String vaccin) {

        this.appointement_month=appointement_month;
        this.appointement_day = appointement_day;
        this.appointement_day_name = appointement_day_name;
        this.time = time;
        this.doctor_view_title = doctor_view_title;
        this.text_view_description2 = text_view_description2;
        this.text_view_description = text_view_description;
        this.vaccin = vaccin;
        this.doctor_name2 = doctor_name2;
        this.voir_fiche_btn2 = voir_fiche_btn2;
    }

    public String getAppointement_month() {
        return appointement_month;
    }

    public String getAppointement_day() {
        return appointement_day;
    }

    public String getAppointement_day_name() {
        return appointement_day_name;
    }

    public String getTime() {
        return time;
    }

    public String getDoctor_view_title() {
        return doctor_view_title;
    }

    public String getText_view_description2() {
        return text_view_description2;
    }

    public String getText_view_description() {
        return text_view_description;
    }

    public String getVaccin() {
        return vaccin;
    }

    public String getDoctor_name2() {
        return doctor_name2;
    }

}
