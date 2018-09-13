package it.unica.a18elode.pharmabuy;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Riepilogo extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private TextView nameClicked;
    private ImageView imageClicked;
    private TextView descFarmacia;
    private TextView nameFarmacia;
    private TextView prezzo;
    private TextView ricetta;
    private TextView conferma;
    private TextView data;
    public Button acquistiRecenti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riepilogo);
        drawer=(DrawerLayout) findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView=(NavigationView)findViewById(R.id.navigation_view_riepilogo);
        navigationView.setNavigationItemSelectedListener(this);
        acquistiRecenti = (Button) findViewById(R.id.acquistiRecenti_button);
        acquistiRecenti.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent goToAcqRec = new Intent(Riepilogo.this, AcquistiRecenti.class);

                startActivity(goToAcqRec);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
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
            Intent goToFarm = new Intent(Riepilogo.this, Menu.class);

            startActivity(goToFarm);
        }
        /* if(id == R.id.homeDrawer)
        {
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
        }*/
        if(id == R.id.medicinaliDrawer)
        {
            Intent goToFarm = new Intent(Riepilogo.this, Medicinali.class);

            startActivity(goToFarm);
        }
        if(id == R.id.farmacieDrawer)
        {
            Intent goToFarm = new Intent(Riepilogo.this, FarmacieTurno.class);

            startActivity(goToFarm);
        }
        if(id == R.id.recentBuy)
        {
            Intent goToFarm = new Intent(Riepilogo.this, AcquistiRecenti.class);

            startActivity(goToFarm);
        }
        if(id == R.id.orderState)
        {
            Intent goToFarm = new Intent(Riepilogo.this, StatoOrdini.class);

            startActivity(goToFarm);
        }
        return false;
    }
}
