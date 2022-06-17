package fr.soumiabrk.patientapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{


    private List<ModelClass> centreList;
    public Adapter(List<ModelClass>centreList){
        this.centreList=centreList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        int ressource = centreList.get(position).getImageview1();
        String name = centreList.get(position).getTextview1();
        String msg = centreList.get(position).getTextview3();
        String address = centreList.get(position).getTextview2();
        String line=centreList.get(position).getDivider();


        holder.setData1(ressource,name,msg,address,line);

    }

    @Override
    public int getItemCount() {
        return centreList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private ImageView imageView;
        private TextView textView1;
        private TextView textView2;
        private TextView textView3;
        private TextView divider;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageview1);
            textView1 = itemView.findViewById(R.id.textview);
            textView2 = itemView.findViewById(R.id.textview2);
            textView3 = itemView.findViewById(R.id.textview3);
            divider = itemView.findViewById(R.id.textview4);



        }

        public void setData1(int ressource, String name, String msg, String address, String line) {

            imageView.setImageResource(ressource);
            textView1.setText(name);
            textView3.setText(msg);
            textView2.setText(address);
            divider.setText(line);
        }

    }
}
