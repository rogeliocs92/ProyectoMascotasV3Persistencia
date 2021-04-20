package com.example.miscontactosintens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

import com.example.miscontactosintens.adapter.ContactoAdaptador;
import com.example.miscontactosintens.adapter.ContactoAdaptador2;
import com.example.miscontactosintens.db.BaseDatos;
import com.example.miscontactosintens.fragments.IReciclerViewFragmentView;
import com.example.miscontactosintens.pojo.Mascotas;
import com.example.miscontactosintens.presentador.IReciclerViewFragmentPresenter;
import com.example.miscontactosintens.presentador.PerfilFragmentPresenter;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class Detalle_Likes extends AppCompatActivity implements IReciclerViewFragmentView {

    private RecyclerView listaContactos;
    ArrayList<Mascotas> mascotas;
    IReciclerViewFragmentPresenter presenter;
    TextView textViewNombre;
    CircularImageView circularImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle__likes);
        Toolbar miBar= findViewById(R.id.miActionBar2);
        setSupportActionBar(miBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        circularImageView=findViewById(R.id.circularImageView);
        textViewNombre= findViewById(R.id.textViewNombre);
        listaContactos= findViewById(R.id.reclyContactos);
        BaseDatos db=new BaseDatos(getApplicationContext());
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
        presenter= new PerfilFragmentPresenter(this,getApplicationContext());

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
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
        ContactoAdaptador2 adaptador=new ContactoAdaptador2(mascotas,this);
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
        GridLayoutManager glm=new GridLayoutManager(this,3);
        listaContactos.setLayoutManager(glm);
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