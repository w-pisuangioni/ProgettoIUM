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

public class Acquisto extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private TextView nameClicked;
    private ImageView imageClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acquisto);
        drawer=(DrawerLayout) findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView=(NavigationView)findViewById(R.id.navigation_view_acquisto);
        navigationView.setNavigationItemSelectedListener(this);

        //mostra il nome del farmaco cliccato
        nameClicked = (TextView)findViewById(R.id.selected_farmacoA);
        nameClicked.setText(Medicinali.getClickedFarmaco().getNome()+(" ")+Medicinali.getClickedFarmaco().getTipo() );

        //mostra l'immagine del farmaco cliccato
        imageClicked=(ImageView)findViewById(R.id.selected_imageA);
        Context context = imageClicked.getContext();
        int id = context.getResources().getIdentifier(Medicinali.getClickedFarmaco().getImage(), "drawable", context.getPackageName());
        imageClicked.setImageResource(id);
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
            Intent goToFarm = new Intent(Acquisto.this, Menu.class);

            startActivity(goToFarm);
        }
        /* if(id == R.id.homeDrawer)
        {
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
        }*/
        if(id == R.id.medicinaliDrawer)
        {
            Toast.makeText(this, "Medicinali", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.farmacieDrawer)
        {
            Toast.makeText(this, "Farmacie", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
