/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Core.EventC;
import Core.OffreC;
import Entities.Event;
import Entities.Offre;
import Utils.Criteres;
import Utils.Interval;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Meriem
 */
public class OffreEvent {
    
    public static void startConsole(){
        /**
         * *****************************************************************
         */
        /**
         * *****************************************************************
         */
        /*Event*/
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parsedDate1;
        Date parsedDate;
        Date parsedDate12;
        Date parsedDate11;
        try {
            // date pour l'Ajout
            parsedDate = dateFormat.parse("2000-11-11 11:20:21 PM");
            parsedDate1 = dateFormat.parse("2000-11-15 23:11:21 PM ");
            Timestamp timestamp1 = new java.sql.Timestamp(parsedDate.getTime());
            Timestamp timestamp2 = new java.sql.Timestamp(parsedDate1.getTime());
               // Fin Ajout

            // date pour la Modif 
            parsedDate11 = dateFormat.parse("2000-11-12 11:20:21");
            parsedDate12 = dateFormat.parse("2000-11-13 23:11:21");
            Timestamp timestamp11 = new java.sql.Timestamp(parsedDate11.getTime());
            Timestamp timestamp22 = new java.sql.Timestamp(parsedDate12.getTime());
            // Fin Modif
            
               Event e = new Event("Festivale de grenade ", 120, "Tunis","Testour",timestamp1, timestamp2," Bienvenue à tous ");
            EventC ec = new EventC();
           //     ec.ajouterEvent(e);
            //    ec.supprimerEvent(1);
           //     ec.modifierEvent(2,"depart","Tunis");
           // System.out.println(ec.afficherEvent());
         //      System.out.println(ec.rechercher("Mouled")); 
        

        /**
         * *****************************************************************
         */
        EventC us = new EventC();
        
      //      System.out.println(us.RechercheAvancePrRedution("3")); 
        
        

     //   Criteres critere = new Criteres();
      //  critere.ajouterCritere("depart", "Tunis");
      // critere.ajouterCritere("arrivee", "Carthage");
     //   System.out.println(us.filterSelonDesCritere(critere));

        //  System.out.println(us.afficherEvent());
        System.out.println("*******************************************************");
        
        // 
        Interval listeInterval = new Interval();
        listeInterval.ajouter("id_event", 2, 4);
        listeInterval.ajouter("nbr_place", 100, 120);
     // System.out.println(us.filtrerParInterval(listeInterval));
      

        /**
         * *****************************************************************
         */
        /**
         * *****************************************************************
         */
        /* OFFRE */
        Offre op =new Offre(timestamp1,timestamp2,"location","Promotion",2.1f);
        Offre or =new Offre(timestamp11,timestamp22,"reservation","Promotion",0.5f,"JFFF32");
        OffreC oc = new OffreC();
        
      //  Criteres critere = new Criteres();
        //critere.ajouterCritere("type", "location");
      //  critere.ajouterCritere("nom", "Promotion");
     //   System.out.println(oc.filterSelonDesCritere(critere));
     //   System.out.println(oc.trier("desc", "reduction_offre"));
        
   //     Interval listeInterval = new Interval();
     //   listeInterval.ajouter("id_offre", 4, 8);
      //  listeInterval.ajouter("reduction_offre", 0.5f, 2.1f);
        
     //   System.out.println(oc.filtrerParInterval(null));
          System.out.println(oc.afficherReduction()); 
       // oc.ajouterReduction(op);
      //  oc.ajouterReduction(or);
     //   oc.supprimerOffre(2);
   //  oc.modifierOffre(9,"code_promo","JKKK55");
     
     //   System.out.println(oc.afficherReduction());
         
        
        
        
        
       //  System.out.println(oc.RechercheAvance("p")); 
        //    System.out.println("*** location");
        
            
        
        
        
       } catch (ParseException ex) {
            Logger.getLogger(DriveIntegration.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
