package it.unica.a18elode.pharmabuy;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class MedicinaleScelto  extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;

    private CustomAdapterFarmacie adapter;
    private CustomAdapterFarmacie adapterND;

    private TextView nameClicked;
    private ImageView imageClicked;

    private static Farmacia clickedFarmacia;
    private static Farmacia clickedFarmaciaND;





    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicinale_scelto);
        drawer=(DrawerLayout) findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView=(NavigationView)findViewById(R.id.navigation_view_sc);
        navigationView.setNavigationItemSelectedListener(this);

        //listview
        final ListView mylistFarmacie = (ListView) findViewById(R.id.listViewMedicinaleScelto); //listView Per le farmacie disponibili
        final ListView mylistFarmacieND = (ListView) findViewById(R.id.listViewNonDisp);//listView Per le farmacie non disponibili

        //liste temporanee per l'adapter
        List listFarmacie = new LinkedList();
        List listFarmacieND= new LinkedList();

        //controlla le farmacia dove è disponibile il medicinale e le salva nella linkedlist
        for (int i=0 ;i < (FarmaciaFactory.getInstance().getListaFarmacie()).size(); i++){
            Integer idM = Medicinali.getClickedFarmaco().getId();
            if(FarmaciaFactory.getInstance().getListaFarmacie().get(i).getDisp2().contains(idM))
            //if(FarmaciaFactory.getInstance().getListaFarmacie().get(i).getDisponibili(Medicinali.getClickedFarmaco().getId()))
            /* for(int j = 0;j<FarmaciaFactory.getInstance().getListaFarmacie().get(i).getDisp2().size(); j++)
                if(FarmaciaFactory.getInstance().getListaFarmacie().get(i).getDisp2().get(j) == (Integer)Medicinali.getClickedFarmaco().getId())*/
            listFarmacie.add(FarmaciaFactory.getInstance().getListaFarmacie().get(i));
        }
        //per le farmacie non disponibili
        for (int i=0 ;i < (FarmaciaFactory.getInstance().getListaFarmacie()).size(); i++){
            Integer idM = Medicinali.getClickedFarmaco().getId();
            if(!FarmaciaFactory.getInstance().getListaFarmacie().get(i).getDisp2().contains(idM))
                listFarmacieND.add(FarmaciaFactory.getInstance().getListaFarmacie().get(i));
        }

        //crea gli adapter e assegna le linked list
        adapter = new CustomAdapterFarmacie(this, R.layout.rowcustomturno,listFarmacie);
        mylistFarmacie.setAdapter(adapter);
        adapterND = new CustomAdapterFarmacie(this, R.layout.rowcustomturno,listFarmacieND);
        mylistFarmacieND.setAdapter(adapterND);

        //mostra il nome del farmaco cliccato
        nameClicked = (TextView)findViewById(R.id.selected_farmaco);
        nameClicked.setText(Medicinali.getClickedFarmaco().getNome()+(" ")+Medicinali.getClickedFarmaco().getTipo() );

        //mostra l'immagine del farmaco cliccato
        imageClicked=(ImageView)findViewById(R.id.selected_image);
        Context context = imageClicked.getContext();
        int id = context.getResources().getIdentifier(Medicinali.getClickedFarmaco().getImage(), "drawable", context.getPackageName());
        imageClicked.setImageResource(id);

        //Serve per poter cliccare nella lista delle farmacie in cui è disponibile il farmaco
        mylistFarmacie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(MedicinaleScelto.this, Acquisto.class);
                clickedFarmacia = (Farmacia)mylistFarmacie.getItemAtPosition(position);

                startActivity(intent);
            }
        });
        //Per le farmacie non disponibili
        mylistFarmacieND.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(MedicinaleScelto.this, Ordine.class);
                clickedFarmaciaND = (Farmacia)mylistFarmacieND.getItemAtPosition(position);

                startActivity(intent);
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
            Intent goToFarm = new Intent(MedicinaleScelto.this, Menu.class);

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
    public static Farmacia getClickedFarmacia(){
        return clickedFarmacia;
    }
    public static Farmacia getClickedFarmaciaND(){
        return clickedFarmaciaND;
    }

}

