package it.unica.a18elode.pharmabuy;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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

public class Ordine extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private TextView nameClicked;
    private TextView descFarmacia;
    private ImageView imageClicked;
    private TextView nameFarmacia;
    private TextView prezzo;
    private TextView ricetta;
    private Button order;
    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordine);
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view_ordine);
        navigationView.setNavigationItemSelectedListener(this);

        //mostra il nome del farmaco cliccato
        nameClicked = (TextView) findViewById(R.id.selected_farmaco_ordine);
        nameClicked.setText(Medicinali.getClickedFarmaco().getNome() + (" ") + Medicinali.getClickedFarmaco().getTipo());

        descFarmacia = (TextView) findViewById(R.id.descrizioneFarmacoO);
        descFarmacia.setText(Medicinali.getClickedFarmaco().getDescrizione());

        //mostra l'immagine del farmaco cliccato
        imageClicked = (ImageView) findViewById(R.id.selected_image_farmaco_ordine);
        Context context = imageClicked.getContext();
        int id = context.getResources().getIdentifier(Medicinali.getClickedFarmaco().getImage(), "drawable", context.getPackageName());
        imageClicked.setImageResource(id);

        nameFarmacia = (TextView) findViewById(R.id.selected_farmaciaO);
        nameFarmacia.setText(MedicinaleScelto.getClickedFarmaciaND().getNome() + ("\n") + MedicinaleScelto.getClickedFarmaciaND().getVia() + (", ") + MedicinaleScelto.getClickedFarmaciaND().getCivico());

        Float prz = Medicinali.getClickedFarmaco().getPrezzo();
        prezzo = (TextView) findViewById(R.id.selected_prezzoO);
        prezzo.setText(("Prezzo: " + prz.toString() + (" €")));

        ricetta = (TextView) findViewById(R.id.selected_ricettaO);
        ricetta.setText(Medicinali.getClickedFarmaco().getRicetta());
        myDialog = new Dialog(this);
        //init();
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
            Intent goToFarm = new Intent(Ordine.this, Menu.class);

            startActivity(goToFarm);
        }
        /* if(id == R.id.homeDrawer)
        {
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
        }*/
        if(id == R.id.medicinaliDrawer)
        {
            Intent goToFarm = new Intent(Ordine.this, Medicinali.class);

            startActivity(goToFarm);
        }
        if(id == R.id.farmacieDrawer)
        {
            Intent goToFarm = new Intent(Ordine.this, FarmacieTurno.class);

            startActivity(goToFarm);
        }
        if(id == R.id.recentBuy)
        {
            Intent goToFarm = new Intent(Ordine.this, AcquistiRecenti.class);

            startActivity(goToFarm);
        }
        if(id == R.id.orderState)
        {
            Intent goToFarm = new Intent(Ordine.this, StatoOrdini.class);

            startActivity(goToFarm);
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

   /* public void init() {
        order = (Button) findViewById(R.id.button_ordine);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMed = new Intent(Ordine.this, RiepilogoOrdine.class);
                Medicinali.getClickedFarmaco().setFarmaciaOrdine(MedicinaleScelto.getClickedFarmaciaND());
                StatoOrdini.addOrdine(Medicinali.getClickedFarmaco());
                startActivity(goToMed);
            }
        });

    }*/

    public void ConfOrdine(View v) {
        Intent goToMed = new Intent(Ordine.this, RiepilogoOrdine.class);
        Medicinali.getClickedFarmaco().setFarmaciaOrdine(MedicinaleScelto.getClickedFarmaciaND());
        StatoOrdini.addOrdine(Medicinali.getClickedFarmaco());
        startActivity(goToMed);

    }


    public void ShowPopupS(View v) {
        TextView txtclose;
        ImageView popMed;


        Button btnFollow;
        myDialog.setContentView(R.layout.custompopup_so);
        txtclose =(TextView) myDialog.findViewById(R.id.txtcloseS);
        txtclose.setText("X");

        //nome med
        TextView popName = myDialog.findViewById(R.id.pop_medicinaleS);
        popName.setText(Medicinali.getClickedFarmaco().getNome());

        //immagine popup
        popMed=(ImageView)myDialog.findViewById(R.id.pop_imgS);
        Context context = popMed.getContext();
        int id = context.getResources().getIdentifier(Medicinali.getClickedFarmaco().getImage(), "drawable", context.getPackageName());
        popMed.setImageResource(id);

        //farmacia popup
        TextView popFarmacia=(TextView)myDialog.findViewById(R.id.pop_farmaciaS);
        popFarmacia.setText(MedicinaleScelto.getClickedFarmaciaND().getNome()+("\n")+(MedicinaleScelto.getClickedFarmaciaND().getCitta()));

        //prezzo
        Float prz=Medicinali.getClickedFarmaco().getPrezzo();
        TextView popPrezzo=(TextView)myDialog.findViewById(R.id.pop_prezzoS);
        popPrezzo.setText(prz.toString()+(" €"));

        //tipo
        TextView popTipo =(TextView)myDialog.findViewById(R.id.pop_tipoS);
        popTipo.setText(Medicinali.getClickedFarmaco().getTipo());

        btnFollow = (Button) myDialog.findViewById(R.id.btnfollowS);
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
