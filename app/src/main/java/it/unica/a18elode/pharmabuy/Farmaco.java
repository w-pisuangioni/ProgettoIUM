package it.unica.a18elode.pharmabuy;

import java.util.Date;


public class Farmaco {

    private static int idCount = 0;
    private String nome;
    private int id;
    private String descrizione;
    private float prezzo;
    private String ricetta;
    private String image;
    private String tipo;
    private Farmacia farmaciaAcquisto;
    private Farmacia farmaciaOrdine;
    private Date data;
    private Date dataRitiro;

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
       this.farmaciaOrdine = new Farmacia();
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

    public void setFarmaciaAcquisto(Farmacia f){this.farmaciaAcquisto = f;}

    public Farmacia getFarmaciaAcquisto(){return this.farmaciaAcquisto;}

    public void setFarmaciaOrdine(Farmacia f){this.farmaciaOrdine = f;}

    public Farmacia getFarmaciaOrdine(){return this.farmaciaOrdine;}

    public void setData(Date data){ this.data = data; }

    public Date getData(){return this.data;}

    public void setDataRitiro(Date dataRitiro){ this.dataRitiro = dataRitiro; }

    public Date getDataRitiro(){return this.dataRitiro;}
}

