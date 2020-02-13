/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;


import Entities.Taxi;
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
 * @author Mejbri Skander
 */
public class TaxiC {
       Connection cn =DataSource.getInstance().getConnexion();
   public void ajouterTaxi(Taxi t){
       
       if(t.getNum_chassis().length()==13)
       {
       String requete ="insert into taxi(id_chauffeur,photo,num_chassis) values (?,?,?) ";
        try {
          
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setInt(1,t.getId_chauffeur());
            pst.setString(2,t.getPhoto());
            pst.setString(3,t.getNum_chassis());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TaxiC.class.getName()).log(Level.SEVERE, null, ex);
        }
       }else{
           System.out.println("erreur de saisie");
       }
        
         
    }
    public List<Taxi> afficher(){
          List<Taxi> list =new ArrayList<>(); // array list Vectoc plus lent il ne pejut pas executer plusieurs en mm temps
          String requete = "select * from taxi";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(requete);// trajaa base de donnee huh
            while (rs.next()){
                Taxi p = new Taxi();
                p.setId_taxi(rs.getInt(1));
                p.setId_chauffeur(rs.getInt(2));
                p.setPhoto(rs.getString(3));
                p.setNum_chassis(rs.getString(4));
                list.add(p);
            }
        }
         catch (SQLException ex) {
            Logger.getLogger(TaxiC.class.getName()).log(Level.SEVERE, null, ex);
    }
        return list;
           
    }
  public List<Taxi> rechercher(String photo)
     {
         List<Taxi> list= new ArrayList<>();
           try {
            PreparedStatement pt=cn.prepareStatement("select * from taxi where num_chassis=?");
            pt.setString(1,photo);
            ResultSet rs= pt.executeQuery();
            int i=0;
            while (rs.next()){
                Taxi p = new Taxi();
                p.setId_taxi(rs.getInt(1));
                p.setId_chauffeur(rs.getInt(2));
                p.setPhoto(rs.getString(3));
                p.setNum_chassis(rs.getString(4));
                list.add(p);
                i++;
            }
            
            if(i==0) {System.out.println("aucune reponse");}
            else{System.out.println("voila");}
               
            
          } catch (SQLException ex) {
            Logger.getLogger(TaxiC.class.getName()).log(Level.SEVERE, null, ex);
        }
           return list;
     }
    
     public void modifierTaxi(int id_taxi,int id_chauffeur,String photo,String num_chassis) {
       
       String   requete = "update taxi set id_chauffeur=?,photo=?,num_chassis=?  where id_taxi=?";
         try {
            PreparedStatement pt= cn.prepareStatement(requete);
            
            pt.setInt(1,id_chauffeur);
            pt.setString(2,photo);
            pt.setString(3,num_chassis);
            pt.setInt(4,id_taxi);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TaxiC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void supprimerTaxi( int id)
     {
           try {
            PreparedStatement pt=cn.prepareStatement("delete from taxi where id_taxi=?");
           pt.setInt(1,id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TaxiC.class.getName()).log(Level.SEVERE, null, ex);
        }
           
     }
}
