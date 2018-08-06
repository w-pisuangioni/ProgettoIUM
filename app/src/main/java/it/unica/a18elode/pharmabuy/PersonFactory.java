package it.unica.a18elode.pharmabuy;

import java.util.ArrayList;

public class PersonFactory {

    private static PersonFactory singleton;
    public static PersonFactory getInstance() {
        if (singleton == null) {
            singleton = new PersonFactory();
        }
        return singleton;
    }
    private ArrayList<Person> listaPersone= new ArrayList<Person>();
    private PersonFactory(){
        //creazione persone

        Person person1 = new Person();
        person1.setUsername("igna123");
        person1.setPassword("123");
        person1.setEmail("ignaskip@gmail.com");

        Person person2 = new Person();
        person2.setUsername("giampy123");
        person2.setPassword("1234");
        person2.setEmail("pazzini@gmail.com");

        Person person3 = new Person();
        person3.setUsername("abc");
        person3.setPassword("abc");
        person3.setEmail("abc");

        listaPersone.add(person1);
        listaPersone.add(person2);
        listaPersone.add(person3);
    }

    public ArrayList<Person> getListaPersone(){
        return listaPersone;
    }

    public int getIdByUserAndPassword(String username, String password){
        for(Person user : this.listaPersone){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user.getId();
            }
        }
        return -1;
    }
    public int getIdByEmailAndPassword(String email, String password){
        for(Person user : this.listaPersone){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                return user.getId();
            }
        }
        return -1;
    }
}
