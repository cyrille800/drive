/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import Entities.Location;
import Entities.Velo;
import Utils.DataSource;
import Utils.FonctionsPartagees;
import java.sql.Connection;
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
       
  
   public void ajouterLocation(Location p){
       
       // permet de recuperer le orix d'un vélo
       String requete ="select prix from velo where id=? limit 1";
       PreparedStatement pt1;
       float prix=0;
          
       try {
               pt1 = cn.prepareStatement(requete);
               pt1.setInt(1,p.getId_velo());
            ResultSet rs= pt1.executeQuery();
            while (rs.next()){
                float prixLocal=rs.getFloat(1);
                prix= Utils.FonctionsPartagees.calculerPrixParraportAuTemps(prixLocal, Utils.FonctionsPartagees.calculerNombreSeconde(p.getDate_d(), p.getDate_f()));
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
          String requete = "select * from location";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(requete);// trajaa base de donnee huh
            while (rs.next()){
                Location p = new Location();
                p.setId_location(rs.getInt(1));
                p.setId_client(rs.getInt(2));
                p.setId_velo(rs.getInt(3));
                p.setDate_d(rs.getTimestamp(4));
                p.setDate_f(rs.getTimestamp(5));
                p.setPrix(rs.getFloat(6));
                list.add(p);
            }
        }
         catch (SQLException ex) {
            Logger.getLogger(LocationC.class.getName()).log(Level.SEVERE, null, ex);
    }
        return list;
           
    }
     public void modifierLocation(int id_location,int id_client,int id_velo,Timestamp date_d,Timestamp date_f ,float prix) {
       
       String   requete = "update location set id_client=?, id_velo=?,date_d=?,date_f=?,prix=?  where id_location=?";
         try {
            PreparedStatement pt= cn.prepareStatement(requete);
            
            pt.setInt(1,id_client);
            pt.setInt(2,id_velo);
            pt.setTimestamp(3, date_d);
            pt.setTimestamp(4, date_f);
            pt.setFloat(5, prix);
            pt.setInt(6, id_location);
             
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LocationC.class.getName()).log(Level.SEVERE, null, ex);
        }
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
     
}
