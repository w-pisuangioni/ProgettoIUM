package it.unica.a18elode.pharmabuy;

import android.os.Debug;

import java.util.ArrayList;

/**
 * Created by Willy on 22/02/2018.
 */

public class FarmaciaFactory {

    private static FarmaciaFactory singleton;

    public static FarmaciaFactory getInstance() {
        if (singleton == null) {
            singleton = new FarmaciaFactory();
        }
        return singleton;
    }

    private ArrayList<Farmacia> listaFarmacie = new ArrayList<Farmacia>();

    private Farmacia Createfarmacia(String Nome, String Citta, String Via, String Civico) {

        Farmacia farmacia1 = new Farmacia();
        farmacia1.setNome(Nome);
        farmacia1.setCitta(Citta);
        farmacia1.setVia(Via);
        farmacia1.setCivico(Civico);
        return farmacia1;
    }

    private FarmaciaFactory() {
        Farmacia farmacia1 = new Farmacia();
        farmacia1.setNome("Farmacia Fitts");
        farmacia1.setCitta("Cagliari");
        farmacia1.setVia("Via Ospedale");
        farmacia1.setCivico("SNC");
        Farmacia farmacia2 = Createfarmacia("Nome", "Citta", "Via", "Civico");
        Farmacia farmacia3 = Createfarmacia("Farmacia Piroddi", "Cagliari", "Via Dolianova", "22");
        Farmacia farmacia4 = Createfarmacia("Farmacia La Morte Nera", "Quartu", "Via Cagliari", "108");
        Farmacia farmacia5 = Createfarmacia("Nome5", "Citta5", "Via5", "Civico5");


        farmacia1.addDisponibile(1);
        farmacia1.addDisponibile(3);
        farmacia2.addDisponibile(2);
        farmacia2.addDisponibile(4);
        farmacia3.addDisponibile(5);
        farmacia3.addDisponibile(1);
        farmacia4.addDisponibile(2);
        farmacia4.addDisponibile(4);
        farmacia5.addDisponibile(4);
        farmacia5.addDisponibile(5);

        listaFarmacie.add(farmacia1);
        listaFarmacie.add(farmacia2);
        listaFarmacie.add(farmacia3);
        listaFarmacie.add(farmacia4);
        listaFarmacie.add(farmacia5);
    }

    public ArrayList<Farmacia> getListaFarmacie() {
        return listaFarmacie;
    }

}
