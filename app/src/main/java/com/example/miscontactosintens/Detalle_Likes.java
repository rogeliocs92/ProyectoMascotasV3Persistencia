package com.example.miscontactosintens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import com.example.miscontactosintens.adapter.ContactoAdaptador;
import com.example.miscontactosintens.adapter.ContactoAdaptador2;
import com.example.miscontactosintens.pojo.Mascotas;

import java.util.ArrayList;

public class Detalle_Likes extends AppCompatActivity {

    private RecyclerView listaContactos;
    ArrayList<Mascotas> mascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle__likes);
        Toolbar miBar= findViewById(R.id.miActionBar2);
        setSupportActionBar(miBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listaContactos= findViewById(R.id.reclyContactos);
        //ver como lineal


        GridLayoutManager glm=new GridLayoutManager(this,3);
        listaContactos.setLayoutManager(glm);


        iniciarlizarListaContactos();
        inicializarAdaptador();

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
    public void inicializarAdaptador(){
        ContactoAdaptador2 adaptador=new ContactoAdaptador2(mascotas,this);
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
    /*
    public void llamar(View view){
        String telefono= textLikes.getText().toString();
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+telefono)));
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + telefono));
        if (intent.resolveActivity(getPackageManager()) != null) {
            Toast.makeText(getBaseContext(),"Entro al if",Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }else{
            Toast.makeText(getBaseContext(),"Entro al else",Toast.LENGTH_SHORT).show();
        }
    }*/
    /*
    public void enviarEmail(View view){
        String mail=textCorreo.getText().toString();
        Intent emailInten=new Intent((Intent.ACTION_SEND));
        emailInten.setData(Uri.parse("mailito:"));
        emailInten.putExtra(Intent.EXTRA_EMAIL, mail);
        emailInten.setType("message/rfc822");
        startActivity(Intent.createChooser(emailInten,"Email"));
    }*/


}