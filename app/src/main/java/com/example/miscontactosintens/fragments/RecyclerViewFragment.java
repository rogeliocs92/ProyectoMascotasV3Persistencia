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

import com.example.miscontactosintens.MainActivity;
import com.example.miscontactosintens.R;
import com.example.miscontactosintens.adapter.ContactoAdaptador;
import com.example.miscontactosintens.adapter.ContactoAdaptador2;
import com.example.miscontactosintens.pojo.Mascotas;
import com.example.miscontactosintens.presentador.IReciclerViewFragmentPresenter;
import com.example.miscontactosintens.presentador.ReciclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements IReciclerViewFragmentView {

    private RecyclerView listaContactos;
    IReciclerViewFragmentPresenter presenter;
    MainActivity mainActivity;

    public RecyclerViewFragment(MainActivity mainActivity) {
        this.mainActivity=mainActivity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v=inflater.inflate(R.layout.fragment_recyclerview,container,false);
        listaContactos= v.findViewById(R.id.reclyContactos);
        presenter= new ReciclerViewFragmentPresenter(this,getContext());
        return v;
    }

    @Override
    public void generarLinerLayaoutVertical() {
        LinearLayoutManager lln=new LinearLayoutManager(getActivity());
        lln.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(lln);
    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Mascotas> mascotas) {
        ContactoAdaptador adaptador=new ContactoAdaptador(mascotas,getActivity(),mainActivity);
        return adaptador;
    }

    @Override
    public ContactoAdaptador2 crearAdaptador2(ArrayList<Mascotas> mascotas) {
        return null;
    }


    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador contactoAdaptador) {
        listaContactos.setAdapter(contactoAdaptador);
    }

    @Override
    public void inicializarAdaptadorRV2(ContactoAdaptador2 contactoAdaptador2) {

    }

    @Override
    public void generarGirdLayaout() {

    }
}
