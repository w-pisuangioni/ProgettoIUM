package it.unica.a18elode.pharmabuy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.LinkedList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Farmaco> implements Filterable {
    private List<Farmaco> data = new LinkedList<>();
    private List<Farmaco> tempListData = new LinkedList<>();


    public CustomAdapter(Context context, int textViewResourceId,
                         List objects) {
        super(context, textViewResourceId, objects);
        data=objects;
        tempListData = objects;
    }

    @Override
    public int getCount() {
        return tempListData.size(); // make the count point to this tempList as the list size would vary with every search text
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.rowcustom, null);
        TextView nome = (TextView)convertView.findViewById(R.id.textViewName);
        TextView descrizione = (TextView)convertView.findViewById(R.id.textViewDescription);
        ImageView anteprima =(ImageView)convertView.findViewById(R.id.anteprima);
        Farmaco c = tempListData.get(position);
        nome.setText(c.getNome()+" "+c.getTipo());
        descrizione.setText(c.getDescrizione());
        Context context = anteprima.getContext();
        int id = context.getResources().getIdentifier(c.getImage(), "drawable", context.getPackageName());
        anteprima.setImageResource(id);
        return convertView;

    }
/*
    @Override
    public View getView(int position, View convertView, ViewGroup parent, int a) {
        a=a+1;
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.rowcustom, null);
        TextView nome = (TextView)convertView.findViewById(R.id.textViewName);
        TextView descrizione = (TextView)convertView.findViewById(R.id.textViewDescription);
        ImageView anteprima =(ImageView)convertView.findViewById(R.id.anteprima);
        Farmacia c = tempListData.get(position);
        nome.setText(c.getNome()+" "+c.getCitta());
        descrizione.setText(c.getVia()+", "+c.getCivico()+" "+c.getCitta()); //AGGIUNGERE DISPONIBILITà
        Context context = anteprima.getContext();
        //int id = context.getResources().getIdentifier(c.getImage(), "drawable", context.getPackageName());
        //anteprima.setImageResource(id);
        return convertView;

    }*/

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                final List<Farmaco> tempFliteredDataList = new LinkedList<>();
                // We implement here the filter logic
                if (constraint == null || constraint.toString().trim().length() == 0) {
                    // No filter implemented we return all the list
                    results.values = data;
                } else {
                    // We perform filtering operation
                    String constrainString = constraint.toString().toLowerCase();
                    for (Farmaco post: data) {
                        if (post.getNome().toLowerCase().contains(constrainString)) {
                            tempFliteredDataList.add(post);
                        }
                    }
                    results.values = tempFliteredDataList ;
                }
                return results;

            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results.values!=null){
                    tempListData = (List<Farmaco>) results.values; // returns the filtered list based on the search
                    notifyDataSetChanged();
                }
            }
        };
        return filter;
    }

}
