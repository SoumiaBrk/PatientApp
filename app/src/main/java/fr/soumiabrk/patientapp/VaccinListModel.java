package fr.soumiabrk.patientapp;

public class VaccinListModel {


    private  String namevaccin,dosevaccin,datevaccin,brasvaccin;
    VaccinListModel(String namevaccin, String dosevaccin, String datevaccin, String brasvaccin){
        this.brasvaccin = brasvaccin;
        this.namevaccin = namevaccin;
        this.dosevaccin = dosevaccin;
        this.datevaccin = datevaccin;
    }

    public String getBrasvaccin() {return brasvaccin;}

    public String getDatevaccin() {return datevaccin;}

    public String getDosevaccin() {return dosevaccin;}

    public String getNamevaccin() {return namevaccin;}

}
