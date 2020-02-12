/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;


import Entities.Chauffeur;
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
public class ChauffeurC {
       Connection cn =DataSource.getInstance().getConnexion();
   public void ajouterChauffeur(Chauffeur p){
          String requete ="insert into chauffeur(adresse,cin,permis) values (?,?,?) ";
        try {
          
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setString(1,p.getAdresse());
            pst.setInt(2,p.getCin());
            pst.setInt(3,p.getPermis());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChauffeurC.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    public List<Chauffeur> afficher(){
          List<Chauffeur> list =new ArrayList<>(); // array list Vectoc plus lent il ne pejut pas executer plusieurs en mm temps
          String requete = "select * from chauffeur";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(requete);// trajaa base de donnee huh
            while (rs.next()){
                Chauffeur p = new Chauffeur();
                p.setId_user(rs.getInt(1));
                p.setAdresse(rs.getString(2));
                p.setCin(rs.getInt(3));
                p.setPermis(rs.getInt(4));
                list.add(p);
            }
        }
         catch (SQLException ex) {
            Logger.getLogger(ChauffeurC.class.getName()).log(Level.SEVERE, null, ex);
    }
        return list;
           
    }
     public void modifierChauffeur(int id_user,String adresse,int cin,int permis) {
       
       String   requete = "update chauffeur set adresse=?,cin=?,permis=?  where id_user=?";
         try {
            PreparedStatement pt= cn.prepareStatement(requete);
            
            pt.setString(1,adresse);
            pt.setInt(2,cin);
            pt.setInt(3, permis);
            pt.setInt(4, id_user);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChauffeurC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void supprimerChauffeur( int id)
     {
           try {
            PreparedStatement pt=cn.prepareStatement("delete from chauffeur where id_user=?");
           pt.setInt(1,id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChauffeurC.class.getName()).log(Level.SEVERE, null, ex);
        }
           
     }
}
