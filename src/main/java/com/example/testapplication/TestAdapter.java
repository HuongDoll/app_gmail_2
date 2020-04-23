package com.example.testapplication;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    List<TestModel> itempall;
    List<TestModel> itemp;
    Boolean favorite;

    public TestAdapter(List<TestModel> itemps) {
        this.itempall = itemps;
        itemp=new ArrayList<>();
        itemp.addAll(itempall);
        this.favorite=false;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public void favorite(){
        itemp.clear();
        for (TestModel test: itempall){
            if(test.getIssellect()) itemp.add(test);
            notifyDataSetChanged();
        }
    }

    public void nosearch(){
        itemp.clear();
        itemp.addAll(itempall);
        notifyDataSetChanged();
    }

    public void search(String keyword){
        itemp.clear();
        for (TestModel test: itempall){
            if(test.getName().contains(keyword) || test.getMessage().contains(keyword)){
                itemp.add(test);
            }
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mini_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder=(ViewHolder) holder;
        TestModel temp= itemp.get(position);
        viewHolder.name.setText(temp.getName());
        viewHolder.avt.setText(temp.getName().substring(0,1));
        viewHolder.avt.getBackground().setColorFilter(new PorterDuffColorFilter(temp.getPic(), PorterDuff.Mode.SRC_ATOP));
        viewHolder.message.setText(temp.getMessage());
        viewHolder.time.setText(temp.getTime());
        if(temp.issellect){
            viewHolder.image.setImageResource(R.drawable.full);
        }else viewHolder.image.setImageResource(R.drawable.unfull);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return itemp.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView avt;
        TextView message;
        TextView time;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.name);
            avt=itemView.findViewById(R.id.avt);
            message=itemView.findViewById(R.id.message);
            time=itemView.findViewById(R.id.time);
            image=itemView.findViewById(R.id.image);

            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!favorite){
                        Boolean issellect=itemp.get(getAdapterPosition()).getIssellect();
                        itemp.get(getAdapterPosition()).setIssellect(!issellect);
                        notifyDataSetChanged();
                    }else {
                        Boolean issellect=itemp.get(getAdapterPosition()).getIssellect();
                        itemp.get(getAdapterPosition()).setIssellect(!issellect);
                        itemp.remove(itemp.get(getAdapterPosition()));
                        notifyDataSetChanged();
                    }

                }
            });
        }
    }
}
