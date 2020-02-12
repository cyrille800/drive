/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Core.LocationC;
import Core.VeloC;
import Entities.Location;
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
          System.out.println(ds.hashCode());
          SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          java.util.Date parsedDate;
          try{
          parsedDate = dateFormat.parse("2021-02-09 11:20:21");
             java.util.Date parsedDate2 = dateFormat.parse("2021-02-09 12:55:05");
          Timestamp timestamp1=new java.sql.Timestamp(parsedDate.getTime());
          Timestamp timestamp2=new java.sql.Timestamp(parsedDate2.getTime());
          
          //Location p = new Location(1,15,timestamp1,timestamp2,3);
   LocationC pr = new LocationC();
   //pr.ajouterLocation(p);
   // System.out.println(pr.afficher());
    //System.out.println(pr.Trier());
  // pr.modifierLocation(1,30,2,timestamp1,timestamp2,600);
       //System.out.println(pr.afficher());
        //pr.supprimerLocation(1);
        //System.out.println(pr.afficher()+"deleted");
              Criteres critere = new Criteres();//tu veut une choose specifiquee
    critere.ajouterCritere("prix", "0");
    critere.ajouterCritere("id_velo", "100");
    
    /*Interval listeInterval=new Interval();
     listeInterval.ajouter("id",2,12);
     listeInterval.ajouter("qte",3,11);
     System.out.println(pr.filtrerParInterval(listeInterval));*/
    
    System.out.println(pr.filterSelonDesCritere(critere));
          
          } catch (ParseException ex) {
            Logger.getLogger(DriveIntegration.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          
          //Velo p = new Velo("hd","hs",3,"hsdh",3);
          VeloC ps=new VeloC();
          //ps.ajouterVelo(p);
          //System.out.println(ps.afficher());
            // ps.modifierVelo("ghada","hs",3,"hsdh",30);
            
          
        System.out.println(ps.rechercher("hdss"));
        //ps.supprimerVelo(1);
        //System.out.println(ps.afficher()+"deleted");
          
      
                    Criteres critere = new Criteres();//tu veut une choose specifiquee
    critere.ajouterCritere("prix", "0");
    critere.ajouterCritere("id_velo", "100");
    
    System.out.println(ps.filterSelonDesCritere(critere));
        
        
        
        
    
     /*Interval listeInterval=new Interval();
     listeInterval.ajouter("id",2,12);
     listeInterval.ajouter("qte",3,11);
     System.out.println(ps.filtrerParInterval(listeInterval));*/
     
        System.out.println(ps.trier("desc", "qte"));
 
          
         
    
    
      

    }
}
