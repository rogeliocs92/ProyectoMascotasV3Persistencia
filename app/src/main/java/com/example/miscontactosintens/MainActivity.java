package com.example.miscontactosintens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView listaContactos;
    ArrayList<Mascotas> mascotas;
    ImageView imgLike;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar miBar= findViewById(R.id.miActionBar);
        imgLike= findViewById(R.id.nLike);
        imgLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Detalle_Likes.class);
                startActivity(intent);
            }
        });
        setSupportActionBar(miBar);
        listaContactos= findViewById(R.id.reclyContactos);
         //ver como lineal
        LinearLayoutManager lln=new LinearLayoutManager(this);
        lln.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(lln);
        /* ver como gridlayaout
        GridLayoutManager glm=new GridLayoutManager(this,2);
        listaContactos.setLayoutManager(glm);*/
        iniciarlizarListaContactos();
        inicializarAdaptador();

        /* manejado con listview
        ListView listaContactos= findViewById(R.id.listaContactos);
        listaContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,nombresContacto));

        listaContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,Detalle_Contacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre),contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono),contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail),contactos.get(position).getCorreo());
                startActivity(intent);
            }
        });
         */
    }

    public void inicializarAdaptador(){
        ContactoAdaptador adaptador=new ContactoAdaptador(mascotas,this);
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