package it.unica.a18elode.pharmabuy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        init();
    }
}
