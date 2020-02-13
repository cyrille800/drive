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
public class Chauffeur extends User {
    private String adresse;
    private int cin;
    private String permis;
    private String nom;
    private String prenom;

    public Chauffeur() {
    }

    
    public Chauffeur(int id_user,String login,String mdp,int etat,String mail, String adresse, int cin, String permis, String nom, String prenom) {
        super(id_user,login,mdp,etat,mail);
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

    public String getPermis() {
        return permis;
    }
public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public void setPermis(String permis) {
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
        String u=super.toString();
        return "Chauffeur{"+ u + ", adresse=" + adresse + ", cin=" + cin + ", permis=" + permis + ", nom=" + nom + ", prenom=" + prenom + '}';
    }

   
   
    

 
    
}
