package com.example.miscontactosintens.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miscontactosintens.R;
import com.example.miscontactosintens.adapter.ContactoAdaptador;
import com.example.miscontactosintens.pojo.Mascotas;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    private RecyclerView listaContactos;
    ArrayList<Mascotas> mascotas;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v=inflater.inflate(R.layout.fragment_recyclerview,container,false);
         //ver como lineal
        listaContactos= v.findViewById(R.id.reclyContactos);
        LinearLayoutManager lln=new LinearLayoutManager(getActivity());
        lln.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(lln);
        /* ver como gridlayaout
        GridLayoutManager glm=new GridLayoutManager(this,2);
        listaContactos.setLayoutManager(glm);

         */
        iniciarlizarListaContactos();
        inicializarAdaptador();

        return v;
    }
    public void inicializarAdaptador(){
        ContactoAdaptador adaptador=new ContactoAdaptador(mascotas,getActivity());
        listaContactos.setAdapter(adaptador);
    }
    public void iniciarlizarListaContactos(){
        mascotas =new ArrayList<>();
        mascotas.add(new Mascotas(R.drawable.perrito1,"Chiquitin","10"));
        mascotas.add(new Mascotas(R.drawable.perrito2,"Bolita      "," 3"));
        mascotas.add(new Mascotas(R.drawable.perrito3,"Dormilon"," 8"));
        mascotas.add(new Mascotas(R.drawable.perrito4,"Chatito      "," 7"));
        mascotas.add(new Mascotas(R.drawable.perrito5,"Coqueta      "," 4"));
    }
}
