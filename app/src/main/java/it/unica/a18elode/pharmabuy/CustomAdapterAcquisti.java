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

public class CustomAdapterAcquisti extends ArrayAdapter<Farmaco>{
    /*private static int farmacia = 0;
    private static ArrayList<Farmacia> listFarmacieAqquisti = new ArrayList<>();*/
    public CustomAdapterAcquisti(Context context, int textViewResourceId,
                                 List objects) {
        super(context, textViewResourceId, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.rowcustom_buy, null);
        TextView nome = (TextView) convertView.findViewById(R.id.textViewNameAcquisto);
        TextView descrizione = (TextView) convertView.findViewById(R.id.textViewDescriptionAcquisto);
        TextView data = (TextView)convertView.findViewById(R.id.textViewDescriptionDataAcquisto);
        TextView farmaciaA =(TextView)convertView.findViewById(R.id.textViewFarmaciaAcquisto);
        Farmaco c = getItem(position);
        nome.setText(c.getNome() + " " + c.getTipo());
        ImageView anteprima =(ImageView)convertView.findViewById(R.id.anteprimaAcquisto);
        descrizione.setText(c.getDescrizione()); //AGGIUNGERE DISPONIBILITà
        data.setText("Data di acquisto: 14/09/2018");
        //farmaciaA.setText((listFarmacieAqquisti.get(farmacia-1).getNome())+(" ")+listFarmacieAqquisti.get(farmacia-1).getVia());
        farmaciaA.setText(c.getFarmaciaAcquisto().getNome()+(" ")+c.getFarmaciaAcquisto().getVia());
        Context context = anteprima.getContext();
        int id = context.getResources().getIdentifier(c.getImage(), "drawable", context.getPackageName());
        anteprima.setImageResource(id);
        return convertView;
    }
/*
    public static void addFarmaciaAcquisti(Farmacia f){
        farmacia++;
        listFarmacieAqquisti.add(f);
    }*/
}

