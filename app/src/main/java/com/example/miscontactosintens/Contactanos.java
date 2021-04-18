package com.example.miscontactosintens;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;

public class Contactanos extends AppCompatActivity {


    private TextInputEditText textNombre;
    private TextInputEditText textCorreo;
    private TextInputEditText textDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactanos);
        textNombre = findViewById(R.id.textNombre);
        textDescripcion = findViewById(R.id.texteMensaje);
        textCorreo = findViewById(R.id.textEmail);
        Toolbar miBar= findViewById(R.id.miActionBar2);
        setSupportActionBar(miBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void mandarDatos(View view) {
        String nombre, mensaje, correo;
        nombre = textNombre.getText().toString();
        correo = textCorreo.getText().toString();
        mensaje = textDescripcion.getText().toString();
        if (nombre.equals("")) {
            Toast.makeText(getBaseContext(), "Escriba Nombre", Toast.LENGTH_SHORT).show();
        } else {

            if (correo.equals("")) {
                Toast.makeText(getBaseContext(), "Escriba Correo", Toast.LENGTH_SHORT).show();
            } else {

                        /*
                        Toast.makeText(getBaseContext(),correo,Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(Contactanos.this,ConfirmarDatos.class);
                        intent.putExtra(getResources().getString(R.string.pnombre),nombre);
                        intent.putExtra(getResources().getString(R.string.ptelefono),telefono);
                        intent.putExtra(getResources().getString(R.string.pemail),correo);
                        intent.putExtra(getResources().getString(R.string.pfecha),fecha);
                        intent.putExtra(getResources().getString(R.string.pdescripcion),mensaje);
                        startActivity(intent);
                        finish();*/
            }
        }
    }
    public void enviarEmail(View view){
        String mail=textCorreo.getText().toString();
        Intent emailInten=new Intent((Intent.ACTION_SEND));
        emailInten.setData(Uri.parse("mailito:"));
        emailInten.putExtra(Intent.EXTRA_EMAIL, mail);
        emailInten.setType("message/rfc822");
        startActivity(Intent.createChooser(emailInten,"Email"));
    }
}
