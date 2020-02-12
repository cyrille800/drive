/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;



/**
 *
 * @author Belgaroui Ghazi
 */
public class Chauffeur {
    private int id_user;
    private String adresse;
    private int cin;
    private int permis;
    private String nom;
    private String prenom;

    public Chauffeur() {
    }

    
    public Chauffeur( String adresse, int cin, int permis, String nom, String prenom) {
       
        this.adresse = adresse;
        this.cin = cin;
        this.permis = permis;
        this.nom = nom;
        this.prenom = prenom;

    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
     
    public int getId_user() {
        return id_user;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getCin() {
        return cin;
    }

    public int getPermis() {
        return permis;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public void setPermis(int permis) {
        this.permis = permis;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Chauffeur{" + "id_user=" + id_user + ", adresse=" + adresse + ", cin=" + cin + ", permis=" + permis + ", nom=" + nom + ", prenom=" + prenom + '}';
    }

   
   
    

 
    
}
