package com.example.dorys.proyectos.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dorys.proyectos.R;

import com.example.dorys.proyectos.model.Proyecto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dorys on 20/09/2017.
 */

public class ProyectoAdapter extends RecyclerView.Adapter<ProyectoAdapter.DeviceViewHolder>
{

    private Context context;
    private List<Proyecto> dataset;
    private OnProyectoSelectedListener onProyectoSelectedListener;

    public interface OnProyectoSelectedListener {
        void onProyectoSelected(Proyecto departamento);
    }

    public ProyectoAdapter(Context context, OnProyectoSelectedListener listener) {
        this.dataset = new ArrayList<>();
        this.context = context;
        this.onProyectoSelectedListener = listener;
    }

    @Override
    public DeviceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_proyectos, parent, false);
        return new DeviceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DeviceViewHolder holder, int position) {
        Proyecto u = dataset.get(position);
        holder.provinciaTextView.setText(u.getProvincia());
        holder.descripcionTextView.setText(u.getDescripcionProyecto());
        holder.departamentoTextView.setText(u.getDepartamento());

        String url="https://cdccba.files.wordpress.com/2012/11/cochabamba-ciudad.jpg";
        Glide.with(context).load(url).into(holder.ImagenImageView);

        holder.setDeviceSelectedListener(u, onProyectoSelectedListener);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }



    public static class DeviceViewHolder extends RecyclerView.ViewHolder {

        View cardView;

        TextView provinciaTextView;
        TextView descripcionTextView;
        TextView departamentoTextView;
        ImageView ImagenImageView;


        public DeviceViewHolder(View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardView);

            provinciaTextView = (TextView) itemView.findViewById(R.id.provinciaTextView);
            descripcionTextView = (TextView) itemView.findViewById(R.id.descripcionTextView);
            departamentoTextView = (TextView) itemView.findViewById(R.id.departamentoTextView);
            ImagenImageView = (ImageView) itemView.findViewById(R.id.ImagenImageView);
        }

        public void setDeviceSelectedListener(final Proyecto departamento, final OnProyectoSelectedListener onProyectoSelectedListener) {
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onProyectoSelectedListener.onProyectoSelected(departamento);
                }
            });
        }

    }

    public void add(Proyecto proyecto) {
        dataset.add(proyecto);
        notifyDataSetChanged();
    }

    public void setDataset(List<Proyecto> proyecto) {
        if (proyecto == null) {
            dataset = new ArrayList<>();
        } else {
            dataset = proyecto;
        }
        notifyDataSetChanged();
    }

    public void clear() {
        dataset.clear();
        notifyDataSetChanged();
    }

}
