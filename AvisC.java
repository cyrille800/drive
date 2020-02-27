/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import Entities.Avis;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Belgaroui Ghazi
 */
public class AvisC {
       Connection cn =DataSource.getInstance().getConnexion();
   public void ajouterAvis(Avis a){
          String requete ="insert into avis(id_chauffeur,id_client,msg,note) values (?,?,?,?) ";
        try {
          
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setInt(1,a.getId_chauffeur());
            pst.setInt(2,a.getId_client());
            pst.setString(3,a.getMsg());
            pst.setInt(4,a.getNote());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AvisC.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    public List<Avis> afficher(){
          List<Avis> list =new ArrayList<>(); // array list Vectoc plus lent il ne pejut pas executer plusieurs en mm temps
          String requete = "select * from avis";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(requete);// trajaa base de donnee huh
            while (rs.next()){
                Avis a = new Avis();
                a.setId_avis(rs.getInt(1));
                a.setId_chauffeur(rs.getInt(2));
                a.setId_client(rs.getInt(3));
                a.setMsg(rs.getString(4));
                a.setNote(rs.getInt(5));
                list.add(a);
            }
        }
         catch (SQLException ex) {
            Logger.getLogger(AvisC.class.getName()).log(Level.SEVERE, null, ex);
    }
        return list;
           
    }
     public void modifierAvis(int id_avis,String msg ,int note) {
       
       String   requete = "update avis set msg=?,note=?   where id_avis=?";
         try {
            PreparedStatement pt= cn.prepareStatement(requete);
            
            pt.setString(1,msg);
            pt.setInt(2,note);
            pt.setInt(3, id_avis);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AvisC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void supprimerAvis( int id)
     {
           try {
            PreparedStatement pt=cn.prepareStatement("delete from avis where id_avis=?");
           pt.setInt(1,id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AvisC.class.getName()).log(Level.SEVERE, null, ex);
        }
           
     }
}
