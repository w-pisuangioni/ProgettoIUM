package it.unica.a18elode.pharmabuy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CustomAdapterStatoOrdini extends ArrayAdapter<Farmaco>{

    public CustomAdapterStatoOrdini(Context context, int textViewResourceId,
                                 List objects) {
        super(context, textViewResourceId, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.rowcustom_stato_ordini, null);
        TextView nome = (TextView) convertView.findViewById(R.id.textViewNameSO);
        TextView descrizione = (TextView) convertView.findViewById(R.id.textViewDescriptionSO);
        TextView data = (TextView)convertView.findViewById(R.id.textViewDataSO);
        TextView farmaciaA =(TextView)convertView.findViewById(R.id.textViewFarmaciaSO);
        TextView ricetta = (TextView)convertView.findViewById(R.id.textViewRicettaSO);
        Farmaco c = getItem(position);
        nome.setText(c.getNome() + " " + c.getTipo());
        ImageView anteprima =(ImageView)convertView.findViewById(R.id.anteprimaSO);
        descrizione.setText(c.getDescrizione()); //AGGIUNGERE DISPONIBILITà
        data.setText("Tempo stimato ricezione prodotto:\n3 giorni lavorativi");
        farmaciaA.setText(c.getFarmaciaOrdine().getNome()+(" ")+c.getFarmaciaOrdine().getVia());
        ricetta.setText(c.getRicetta());
        Context context = anteprima.getContext();
        int id = context.getResources().getIdentifier(c.getImage(), "drawable", context.getPackageName());
        anteprima.setImageResource(id);
        return convertView;
    }

}