package it.unica.a18elode.pharmabuy;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    public Button medicinali;
    public Button farmacie;

    public void init() {
        medicinali = (Button) findViewById(R.id.button_medicinali);
        farmacie = (Button) findViewById(R.id.farmacie_button);
        medicinali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMed = new Intent(Menu.this, Medicinali.class);

                startActivity(goToMed);
            }
        });
        farmacie.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent goToFarm = new Intent(Menu.this, FarmacieTurno.class);

                startActivity(goToFarm);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        drawer=(DrawerLayout) findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView=(NavigationView)findViewById(R.id.navigation_view_menu);
        navigationView.setNavigationItemSelectedListener(this);
        init();
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
            Intent goToFarm = new Intent(Menu.this, Menu.class);

            startActivity(goToFarm);
        }
        /* if(id == R.id.homeDrawer)
        {
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
        }*/
        if(id == R.id.medicinaliDrawer)
        {
            Intent goToFarm = new Intent(Menu.this, Medicinali.class);

            startActivity(goToFarm);
        }
        if(id == R.id.farmacieDrawer)
        {
            Intent goToFarm = new Intent(Menu.this, FarmacieTurno.class);

            startActivity(goToFarm);
        }
        if(id == R.id.recentBuy)
        {
            Intent goToFarm = new Intent(Menu.this, AcquistiRecenti.class);

            startActivity(goToFarm);
        }
        if(id == R.id.orderState)
        {
            Intent goToFarm = new Intent(Menu.this, StatoOrdini.class);

            startActivity(goToFarm);
        }
        return false;
    }
}
