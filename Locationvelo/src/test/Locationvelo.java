/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Core.LocationC;
import Core.VeloC;
import Entities.Location;
import Entities.Velo;
import Utils.DataSource;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Belgaroui Ghazi
 */
public class Locationvelo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         DataSource ds =  DataSource.getInstance();
          System.out.println(ds.hashCode());
          SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          Date parsedDate;
          try{
          parsedDate = dateFormat.parse("2021-02-09 11:20:21");
             Date parsedDate2 = dateFormat.parse("2021-02-09 12:55:05");
          Timestamp timestamp1=new java.sql.Timestamp(parsedDate.getTime());
          Timestamp timestamp2=new java.sql.Timestamp(parsedDate2.getTime());
          
          Location p = new Location(1,15,timestamp1,timestamp2,3);
   LocationC ps = new LocationC();
   ps.ajouterLocation(p);
   // System.out.println(ps.afficher());
    System.out.println(ps.Trier());
  // ps.modifierLocation(1,30,2,timestamp1,timestamp2,600);
       //System.out.println(ps.afficher());
        //ps.supprimerLocation(1);
        //System.out.println(ps.afficher()+"deleted");
          
          
          } catch (ParseException ex) {
            Logger.getLogger(Locationvelo.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          
          //Velo p = new Velo("hd","hs",3,"hsdh",3);
          VeloC ps=new VeloC();
          //ps.ajouterVelo(p);
          //System.out.println(ps.afficher());
            // ps.modifierVelo("ghada","hs",3,"hsdh",30);
            
          
        System.out.println(ps.rechercher("hdss"));
        //ps.supprimerVelo(1);
        //System.out.println(ps.afficher()+"deleted");
          
          
          
         
    
    
      

    }
    
}
