package com.example.miscontactosintens.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miscontactosintens.R;
import com.example.miscontactosintens.adapter.ContactoAdaptador2;
import com.example.miscontactosintens.pojo.Mascotas;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {
    private RecyclerView listaContactos;
    ArrayList<Mascotas> mascotas;
    public PerfilFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v=inflater.inflate(R.layout.fragment_perfil_fragmentt,container,false);
        //ver como lineal
        listaContactos= v.findViewById(R.id.reclyContactosFragment);
        //ver como lineal
        GridLayoutManager glm=new GridLayoutManager(getActivity(),3);
        listaContactos.setLayoutManager(glm);
        iniciarlizarListaContactos();
        inicializarAdaptador();
        return v;
    }
    public void inicializarAdaptador(){
        ContactoAdaptador2 adaptador=new ContactoAdaptador2(mascotas,getActivity());
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
