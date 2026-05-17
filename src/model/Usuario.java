package model;

import java.util.ArrayList;

public class Usuario {
    //Atributos
    private String name;
    private String email;
    private int userID;
    public ArrayList<Prestamo> prestamos;

    //Constructor
//    public model.Usuario(String name, String email, String password){
//        this.setName(name);
//        this.setEmail(email);
//        this.setPassword(password);
//    }

    //Métodos

    //Getters

    public String getName() {
        return name;
    }

    public String getEmail(){
        return email;
    }

    public int getUserID() {
        return userID;
    }

    //Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
