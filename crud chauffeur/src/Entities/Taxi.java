/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author HP
 */
public class Taxi {
        private int id_taxi;
        private int id_chauffeur;
        private String photo;
    
public Taxi()
{
}

    public Taxi(int id_chauffeur, String photo) {
        this.id_chauffeur = id_chauffeur;
        this.photo = photo;
    }

    public int getId_taxi() {
        return id_taxi;
    }

    public int getId_chauffeur() {
        return id_chauffeur;
    }

    public String getPhoto() {
        return photo;
    }

    public void setId_taxi(int id_taxi) {
        this.id_taxi = id_taxi;
    }

    public void setId_chauffeur(int id_chauffeur) {
        this.id_chauffeur = id_chauffeur;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Taxi{" + "id_taxi=" + id_taxi + ", id_chauffeur=" + id_chauffeur + ", photo=" + photo + '}';
    }
    

}
