/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;


import Entities.Chauffeur;
import Entities.User;
import Utils.Criteres;
import Utils.DataSource;
import Utils.Interval;
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
public class ChauffeurC  {
       Connection cn =DataSource.getInstance().getConnexion();
       
       public Chauffeur recupereResultat(ResultSet rs){
                Chauffeur p = new Chauffeur();
         try {
             p.setId_user(rs.getInt(1));
             p.setAdresse(rs.getString(2));
             p.setCin(rs.getInt(3));
             p.setPermis(rs.getString(4));
             p.setNom(rs.getString(5));
             p.setPrenom(rs.getString(6));
         } catch (SQLException ex) {
             Logger.getLogger(UserC.class.getName()).log(Level.SEVERE, null, ex);
         }
                 
                
                return p;
   }
   public void ajouterChauffeur(Chauffeur p){
       if(Utils.FonctionsPartages.verifierCin(p.getCin())){
        String requete ="insert into chauffeur(adresse,cin,permis,nom,prenom) values (?,?,?,?,?) ";
        try {
          
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setString(1,p.getAdresse());
            pst.setInt(2,p.getCin());
            pst.setString(3,p.getPermis());
            pst.setString(4,p.getNom());
            pst.setString(5,p.getPrenom());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChauffeurC.class.getName()).log(Level.SEVERE, null, ex);
        }
       }else{
           
           System.out.println("cin incorrect");
           
       }
         
         
    }
    public List<Chauffeur> afficher(){
          List<Chauffeur> list =new ArrayList<>(); // array list Vectoc plus lent il ne pejut pas executer plusieurs en mm temps
          String requete = "select * from chauffeur";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(requete);// trajaa base de donnee huh
            while (rs.next()){
                

              list.add(recupereResultat(rs));
            }
        }
         catch (SQLException ex) {
            Logger.getLogger(ChauffeurC.class.getName()).log(Level.SEVERE, null, ex);
    }
        return list;
           
    }
     public void modifierChauffeur(int id_user,String adresse,int cin,String permis,String nom,String prenom) {
       
       String   requete = "update chauffeur set adresse=?,cin=?,permis=?,nom=?,prenom=?  where id_user=?";
         try {
            PreparedStatement pt= cn.prepareStatement(requete);
            
            pt.setString(1,adresse);
            pt.setInt(2,cin);
            pt.setString(3, permis);
            pt.setString(4,nom);
            pt.setString(5,prenom);
            pt.setInt(6, id_user);
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
       public List<Chauffeur> filtrerParInterval(Interval listeInterval){
        
     
     List<Chauffeur> list =new ArrayList<>();
          String requete = Utils.FonctionsPartages.genererRequetteInterval("chauffeur", listeInterval.getListeListeInterval());
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
   
   public List<Chauffeur> filterSelonDesCritere(Criteres critere){
   List<Chauffeur> list =new ArrayList<>();
   String requete=Utils.FonctionsPartages.genererRequetteTrie("chauffeur",critere.getListeCritere());
   
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

   public List<Chauffeur> trier(String ordre,String champs){
   List<Chauffeur> list =new ArrayList<>();
   String requete=Utils.FonctionsPartages.genererRequettetrier(ordre,"chauffeur",champs);
   
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
    public List<Chauffeur> RechercheAvance(String mot){
   List<Chauffeur> list =new ArrayList<>();
   String requete=Utils.FonctionsPartages.genererRequetteRechercherAvancer("chauffeur",mot);
       System.out.println(requete);
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
