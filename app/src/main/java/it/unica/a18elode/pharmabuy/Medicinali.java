package it.unica.a18elode.pharmabuy;

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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.LinkedList;
import java.util.List;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class Medicinali extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;

    private static final String TAG = "Medicinali";
    private CustomAdapter adapter;

    private static Farmaco clickedFarmaco;
    private TextView nameClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicinali);
        drawer=(DrawerLayout) findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this, drawer,R.string.open,R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView=(NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        //listview
        final ListView mylistMedicinali = (ListView) findViewById(R.id.listViewMedicinali);
        final List listFarmaci = new LinkedList();
        EditText theFilter = (EditText) findViewById(R.id.searchFilter);
        Log.d(TAG,"OnCreate: Started");
        for (int i=0 ;i < (FarmacoFactory.getInstance().getListaFarmaci()).size(); ++i){
            listFarmaci.add(FarmacoFactory.getInstance().getListaFarmaci().get(i));
        }
        adapter = new CustomAdapter(this, R.layout.rowcustom,listFarmaci);
        mylistMedicinali.setAdapter(adapter);

        //search bar
        theFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (Medicinali.this).adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //Permette di cliccare sugli elementi della lista e cambia pagina 11-06-2018
        mylistMedicinali.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(Medicinali.this, MedicinaleScelto.class);
                clickedFarmaco = (Farmaco)mylistMedicinali.getItemAtPosition(position);

                startActivity(intent);


            }
        });
    }
    //fino a qui ctrl + <
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
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.medicinaliDrawer)
        {
            Intent goToScelto = new Intent(Medicinali.this, MedicinaleScelto.class);

            startActivity(goToScelto);
        }
        if(id == R.id.farmacieDrawer)
        {
            Toast.makeText(this, "Farmacie", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    public static Farmaco getClickedFarmaco(){
        return clickedFarmaco;
    }


}
