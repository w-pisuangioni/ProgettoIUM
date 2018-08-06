package it.unica.a18elode.pharmabuy;


public class Person {
    private static int idCount = 0;
    private int id;
    private String username;
    private String password;
    private String email;

    public Person(){
        this.id = idCount++;
        this.username="";
        this.password="";
        this.email="";
        idCount++;
    }
    public Person(String username,String password, String email){
        this.id = idCount++;
        idCount++;
        this.username=username;
        this.password=password;
        this.email=email;
    }

    public int getId() {return id;}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public boolean equals(Object other) {
        if (other instanceof Person)
            if (this.getId() == ((Person)other).getId()) return true;
        return false;
    }
}
