package it.unica.a18elode.pharmabuy;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class FarmacieTurno extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;

    private CustomAdapterFarmacie adapter;

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmacie_turno);
        drawer=(DrawerLayout) findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView=(NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        //listview
        final ListView mylistMedicinali = (ListView) findViewById(R.id.listViewFarmacieTurno);
        List listFarmacie = new LinkedList();
        EditText theFilter = (EditText) findViewById(R.id.searchFilterFarmacie);
        for (int i=0 ;i < (FarmaciaFactory.getInstance().getListaFarmacie()).size(); ++i){
            listFarmacie.add(FarmaciaFactory.getInstance().getListaFarmacie().get(i));
        }
        adapter = new CustomAdapterFarmacie(this, R.layout.rowcustomturno,listFarmacie);

        mylistMedicinali.setAdapter(adapter);


        theFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (FarmacieTurno.this).adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
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
            Intent goToFarm = new Intent(FarmacieTurno.this, Menu.class);

            startActivity(goToFarm);
        }
       /* if(id == R.id.homeDrawer)
        {
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
        }*/
        if(id == R.id.medicinaliDrawer)
        {
            Intent goToFarm = new Intent(FarmacieTurno.this, Medicinali.class);

            startActivity(goToFarm);
        }
        if(id == R.id.farmacieDrawer)
        {
            Intent goToFarm = new Intent(FarmacieTurno.this, FarmacieTurno.class);

            startActivity(goToFarm);
        }
        if(id == R.id.recentBuy)
        {
            Intent goToFarm = new Intent(FarmacieTurno.this, AcquistiRecenti.class);

            startActivity(goToFarm);
        }
        if(id == R.id.orderState)
        {
            Intent goToFarm = new Intent(FarmacieTurno.this, StatoOrdini.class);

            startActivity(goToFarm);
        }
        return false;
    }

}
