/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Core.AvisC;
import Core.ReclamationC;
import Core.ReservationC;
import Core.UserC;
import Entities.Reservation;
import Utils.Criteres;
import Utils.DataSource;
import Utils.Interval;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Armand
 */
public class DriveIntegration {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataSource ds =  DataSource.getInstance();
        Date date1;
        try {
            String inDate = "2021-01-06 18:20:31";
DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Timestamp ts = new Timestamp(((java.util.Date)df.parse(inDate)).getTime());
            Reservation r=new Reservation(15,16,"bafoussam","yaounde",ts,0.3f,"livraison",12,0);
            ReservationC rs=new ReservationC();
            rs.ajouterReservation(r);
        } catch (ParseException ex) {
            Logger.getLogger(DriveIntegration.class.getName()).log(Level.SEVERE, null, ex);
        }
        AvisC us=new AvisC();
     
   /* Criteres critere = new Criteres();
    critere.ajouterCritere("id_avis", "2");
    critere.ajouterCritere("note", "0");
  
   
    System.out.println(us.filterSelonDesCritere(critere));*/
    
     /*Interval listeInterval=new Interval();
     listeInterval.ajouter("note",0,2);
     listeInterval.ajouter("id_avis",0,2);
     System.out.println(us.filtrerParInterval(listeInterval));*/
     
        System.out.println(us.trier("desc", "id_avis"));
    }
    
}
