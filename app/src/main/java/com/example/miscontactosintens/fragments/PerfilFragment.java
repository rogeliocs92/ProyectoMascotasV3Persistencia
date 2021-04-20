package com.example.miscontactosintens.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miscontactosintens.R;
import com.example.miscontactosintens.adapter.ContactoAdaptador;
import com.example.miscontactosintens.adapter.ContactoAdaptador2;
import com.example.miscontactosintens.db.BaseDatos;
import com.example.miscontactosintens.pojo.Mascotas;
import com.example.miscontactosintens.presentador.IReciclerViewFragmentPresenter;
import com.example.miscontactosintens.presentador.PerfilFragmentPresenter;
import com.example.miscontactosintens.presentador.ReciclerViewFragmentPresenter;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class PerfilFragment extends Fragment implements IReciclerViewFragmentView{
    private RecyclerView listaContactos;
    ArrayList<Mascotas> mascotas;
    IReciclerViewFragmentPresenter presenter;
    TextView textViewNombre;
    CircularImageView circularImageView;

    public PerfilFragment(ArrayList<Mascotas> mascotas){
        this.mascotas=mascotas;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v=inflater.inflate(R.layout.fragment_perfil_fragmentt,container,false);
        listaContactos= v.findViewById(R.id.reclyContactosFragment);
        circularImageView=v.findViewById(R.id.circularImageViewPerfil);
        textViewNombre= v.findViewById(R.id.textViewPerfil);
        BaseDatos db=new BaseDatos(getContext());
        mascotas=db.obtenerTodosMascotas();
        int likeMayor=0;
        int idLikeMayor=0;
        for(int i=0; i<mascotas.size();i++){
            if(likeMayor<=mascotas.get(i).getLinkes()){
                likeMayor=mascotas.get(i).getLinkes();
                idLikeMayor=i;
            }
        }
        textViewNombre.setText(mascotas.get(idLikeMayor).getNombre());
        circularImageView.setImageResource(mascotas.get(idLikeMayor).getFoto());
        presenter= new PerfilFragmentPresenter(this,getContext());
        return v;
    }

    public void setMascotas(ArrayList<Mascotas> mascotas) {
        this.mascotas=mascotas;
    }

    @Override
    public void generarLinerLayaoutVertical() {

    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Mascotas> mascotas) {
        return null;
    }


    @Override
    public ContactoAdaptador2 crearAdaptador2(ArrayList<Mascotas> mascotas) {
        ContactoAdaptador2 adaptador=new ContactoAdaptador2(mascotas,getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador contactoAdaptador) {

    }

    @Override
    public void inicializarAdaptadorRV2(ContactoAdaptador2 contactoAdaptador2) {
        listaContactos.setAdapter(contactoAdaptador2);
    }

    @Override
    public void generarGirdLayaout() {
        //ver como lineal
        GridLayoutManager glm=new GridLayoutManager(getActivity(),3);
        listaContactos.setLayoutManager(glm);
    }
}
