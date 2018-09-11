package it.unica.a18elode.pharmabuy;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class CustomAdapterFarmacie extends ArrayAdapter<Farmacia>{
    private List<Farmacia> data = new LinkedList<>();
    private List<Farmacia> tempListData = new LinkedList<>();

    public CustomAdapterFarmacie(Context context, int textViewResourceId,
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
        convertView = inflater.inflate(R.layout.rowcustomturno, null);
        TextView nome = (TextView) convertView.findViewById(R.id.textViewNameFarm);
        TextView descrizione = (TextView) convertView.findViewById(R.id.textViewIndirizzo);
        Farmacia c = tempListData.get(position);
        nome.setText(c.getNome() + " " + c.getCitta());
        descrizione.setText(c.getVia() + ", " + c.getCivico() + " " + c.getCitta()); //AGGIUNGERE DISPONIBILITà
        //int id = context.getResources().getIdentifier(c.getImage(), "drawable", context.getPackageName());
        return convertView;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                final List<Farmacia> tempFilteredDataList = new LinkedList<>();
                // We implement here the filter logic
                if (constraint == null || constraint.toString().trim().length() == 0) {
                    // No filter implemented we return all the list
                    results.values = data;
                } else {
                    // We perform filtering operation
                    String constrainString = constraint.toString().toLowerCase();
                    for (Farmacia post: data) {
                        if (post.getCitta().toLowerCase().contains(constrainString) ||
                            post.getNome().toLowerCase().contains(constrainString) ||
                            post.getVia().toLowerCase().contains(constrainString)){
                            tempFilteredDataList.add(post);
                        }
                    }
                    results.values = tempFilteredDataList ;
                }
                return results;

            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results.values!=null){
                    tempListData = (List<Farmacia>) results.values; // returns the filtered list based on the search
                    notifyDataSetChanged();
                }
            }
        };
        return filter;
    }
}