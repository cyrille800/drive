/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import Entities.Location;
import Entities.Velo;
import Utils.Criteres;
import Utils.DataSource;
import Utils.FonctionsPartages;
import Utils.Interval;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Belgaroui Ghazi
 */
public class LocationC {
       Connection cn =DataSource.getInstance().getConnexion();
       public Location recupereResultat(ResultSet rs){
                Location p = new Location();
         try {
             p.setId_location(rs.getInt(1));
                p.setId_client(rs.getInt(2));
                p.setId_velo(rs.getInt(3));
                p.setDate_d(rs.getTimestamp(4));
                p.setDate_f(rs.getTimestamp(5));
                p.setPrix(rs.getFloat(6));
         } catch (SQLException ex) {
             Logger.getLogger(UserC.class.getName()).log(Level.SEVERE, null, ex);
         }
                 
                
                return p;
   }
       
   public void ajouterLocation(Location p){
         String requete ="select prix from velo where id=? limit 1";
       PreparedStatement pt1;
       float prix=0;
          
       try {
               pt1 = cn.prepareStatement(requete);
               pt1.setInt(1,p.getId_velo());
            ResultSet rs= pt1.executeQuery();
            while (rs.next()){
                float prixLocal=rs.getFloat(1);
                prix= Utils.FonctionsPartages.calculerPrixParraportAuTemps(prixLocal, Utils.FonctionsPartages.calculerNombreSeconde(p.getDate_d(), p.getDate_f()));
            }
           } catch (SQLException ex) {
               Logger.getLogger(LocationC.class.getName()).log(Level.SEVERE, null, ex);
           }
       //fin
       
          requete ="insert into location(id_client,id_velo,date_d,date_f,prix) values (?,?,?,?,?) ";
        try {
            
          
          PreparedStatement pst = cn.prepareStatement(requete);
            pst.setInt(1,p.getId_client());
            pst.setInt(2,p.getId_velo());
            pst.setTimestamp(3,(Timestamp) p.getDate_d());
            pst.setTimestamp(4,(Timestamp) p.getDate_f());
            pst.setFloat(5,prix);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LocationC.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    public List<Location> afficher(){
          List<Location> list =new ArrayList<>(); // array list Vectoc plus lent il ne pejut pas executer plusieurs en mm temps
          String requete = "select * from location ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(requete);// trajaa base de donnee huh
            while (rs.next()){
                
                
                list.add(recupereResultat(rs));
            }
        }
         catch (SQLException ex) {
            Logger.getLogger(LocationC.class.getName()).log(Level.SEVERE, null, ex);
    }
        return list;
           
    }
     public boolean modifierLocation(int id,String champs,Object value){
    String   requete = "update location set "+champs+"=?  where id_location=?";
         if(FonctionsPartages.verifierExistanteDuneValeur("location","id_location",id)==true && FonctionsPartages.verifierSiChampExistant("location",champs)==true){
       try {
            PreparedStatement pt= cn.prepareStatement(requete);
            
            if (value instanceof Integer){
            pt.setInt(1,(int) value);
            }
             if (value instanceof Float){
            pt.setFloat(1,(float) value);
            }   
             if (value instanceof Double){
            pt.setDouble(1,(double) value);
            } 
             if (value instanceof String){
            pt.setString(1,(String) value);
            } 
             if (value instanceof Date){
            pt.setDate(1,(Date) value);
            } 
             if (value instanceof Timestamp){
            pt.setTimestamp(1,(Timestamp) value);
            } 
            pt.setInt(2, id);
            pt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(VeloC.class.getName()).log(Level.SEVERE, null, ex);
        }  
       }else{
             System.out.println("le champs ou l'identifiant est incorrect");
         }
       
       return false;
   }
      public void supprimerLocation( int id)
     {
           try {
            PreparedStatement pt=cn.prepareStatement("delete from location where id_location=?");
           pt.setInt(1,id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LocationC.class.getName()).log(Level.SEVERE, null, ex);
        }
           
     }
    
     public List<Location> filterSelonDesCritere(Criteres critere){
   List<Location> list =new ArrayList<>();
   String requete=Utils.FonctionsPartages.genererRequetteTrie("location",critere.getListeCritere());
   
   try {
            Statement st = cn.createStatement();
            if(!requete.equals("")){
                ResultSet rs = st.executeQuery(requete);// trajaa base de donnee huh
            while (rs.next()){
               list.add(recupereResultat(rs));
            }
            }
        }
         catch (SQLException ex) {
            Logger.getLogger(UserC.class.getName()).log(Level.SEVERE, null, ex);
    }
   
   return list;
   }
       public List<Location> filtrerParInterval(Interval listeInterval){
        
     
     List<Location> list =new ArrayList<>();
          String requete = Utils.FonctionsPartages.genererRequetteInterval("location", listeInterval.getListeListeInterval());
        try {
            Statement st = cn.createStatement();
            
            ResultSet rs = st.executeQuery(requete);// trajaa base de donnee huh
            while (rs.next()){
                list.add(recupereResultat(rs));
            }
        }
         catch (SQLException ex) {
            Logger.getLogger(UserC.class.getName()).log(Level.SEVERE, null, ex);
    }
        return list;
     }
       public List<Location> trier(String ordre,String champs){
   List<Location> list =new ArrayList<>();
   String requete=Utils.FonctionsPartages.genererRequettetrier(ordre,"location",champs);
   
   try {
            Statement st = cn.createStatement();
            if(!requete.equals("")){
                ResultSet rs = st.executeQuery(requete);// trajaa base de donnee huh
            while (rs.next()){
            list.add(recupereResultat(rs));
            }
            }
        }
         catch (SQLException ex) {
            Logger.getLogger(UserC.class.getName()).log(Level.SEVERE, null, ex);
    }
   
   return list;
   }
     public List<Location> RechercheAvance(String mot){
   List<Location> list =new ArrayList<>();
   String requete=Utils.FonctionsPartages.genererRequetteRechercherAvancer("location",mot);
  
   try {
            Statement st = cn.createStatement();
            if(!requete.equals("")){
                ResultSet rs = st.executeQuery(requete);// trajaa base de donnee huh
            while (rs.next()){
               list.add(recupereResultat(rs));
            }
            }
        }
         catch (SQLException ex) {
            Logger.getLogger(UserC.class.getName()).log(Level.SEVERE, null, ex);
    }
   
   return list;
   } 
}
