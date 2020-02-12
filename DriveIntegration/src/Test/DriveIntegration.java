/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Core.ChauffeurC;
import Entities.Chauffeur;
import Entities.Taxi;
import Utils.DataSource;
import Core.TaxiC;
import Utils.Criteres;
import Utils.Interval;


/**
 *
 * @author Belgaroui Ghazi
 */
public class DriveIntegration {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         DataSource ds =  DataSource.getInstance();
          System.out.println(ds.hashCode());
        
          
          Chauffeur p = new Chauffeur("ghazella",66,21,"skander","mejbri");
   ChauffeurC ps = new ChauffeurC();
   /*ps.ajouterChauffeur(p);
   System.out.println(ps.afficher());
   ps.modifierChauffeur(1,"Ariana",287,55);
       System.out.println(ps.afficher());
        ps.supprimerChauffeur(1);
      System.out.println(ps.afficher()+"deleted");*/
          
          Taxi t = new Taxi(25,"dgsd","skander");
   TaxiC pt = new TaxiC();
   //pt.ajouterTaxi(t);
   //System.out.println(pt.afficher());
   //pt.modifierTaxi(8,147,"aaasdg");
     //  System.out.println(pt.afficher());
       // pt.supprimerTaxi(8);
      //System.out.println(pt.afficher()+"deleted");
          
      /*    Criteres critere = new Criteres();
    critere.ajouterCritere("nom", "skander");
    critere.ajouterCritere("prenom", "ha");
    System.out.println(ps.filterSelonDesCritere(critere));
    */
    /* Interval listeInterval=new Interval();
     listeInterval.ajouter("id_user",8,9);
     listeInterval.ajouter("permis",11,21);
     System.out.println(ps.filtrerParInterval(listeInterval));*/
     
        System.out.println(ps.trier("desc", "id_user"));
        }
          
          
          
          
          
          
         
    
    
      

    }
    

