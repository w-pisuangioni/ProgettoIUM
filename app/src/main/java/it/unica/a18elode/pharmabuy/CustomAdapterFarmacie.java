package it.unica.a18elode.pharmabuy;

/**
 * Created by Utente on 23/02/2018.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class CustomAdapterFarmacie extends ArrayAdapter<Farmacia>{

    public CustomAdapterFarmacie(Context context, int textViewResourceId,
                                 List objects) {
        super(context, textViewResourceId, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.rowcustomturno, null);
        TextView nome = (TextView) convertView.findViewById(R.id.textViewNameFarm);
        TextView descrizione = (TextView) convertView.findViewById(R.id.textViewIndirizzo);
        Farmacia c = FarmaciaFactory.getInstance().getListaFarmacie().get(position);
        nome.setText(c.getNome() + " " + c.getCitta());
        descrizione.setText(c.getVia() + ", " + c.getCivico() + " " + c.getCitta()); //AGGIUNGERE DISPONIBILITà
        //int id = context.getResources().getIdentifier(c.getImage(), "drawable", context.getPackageName());
        return convertView;
    }
}