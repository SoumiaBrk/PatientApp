package fr.soumiabrk.patientapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterListVaccin extends RecyclerView.Adapter<AdapterListVaccin.ViewHolder> {

    private List<VaccinListModel> VaccinList;
    public AdapterListVaccin(List<VaccinListModel>VaccinList){
        this.VaccinList=VaccinList;
    }


    @NonNull
    @Override
    public AdapterListVaccin.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_vaccin_design, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListVaccin.ViewHolder holder, int position) {

        String brasvaccin = VaccinList.get(position).getBrasvaccin();
        String datevaccin = VaccinList.get(position).getDatevaccin();
        String dosevaccin = VaccinList.get(position).getDosevaccin();
        String namevaccin = VaccinList.get(position).getNamevaccin();


        holder.setData(namevaccin,dosevaccin,datevaccin,brasvaccin);


    }

    @Override
    public int getItemCount() {
        return VaccinList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView brasvac;
        private TextView namevac;
        private TextView dosevac;
        private TextView datevac;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            brasvac= itemView.findViewById(R.id.vaccin_bras);
            namevac = itemView.findViewById(R.id.listvaccin_name);
            dosevac = itemView.findViewById(R.id.listvaccin_dose);
            datevac = itemView.findViewById(R.id.listvaccin_date);



        }

        public void setData( String namevaccin, String dosevaccin, String datevaccin,String brasvaccin ) {

            brasvac.setText(brasvaccin);
            namevac.setText(namevaccin);
            dosevac.setText(dosevaccin);
            datevac.setText(datevaccin);

        }
    }
}
