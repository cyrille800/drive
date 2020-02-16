/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Core.ClientC;
import Core.ReservationC;
import Core.UserC;
import Entities.Client;
import Entities.Reservation;
import Entities.User;
import Utils.Criteres;
import Utils.DataSource;
import Utils.Criteres;
import Utils.Interval;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Armand
 */
public class CLientReservation {

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
            Logger.getLogger(CLientReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
     UserC us=new UserC();
     
    /*Criteres critere = new Criteres();
    critere.ajouterCritere("login", "armand");
    critere.ajouterCritere("etat", 1);
    critere.ajouterCritere("mail", "armand@gmail.com");
    System.out.println(us.filterSelonDesCritere(critere));*/
    
     /*Interval listeInterval=new Interval();
     listeInterval.ajouter("etat",1,2);
     listeInterval.ajouter("id_user",15,16);
     System.out.println(us.filtrerParInterval(listeInterval));*/
     
        System.out.println(us.trier("desc", "id_user"));

    }

}
