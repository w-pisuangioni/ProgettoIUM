package it.unica.a18elode.pharmabuy;

/**
 * Created by Utente on 19/02/2018.
 */

public class Farmaco {

    private static int idCount = 0;
    private String nome;
    private int id;
    private String descrizione;
    private float prezzo;
    private String ricetta;
    private String image;
    private String tipo;
   // private String data;
    private Farmacia farmaciaAcquisto;

    public Farmaco (){
       this.nome ="";
       this.id = 0;
       this.descrizione="";
       this.prezzo= 0.0f;
       this.ricetta ="";
       this.image="";
      // this.data="";
       this.tipo="";
       this.farmaciaAcquisto = new Farmacia();
       idCount++;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public String getImage() {
        return image;
    }

    public String getNome() {
        return nome;
    }

    public String getRicetta() {
        return ricetta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public void setRicetta(String ricetta) {
        this.ricetta = ricetta;
    }

   // public void setData(String data){this.data= data;}

    public void setFarmaciaAcquisto(Farmacia f){this.farmaciaAcquisto = f;}

    public Farmacia getFarmaciaAcquisto(){return this.farmaciaAcquisto;}

}

