package com.example.miscontactosintens.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.miscontactosintens.R;
import com.example.miscontactosintens.pojo.Mascotas;

import java.util.ArrayList;

public class ConstructorContactos {

    private static final int LIKE =1;
    private Context context;
    public ConstructorContactos(Context context) {
        this.context=context;
    }

    public ArrayList<Mascotas> obtenerDatos(){
       /*ArrayList<Mascotas>  mascotas =new ArrayList<>();
        mascotas.add(new Mascotas(R.drawable.perrito1,"Chiquitin",10));
        mascotas.add(new Mascotas(R.drawable.perrito2,"Bolita      ", 3));
        mascotas.add(new Mascotas(R.drawable.perrito3,"Dormilon", 8));
        mascotas.add(new Mascotas(R.drawable.perrito4,"Chatito      ", 7));
        mascotas.add(new Mascotas(R.drawable.perrito5,"Coqueta      ", 4));
        return mascotas;*/
        BaseDatos db=new BaseDatos(context);
        if(!db.verificarExistenMascotas()){
            insertarCincoContactos(db);
        }
        return db.obtenerTodosMascotas();
    }

    public void insertarCincoContactos(BaseDatos db){
        ContentValues contentValues=new ContentValues();
        contentValues.put(ConstanstesBasesDatos.TABLE_MASCOTAS_NOMBRE,"Chiquitin");
        contentValues.put(ConstanstesBasesDatos.TABLE_MASCOTAS_FOTO,R.drawable.perrito1);
        db.insertarMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstanstesBasesDatos.TABLE_MASCOTAS_NOMBRE,"Bolita");
        contentValues.put(ConstanstesBasesDatos.TABLE_MASCOTAS_FOTO,R.drawable.perrito2);
        db.insertarMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstanstesBasesDatos.TABLE_MASCOTAS_NOMBRE,"Dormilon");
        contentValues.put(ConstanstesBasesDatos.TABLE_MASCOTAS_FOTO,R.drawable.perrito3);
        db.insertarMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstanstesBasesDatos.TABLE_MASCOTAS_NOMBRE,"Chatito");
        contentValues.put(ConstanstesBasesDatos.TABLE_MASCOTAS_FOTO,R.drawable.perrito4);
        db.insertarMascotas(contentValues);

        contentValues=new ContentValues();
        contentValues.put(ConstanstesBasesDatos.TABLE_MASCOTAS_NOMBRE,"Coqueta");
        contentValues.put(ConstanstesBasesDatos.TABLE_MASCOTAS_FOTO,R.drawable.perrito5);
        db.insertarMascotas(contentValues);
    }

    public void darLikeMascota(Mascotas mascotas){
        BaseDatos db=new BaseDatos(context);
        ContentValues contentValues=new ContentValues();
        contentValues.put(ConstanstesBasesDatos.TABLE_MASCOTAS_LIKES_IDMASCOTA,mascotas.getId());
        contentValues.put(ConstanstesBasesDatos.TABLE_MASCOTAS_LIKES_NLIKES,LIKE);
        db.insertarLikeMascota(contentValues);

    }
    public int obtenerLikesMascotas(Mascotas mascotas){
        BaseDatos db=new BaseDatos(context);
        return db.obtenerLikesMascotas(mascotas);
    }
}
