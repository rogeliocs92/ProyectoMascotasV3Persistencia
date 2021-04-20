package com.example.miscontactosintens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.miscontactosintens.adapter.ContactoAdaptador;
import com.example.miscontactosintens.adapter.PageAdapter;
import com.example.miscontactosintens.fragments.PerfilFragment;
import com.example.miscontactosintens.fragments.RecyclerViewFragment;
import com.example.miscontactosintens.pojo.Mascotas;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView listaContactos;
    ArrayList<Mascotas> mascotas;
    ImageView imgLike;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);

        if( toolbar!=null){
            setSupportActionBar(toolbar);
        }
        setUpViewPager();
    }

    private ArrayList<Fragment> agregarFragments(){
        iniciarlizarListaContactos();
        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(new RecyclerViewFragment(this));
        fragments.add(new PerfilFragment(mascotas));
        return fragments;
    }
    public void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.info);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.mContacto:
                intent=new Intent(MainActivity.this, Contactanos.class);
                startActivity(intent);
                break;
            case R.id.mAcercaD:
                intent=new Intent(MainActivity.this, AcercaDE.class);
                startActivity(intent);
                break;
            case R.id.mRefresh:
                intent=new Intent(MainActivity.this, Detalle_Likes.class);
                startActivity(intent);
                break;
        }


        return super.onOptionsItemSelected(item);
    }
    public void iniciarlizarListaContactos(){
        mascotas =new ArrayList<>();
        mascotas.add(new Mascotas(R.drawable.perrito1,"Chiquitin",10));
        mascotas.add(new Mascotas(R.drawable.perrito2,"Bolita      ", 3));
        mascotas.add(new Mascotas(R.drawable.perrito3,"Dormilon", 8));
        mascotas.add(new Mascotas(R.drawable.perrito4,"Chatito      ", 7));
        mascotas.add(new Mascotas(R.drawable.perrito5,"Coqueta      ", 4));
    }

}