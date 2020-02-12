/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Core.AvisC;
import Core.ReclamationC;
import Entities.Avis;
import Entities.Reclamation;

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
public class Avisetreclamation {

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
          parsedDate = dateFormat.parse("2020-02-09 11:20:21");
          Timestamp timestamp1=new java.sql.Timestamp(parsedDate.getTime());
         
          
                  Avis a = new Avis (1,1,2,"mnayek",20);
   AvisC ps = new AvisC();
        Reclamation r = new Reclamation (2,1,"perte de velo","mon velo a ete voler ce soir ",1,timestamp1);
   ReclamationC p= new ReclamationC();
  // ps.modifierAvis(1, "oooooooooooooooo", 13);
   p.modifierReclamation(4, "modif", "mofffff");
   //ps.supprimerAvis(1);
   //p.ajouterReclamation(r);
  // System.out.println(p.afficher());
      // System.out.println(ps.afficher());
        p.supprimerReclamation(7);
        System.out.println(ps.afficher()+"deleted");
          
          
          } catch (ParseException ex) {
            Logger.getLogger(Avis.class.getName()).log(Level.SEVERE, null, ex);
}

      
          
    
          
          }
          
 
}
