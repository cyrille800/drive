/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Core.EventC;
import Core.OffreC;
import Entities.Event;
import Entities.Offre;
import Utils.DataSource;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Meriem
 */
public class Marketing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //  DataSource ds = DataSource.getInstance();
        //   System.out.println(ds.hashCode());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parsedDate1;
        Date parsedDate;
        Date parsedDate12;
        Date parsedDate11;

        try {
            // Ajout
            parsedDate = dateFormat.parse("2000-11-11 11:20:21 PM");
            parsedDate1 = dateFormat.parse("2000-11-11 23:11:21 PM ");
            Timestamp timestamp1 = new java.sql.Timestamp(parsedDate.getTime());
            Timestamp timestamp2 = new java.sql.Timestamp(parsedDate1.getTime());
               // Fin Ajout

            // Modif 
            parsedDate11 = dateFormat.parse("2000-11-11 11:20:21");
            parsedDate12 = dateFormat.parse("2000-11-11 23:11:21");
            Timestamp timestamp11 = new java.sql.Timestamp(parsedDate11.getTime());
            Timestamp timestamp22 = new java.sql.Timestamp(parsedDate12.getTime());
            // Fin Modif

            //        Event e = new Event("Mouled", 120, "Tunis","Kairoun",timestamp1, timestamp2, "Cet evenement sera une journée, Bienvenue à tous ");
            EventC ec = new EventC();
            //     ec.ajouterEvent(e);
            //    ec.supprimerEvent(1);
            //     ec.modifierEvent(2, "Festivale de Carthage", 10, "Carthage", timestamp11, timestamp22, "Bienvenu à la meilleure musique");
           System.out.println(ec.afficherEvent());
         //   System.out.println(ec.rechercher("Mouled")); 
        } catch (ParseException ex) {
            Logger.getLogger(Marketing.class.getName()).log(Level.SEVERE, null, ex);
        }

        //  System.out.println(ec.afficher());
        //***************************************************************************************************************************************//
        Date date_debut_offre;
        Date date_fin_offre;
        Date date_debut_offre2;
        Date date_fin_offre2;

        try {
            // Ajout
            date_debut_offre = dateFormat.parse("2000-11-11 11:20:21");
            date_fin_offre = dateFormat.parse("2000-11-11 23:11:21");
            Timestamp timestamp1 = new java.sql.Timestamp(date_debut_offre.getTime());
            Timestamp timestamp2 = new java.sql.Timestamp(date_fin_offre.getTime());
               // Fin Ajout

            // Modif 
            date_debut_offre2 = dateFormat.parse("2000-11-11 11:20:21");
            date_fin_offre2 = dateFormat.parse("2000-11-11 23:11:21");
            Timestamp timestamp11 = new java.sql.Timestamp(date_debut_offre2.getTime());
            Timestamp timestamp22 = new java.sql.Timestamp(date_fin_offre2.getTime());
            // Fin Modif

            //    Offre o = new Offre(timestamp1, timestamp2, "Location","Fete des arbres",0.5f,23f); // Réduction
            Offre o = new Offre(timestamp1, timestamp2, "Location", "Fete des opa", 0.5f, 23f); // Réduction
            //   Offre o2 = new Offre(timestamp11, timestamp22, "Reservation", "Promouvoir ", "JFT23L", 0.5f, 23f); // code_promo
            OffreC oc = new OffreC();
            //  oc.ajouterReduction(o);
            //     oc.ajouterCodePromo(o2);
            //    oc.supprimerOffre(5);
        //    System.out.println(oc.afficherReduction()); // No

        //    oc.ModifierReduction(4, timestamp22, timestamp22, "Reservation", "opa", 0.3f, 20f); // hne lzm ken mte3 reduction
        //    oc.modifierCodePromo(3, timestamp22, timestamp22, "Location", "Promotion", "JFFF100", 2.1f, 10f); // hne lzm ken mtee3 el code_promo
        } catch (ParseException ex) {
            Logger.getLogger(Marketing.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
