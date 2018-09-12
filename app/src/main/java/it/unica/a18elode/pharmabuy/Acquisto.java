package it.unica.a18elode.pharmabuy;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Acquisto extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private TextView nameClicked;
    private ImageView imageClicked;
    private TextView descFarmacia;
    private TextView nameFarmacia;
    private TextView prezzo;
    private TextView ricetta;
    private Button buy;
    Dialog myDialog;


    Date date = new Date();

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

        descFarmacia = (TextView)findViewById(R.id.descrizioneFarmacoA);
        descFarmacia.setText(Medicinali.getClickedFarmaco().getDescrizione());

        //mostra l'immagine del farmaco cliccato
        imageClicked=(ImageView)findViewById(R.id.selected_imageA);
        Context context = imageClicked.getContext();
        int id = context.getResources().getIdentifier(Medicinali.getClickedFarmaco().getImage(), "drawable", context.getPackageName());
        imageClicked.setImageResource(id);

        nameFarmacia=(TextView)findViewById(R.id.selected_farmacia);
        nameFarmacia.setText(MedicinaleScelto.getClickedFarmacia().getNome()+(" ")+MedicinaleScelto.getClickedFarmacia().getVia()+(" ")+MedicinaleScelto.getClickedFarmacia().getCivico());

        Float prz = Medicinali.getClickedFarmaco().getPrezzo();
        prezzo=(TextView)findViewById(R.id.selected_prezzo);
        prezzo.setText(("Prezzo: "+prz.toString()+(" €")));

        ricetta=(TextView)findViewById(R.id.selected_ricetta);
        ricetta.setText(Medicinali.getClickedFarmaco().getRicetta());


        //init();
        myDialog = new Dialog(this);
    }
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public void ConfAcquisto(View v) {
       // buy = (Button) findViewById(R.id.btnfollow);
       // buy.setOnClickListener(new View.OnClickListener() {
          //  @Override
           // public void onClick(View v) {
                Intent goToMed = new Intent(Acquisto.this, Riepilogo.class);
                Medicinali.getClickedFarmaco().setFarmaciaAcquisto(MedicinaleScelto.getClickedFarmacia());
                Medicinali.getClickedFarmaco().setData(date);
                AcquistiRecenti.addAcquisto(Medicinali.getClickedFarmaco());
                //CustomAdapterAcquisti.addFarmaciaAcquisti(MedicinaleScelto.getClickedFarmacia());

                startActivity(goToMed);
       //     }
       // });


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
            Intent goToFarm = new Intent(Acquisto.this, Medicinali.class);

            startActivity(goToFarm);
        }
        if(id == R.id.farmacieDrawer)
        {
            Intent goToFarm = new Intent(Acquisto.this, FarmacieTurno.class);

            startActivity(goToFarm);
        }
        if(id == R.id.recentBuy)
        {
            Intent goToFarm = new Intent(Acquisto.this, AcquistiRecenti.class);

            startActivity(goToFarm);
        }
        if(id == R.id.orderState)
        {
            Intent goToFarm = new Intent(Acquisto.this, StatoOrdini.class);

            startActivity(goToFarm);
        }
        return false;
    }

    public void ShowPopup(View v) {
        TextView txtclose;
        ImageView popMed;


        Button btnFollow;
        myDialog.setContentView(R.layout.custompopup);
        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("X");

        //nome med
        TextView popName = myDialog.findViewById(R.id.pop_medicinale);
        popName.setText(Medicinali.getClickedFarmaco().getNome());

        //immagine popup
        popMed=(ImageView)myDialog.findViewById(R.id.pop_img);
        Context context = popMed.getContext();
        int id = context.getResources().getIdentifier(Medicinali.getClickedFarmaco().getImage(), "drawable", context.getPackageName());
        popMed.setImageResource(id);

        //farmacia popup
        TextView popFarmacia=(TextView)myDialog.findViewById(R.id.pop_farmacia);
        popFarmacia.setText(MedicinaleScelto.getClickedFarmacia().getNome()+("\n")+(MedicinaleScelto.getClickedFarmacia().getCitta()));

        //prezzo
        Float prz=Medicinali.getClickedFarmaco().getPrezzo();
        TextView popPrezzo=(TextView)myDialog.findViewById(R.id.pop_prezzo);
        popPrezzo.setText(prz.toString()+(" €"));

        //tipo
        TextView popTipo =(TextView)myDialog.findViewById(R.id.pop_tipo);
        popTipo.setText(Medicinali.getClickedFarmaco().getTipo());

        btnFollow = (Button) myDialog.findViewById(R.id.btnfollow);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
}
