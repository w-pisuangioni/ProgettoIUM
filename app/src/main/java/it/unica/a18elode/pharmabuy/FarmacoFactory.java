package it.unica.a18elode.pharmabuy;

import java.util.ArrayList;

/**
 * Created by Utente on 19/02/2018.
 */

public class FarmacoFactory {

    private static FarmacoFactory singleton;
    public static FarmacoFactory getInstance() {
        if (singleton == null) {
            singleton = new FarmacoFactory();
        }
        return singleton;
    }

    private ArrayList<Farmaco> listaFarmaci = new ArrayList<Farmaco>();

    private FarmacoFactory(){
        Farmaco farmaco1 = new Farmaco();
        farmaco1.setId(1);
        farmaco1.setNome("Tachipirina 500mg");
        farmaco1.setDescrizione("E' indicata nel trattamento sintomatico degli stati dolorosi " +
                "di lieve e modesta entità di varia origine e nel trattamento degli stati febbrili.");
        farmaco1.setTipo("10 compresse");
        farmaco1.setPrezzo(8.15f);
        farmaco1.setRicetta("Non necessita di ricetta");
        farmaco1.setImage("tachipirina");

        Farmaco farmaco2 = new Farmaco();
        farmaco2.setId(2);
        farmaco2.setNome("Moment 200mg");
        farmaco2.setDescrizione("Moment è un antinfiammatorio a base di ibuprofene, è utilizzato nel trattamento di dolorosi di varia natura " +
                "come dolori mestruali, osteo-articolari, dentali, nevralgie e cefalee.");
        farmaco2.setTipo("10 compresse");
        farmaco2.setPrezzo(7.80f);
        farmaco2.setRicetta("Non necessita di ricetta");
        farmaco2.setImage("moment");

        Farmaco farmaco3 = new Farmaco();
        farmaco2.setId(3);
        farmaco3.setNome("Oki");
        farmaco3.setDescrizione("L'OKI è un medicinale usato per scopi terapeutici per curare le varie patologie mediche." +
                "Trattamento sintomatico e di breve durata di stati infiammatori associati a dolore quali quelli a carico dell'apparato" +
                " osteoarticolare, dolore post operatorio e otiti.");
        farmaco3.setPrezzo(8.40f);
        farmaco3.setRicetta("Necessita di ricetta");
        farmaco3.setImage("oki");

        Farmaco farmaco4 = new Farmaco();
        farmaco2.setId(4);
        farmaco4.setNome("Voltaren");
        farmaco4.setDescrizione("Il Voltaren è un farmaco anti-infiammatorio non steroideo (FANS) " +
                "tra i più utilizzati come anti-infiammatorio, antireumatico e soprattutto come analgesico.");
        farmaco4.setPrezzo(11.90f);
        farmaco4.setTipo("emulgel 2% 100g");
        farmaco4.setRicetta("Non necessita di ricetta");
        farmaco4.setImage("voltaren");

        Farmaco farmaco5 = new Farmaco();
        farmaco2.setId(5);
        farmaco5.setNome("Aspirina");
        farmaco5.setDescrizione("L'aspirina è indicata come terapia sintomatica nel trattamento dei " +
                        "dolori infiammatori di varia natura e degli stati febbrili e sindromi influenzali e da raffreddamento.");
        farmaco5.setPrezzo(13.00f);
        farmaco5.setTipo("10 compresse 500mg");
        farmaco5.setRicetta("Non necessita di ricetta");
        farmaco5.setImage("aspirina");


        listaFarmaci.add(farmaco1);
        listaFarmaci.add(farmaco2);
        listaFarmaci.add(farmaco3);
        listaFarmaci.add(farmaco4);
        listaFarmaci.add(farmaco5);
    }

    public ArrayList<Farmaco> getListaFarmaci(){
        return listaFarmaci;
    }
}
