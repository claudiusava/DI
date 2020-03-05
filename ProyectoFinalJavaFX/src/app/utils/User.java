package app.utils;

import javafx.beans.property.SimpleStringProperty;

public class User {

    private String user, password, email, name, surname, favgenre;
    //private SimpleStringProperty propFavGenre;


    public User(String user, String email, String password, String name, String surname, String favgenre) {
        this.user = user;
        this.password = password;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.favgenre = favgenre;
        //propFavGenre = new SimpleStringProperty(favgenre);
    }


    public User(String user, String name, String surname, String email) {
        this.user = user;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public User (String user, String name, String surname, String email, String favgenre){
        this.user = user;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.favgenre = favgenre;
    }


    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }


    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }


    public String getSurname(){
        return surname;
    }
    public void setSurnameName(String surname){
        this.surname = surname;
    }


    public String getFavgenre(){ return favgenre; }
    public void setFavgenre(String favgenre){
        this.favgenre = favgenre;
    }

    /*
    public String getPropFavGenre() {
        return propFavGenre.get();
    }

    public SimpleStringProperty propFavGenreProperty() {
        return propFavGenre;
    }
     */

}

