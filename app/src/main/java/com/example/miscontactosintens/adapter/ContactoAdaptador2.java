package com.example.miscontactosintens.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miscontactosintens.R;
import com.example.miscontactosintens.pojo.Mascotas;

import java.util.ArrayList;


public class ContactoAdaptador2 extends RecyclerView.Adapter<ContactoAdaptador2.ContactoViewHolder>{

    ArrayList<Mascotas> mascotas;
    Activity activity;
    public ContactoAdaptador2(ArrayList<Mascotas> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity=activity;
    }
    //inflar el layout y lo pasara  al viewholder para que obtenga los viewa
    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas2,parent,false);
        return new ContactoViewHolder(v);
    }
    // asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder contactoViewHolder, int position) {
        Mascotas mascotas = this.mascotas.get(position);

        contactoViewHolder.imgFoto.setImageResource(mascotas.getFoto());
        contactoViewHolder.textLikes.setText(mascotas.getLinkes()+"");

    }

    @Override
    public int getItemCount() { //cantidad de elementos que contiene mi lista
        return mascotas.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFoto;
        private TextView textNombre;
        private TextView textLikes;
        private ImageView btnLike;
        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto     = itemView.findViewById(R.id.imgFoto);
            textNombre  = itemView.findViewById(R.id.textNombre);
            textLikes = itemView.findViewById(R.id.textLikes);
            btnLike= itemView.findViewById(R.id.btnLike);

        }
    }
}
