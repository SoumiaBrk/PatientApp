package fr.soumiabrk.patientapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterListAppointment extends RecyclerView.Adapter<AdapterListAppointment.ViewHolder> {
    private List<AppointmentListModel>appointementList;

    public AdapterListAppointment(List<AppointmentListModel>appointementList){
        this.appointementList=appointementList;}


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_apointment_design, parent, false);
        return new ViewHolder(view);
    }
        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            String att1 = appointementList.get(position).getAppointement_month();
            String att2 = appointementList.get(position).getAppointement_day();
            String att3 = appointementList.get(position).getAppointement_day_name();
            String att4 = appointementList.get(position).getTime();
            String att5 = appointementList.get(position).getDoctor_view_title();
            String att6=appointementList.get(position).getText_view_description2();
            String att7=appointementList.get(position).getText_view_description();
            String att8=appointementList.get(position).getVaccin();
            String att9=appointementList.get(position).getDoctor_name2();

            holder.setData2(att1, att2, att3, att4, att5, att6, att7, att8, att7, att9);
        }

    @Override
    public int getItemCount() {
        return appointementList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView appointement_month;
        private TextView appointement_day;
        private TextView appointement_day_name;
        private TextView time;
        private TextView doctor_view_title;
        private TextView text_view_description2;
        private TextView text_view_description;
        private TextView vaccin;
        private TextView doctor_name2;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            appointement_month = itemView.findViewById(R.id.appointement_month);
            appointement_day = itemView.findViewById(R.id.appointement_day);
            appointement_day_name = itemView.findViewById(R.id.appointement_day_name);
            time = itemView.findViewById(R.id.time);
            doctor_view_title = itemView.findViewById(R.id.doctor_view_title);
            text_view_description2 = itemView.findViewById(R.id.text_view_description2);
            text_view_description = itemView.findViewById(R.id.text_view_description);
            vaccin = itemView.findViewById(R.id.vaccin);
            doctor_name2 = itemView.findViewById(R.id.doctor_name2);


        }
        public void setData2(String att1,
                            String att2,
                            String att3,
                            String att4,
                            String att5,
                            String att6,
                            String att7,
                            String att8,
                            String att9,
                            String att10) {

            appointement_month.setText(att1);
            appointement_day.setText(att2);
            appointement_day_name.setText(att3);
            time.setText(att4);
            doctor_view_title.setText(att5);
            text_view_description2.setText(att6);
            text_view_description.setText(att7);
            vaccin.setText(att8);
            doctor_name2.setText(att9);
        }


    }


}
