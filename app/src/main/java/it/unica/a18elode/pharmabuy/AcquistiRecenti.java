package it.unica.a18elode.pharmabuy;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class AcquistiRecenti extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;

    private static List listFarmaci = new LinkedList();
    CustomAdapterAcquisti adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acquisti_recenti);
        drawer=(DrawerLayout) findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView=(NavigationView)findViewById(R.id.navigation_view_AcquistiRecenti);
        navigationView.setNavigationItemSelectedListener(this);

        //listview
        final ListView mylistMedicinali = (ListView) findViewById(R.id.listViewAcquisti);


        adapter = new CustomAdapterAcquisti(this, R.layout.rowcustom_buy,listFarmaci);
        mylistMedicinali.setAdapter(adapter);
    }

    public static void addAcquisto(Farmaco buy){
        listFarmaci.add(buy);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(toggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.homeDrawer)
        {
            Intent goToFarm = new Intent(AcquistiRecenti.this, Menu.class);

            startActivity(goToFarm);
        }
        /* if(id == R.id.homeDrawer)
        {
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
        }*/
        if(id == R.id.medicinaliDrawer)
        {
            Intent goToFarm = new Intent(AcquistiRecenti.this, Medicinali.class);

            startActivity(goToFarm);
        }
        if(id == R.id.farmacieDrawer)
        {
            Intent goToFarm = new Intent(AcquistiRecenti.this, FarmacieTurno.class);

            startActivity(goToFarm);
        }
        if(id == R.id.recentBuy)
        {
            Intent goToFarm = new Intent(AcquistiRecenti.this, AcquistiRecenti.class);

            startActivity(goToFarm);
        }
        if(id == R.id.orderState)
        {
            Intent goToFarm = new Intent(AcquistiRecenti.this, StatoOrdini.class);

            startActivity(goToFarm);
        }
        return false;
    }
}
