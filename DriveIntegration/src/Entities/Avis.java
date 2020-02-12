/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Utils.Criteres;
import Utils.Interval;

/**
 *
 * @author ASUS
 */
public class Avis {
    private int id_avis;
    private Chauffeur chauffeur;
    private Client client;
    private String msg;
    private int note;

    /**
     *
     * @param id_avis
     * @param id_chauffeur
     * @param id_client
     * @param msg
     * @param note
     */
    public Avis(int id_avis, Chauffeur chauffeur, Client client, String msg, int note) {
        this.id_avis = id_avis;
        this.chauffeur = chauffeur;
        this.client = client;
        this.msg = msg;
        this.note = note;
    }

    public Chauffeur getChauffeur() {
        return chauffeur;
    }

    public void setChauffeur(Chauffeur chauffeur) {
        this.chauffeur = chauffeur;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    
    public Avis() {
    }

    public int getId_avis() {
        return id_avis;
    }

 
    public String getMsg() {
        return msg;
    }

    public int getNote() {
        return note;
    }

    public void setId_avis(int id_avis) {
        this.id_avis = id_avis;
    }

   

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setNote(int note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "AvisC{" + "id_avis=" + id_avis + getChauffeur().toString() + getClient().toString()  + ", msg=" + msg + ", note=" + note + '}';
    }

    public void setInt(int i, int id_chauffeur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setString(int i, String msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean filtrerParInterval(Interval listeInterval) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean filterSelonDesCritere(Criteres critere) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
    
    
    
    
}
