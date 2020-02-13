/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Core.ChauffeurC;
import Core.TaxiC;
import Entities.Chauffeur;
import Entities.Taxi;
import Utils.Criteres;
import Utils.DataSource;
import Utils.Interval;

/**
 *
 * @author HP
 */
public class ChauffeurTaxi {
    
    public static void startConsole(){
         DataSource ds =  DataSource.getInstance();
          System.out.println(ds.hashCode());
        
          
        Chauffeur p = new Chauffeur(1,"dgdgs","dggd",2,"dgsg@sgsg","ghazella",10147258,"23/789456","skan","mej");
   ChauffeurC ps = new ChauffeurC();
  /* ps.ajouterChauffeur(p);
   //System.out.println(ps.afficher());
   ps.modifierChauffeur(8,"Ariana",28700000,"24/789123","ska","skan");
       System.out.println(ps.afficher());
        //ps.supprimerChauffeur(1);
      //System.out.println(ps.afficher()+"deleted");*/
          
          Taxi t = new Taxi(28,"dgsd","bcdgdgdg87452");
   TaxiC pt = new TaxiC();
  // pt.ajouterTaxi(t);
  // System.out.println(pt.afficher());
  // pt.modifierTaxi(8,147,"aaasdg");
     /*  System.out.println(pt.afficher());
        pt.supprimerTaxi(8);
      System.out.println(pt.afficher()+"deleted");
          Criteres critere = new Criteres();//tu veut une choose specifiquee
    critere.ajouterCritere("id_taxi", "13");
    critere.ajouterCritere("id_chauffeur", "49");
    
    System.out.println(pt.filterSelonDesCritere(critere));
        
        
     Interval listeInterval=new Interval();
     listeInterval.ajouter("id_taxi",12,14);
     listeInterval.ajouter("id_chauffeur",28,47);
     System.out.println(ps.filtrerParInterval(listeInterval));
     
        System.out.println(pt.trier("desc","id_taxi"));*/
            /*Criteres critere = new Criteres();//tu veut une choose specifiquee
    critere.ajouterCritere("id_taxi", "13");
    critere.ajouterCritere("id_chauffeur", "49");
    
    System.out.println(ps.filterSelonDesCritere(critere));
        */
       /* 
     Interval listeInterval=new Interval();
     listeInterval.ajouter("id_taxi",12,14);
     listeInterval.ajouter("id_chauffeur",28,47);
     System.out.println(ps.filtrerParInterval(listeInterval));
     */
        //System.out.println(pt.trier("desc", "qte"));
          //System.out.println(ps.RechercheAvance("a"));
          System.out.println(pt.RechercheAvance("a"));
    }
}
