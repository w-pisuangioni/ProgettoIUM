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

        //mostra il nome del farmaco cliccato
        nameClicked = (TextView)findViewById(R.id.selected_farmaco_riepilogo);
        nameClicked.setText(Medicinali.getClickedFarmaco().getNome()+(" ")+Medicinali.getClickedFarmaco().getTipo() );

        descFarmacia = (TextView)findViewById(R.id.descrizioneFarmacoR);
        descFarmacia.setText(Medicinali.getClickedFarmaco().getDescrizione());

        //mostra l'immagine del farmaco cliccato
        imageClicked=(ImageView)findViewById(R.id.selected_imageR);
        Context context = imageClicked.getContext();
        int id = context.getResources().getIdentifier(Medicinali.getClickedFarmaco().getImage(), "drawable", context.getPackageName());
        imageClicked.setImageResource(id);

        nameFarmacia=(TextView)findViewById(R.id.selected_farmaciaR);
        nameFarmacia.setText(MedicinaleScelto.getClickedFarmacia().getNome()+(" ")+MedicinaleScelto.getClickedFarmacia().getVia()+(" ")+MedicinaleScelto.getClickedFarmacia().getCivico());

        Float prz = Medicinali.getClickedFarmaco().getPrezzo();
        prezzo=(TextView)findViewById(R.id.selected_prezzoR);
        prezzo.setText(("Prezzo: "+prz.toString()+(" €")));

        ricetta=(TextView)findViewById(R.id.selected_ricettaR);
        ricetta.setText(Medicinali.getClickedFarmaco().getRicetta());

        conferma=(TextView)findViewById(R.id.conferma);
        conferma.setText("   Acquisto andato a buon fine");

        data=(TextView)findViewById(R.id.dataR);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
        Date date = new Date();
        data.setText(("Data di acquisto: ")+dateFormat.format(date));
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
