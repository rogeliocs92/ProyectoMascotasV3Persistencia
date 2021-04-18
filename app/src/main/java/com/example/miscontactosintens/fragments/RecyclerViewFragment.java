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

    public RecyclerViewFragment(ArrayList<Mascotas> mascotas) {
        this.mascotas=mascotas;
    }


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
        inicializarAdaptador();

        return v;
    }
    public void inicializarAdaptador(){
        ContactoAdaptador adaptador=new ContactoAdaptador(mascotas,getActivity());
        listaContactos.setAdapter(adaptador);
    }

}
