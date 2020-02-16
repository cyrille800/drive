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


/**
 *
 * @author Belgaroui Ghazi
 */
public class AjouterChauffeur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         DataSource ds =  DataSource.getInstance();
          System.out.println(ds.hashCode());
        
          
     /*     Chauffeur p = new Chauffeur("ghazella",66,21);
   ChauffeurC ps = new ChauffeurC();
   ps.ajouterChauffeur(p);
   System.out.println(ps.afficher());
   ps.modifierChauffeur(1,"Ariana",287,55);
       System.out.println(ps.afficher());
        ps.supprimerChauffeur(1);
      System.out.println(ps.afficher()+"deleted");*/
          
          Taxi t = new Taxi(25,"dgsd");
   TaxiC pt = new TaxiC();
   //pt.ajouterTaxi(t);
   //System.out.println(pt.afficher());
   //pt.modifierTaxi(8,147,"aaasdg");
     //  System.out.println(pt.afficher());
        pt.supprimerTaxi(8);
      System.out.println(pt.afficher()+"deleted");
          
          
        }
          
          
          
          
          
          
         
    
    
      

    }
    

