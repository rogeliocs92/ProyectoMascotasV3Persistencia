package com.example.miscontactosintens.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.miscontactosintens.pojo.Mascotas;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos(@Nullable Context context) {
        super(context,ConstanstesBasesDatos.DATABASE_NAME,null,ConstanstesBasesDatos.DATABASE_VERSION);
        this.context=context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascotas= "CREATE TABLE "+ ConstanstesBasesDatos.TABLE_MASCOTAS+"(" +
                ConstanstesBasesDatos.TABLE_MASCOTAS_ID     + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstanstesBasesDatos.TABLE_MASCOTAS_NOMBRE + " TEXT, "+
                ConstanstesBasesDatos.TABLE_MASCOTAS_FOTO   + " INTEGER"+
                ")";

        String queryCrearTablaLikes= "CREATE TABLE "+ ConstanstesBasesDatos.TABLE_MASCOTAS_LIKES+"(" +
                ConstanstesBasesDatos.TABLE_MASCOTAS_LIKES_ID     + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstanstesBasesDatos.TABLE_MASCOTAS_LIKES_IDMASCOTA     + " INTEGER, "+
                ConstanstesBasesDatos.TABLE_MASCOTAS_LIKES_NLIKES + " INTEGER, "+
                "FOREIGN KEY ("+ ConstanstesBasesDatos.TABLE_MASCOTAS_LIKES_IDMASCOTA+") "+
                "REFERENCES "+ConstanstesBasesDatos.TABLE_MASCOTAS+"("+ConstanstesBasesDatos.TABLE_MASCOTAS_ID+")"+
                ")";
        db.execSQL(queryCrearTablaMascotas);
        db.execSQL(queryCrearTablaLikes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ConstanstesBasesDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS "+ConstanstesBasesDatos.TABLE_MASCOTAS_LIKES);
        onCreate(db);

    }

    public ArrayList<Mascotas> obtenerTodosMascotas(){
        ArrayList<Mascotas> mascotas=new ArrayList<>();

        String query= "SELECT * FROM "+ConstanstesBasesDatos.TABLE_MASCOTAS;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor registros=db.rawQuery(query,null);
        while (registros.moveToNext()){
            Mascotas mascotasActual=new Mascotas();
            mascotasActual.setId(registros.getInt(0));
            mascotasActual.setNombre(registros.getString(1));
            mascotasActual.setFoto(registros.getInt(2));


            String queryLikes="SELECT COUNT("+ConstanstesBasesDatos.TABLE_MASCOTAS_LIKES_NLIKES+") as likes"+
                    " FROM "+ConstanstesBasesDatos.TABLE_MASCOTAS_LIKES+
                    " WHERE "+ConstanstesBasesDatos.TABLE_MASCOTAS_LIKES_IDMASCOTA+"="+mascotasActual.getId();

            Cursor registroLike=db.rawQuery(queryLikes,null);
            if(registroLike.moveToNext()){
                mascotasActual.setLinkes(registroLike.getInt(0));
            }else{
                mascotasActual.setLinkes(0);
            }
            mascotas.add(mascotasActual);
        }
        db.close();
        return mascotas;
    }

    public void insertarMascotas(ContentValues contetValues){
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(ConstanstesBasesDatos.TABLE_MASCOTAS,null,contetValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contetValues){
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(ConstanstesBasesDatos.TABLE_MASCOTAS_LIKES,null,contetValues);
        db.close();
    }

    public int obtenerLikesMascotas(Mascotas mascotas){
        int likes=0;
        String query="SELECT COUNT("+ConstanstesBasesDatos.TABLE_MASCOTAS_LIKES_NLIKES+") as likes"+
                " FROM "+ConstanstesBasesDatos.TABLE_MASCOTAS_LIKES+
                " WHERE "+ConstanstesBasesDatos.TABLE_MASCOTAS_LIKES_IDMASCOTA+"="+mascotas.getId();
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor registros=db.rawQuery(query,null);
        if(registros.moveToNext()){
            likes=registros.getInt(0);
        }
        db.close();
        return likes;
    }

    public boolean verificarExistenMascotas(){
        String query= "SELECT * FROM "+ConstanstesBasesDatos.TABLE_MASCOTAS;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor registros=db.rawQuery(query,null);

        if (registros.moveToNext()) {
            //Toast.makeText(context, "Si hay registros", Toast.LENGTH_SHORT).show();
            db.close();
            return true;
        }
        else {
            //Toast.makeText(context, "No hay registros", Toast.LENGTH_SHORT).show();
            db.close();
            return false;
        }
    }
}
