/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Core.ReservationC;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Armand
 */
public class FonctionsPartages {
    static Connection cn =DataSource.getInstance().getConnexion();
    
    
              public static boolean verifierSiChampExistant(String table,String champs){
     String requette="SELECT TABLE_NAME, COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE COLUMN_NAME LIKE '"+champs+"'";
     Statement st;
         try {
             st = cn.createStatement();
                         ResultSet rs = st.executeQuery(requette);
            while (rs.next()){
                if(rs.getString(1).equals(table)==true && rs.getString(2).equals(champs)==true)
                    return true;
            }
         } catch (SQLException ex) {
             Logger.getLogger(ReservationC.class.getName()).log(Level.SEVERE, null, ex);
         }
     return false;
     }
              
              public static boolean verifierSiTableExistant(String table){
     String requette="SHOW TABLES LIKE '"+table+"'";
     Statement st;
         try {
             st = cn.createStatement();
                         ResultSet rs = st.executeQuery(requette);
            while (rs.next()){
                if(rs.getString(1).equals(table)==true)
                    return true;
            }
         } catch (SQLException ex) {
             Logger.getLogger(ReservationC.class.getName()).log(Level.SEVERE, null, ex);
         }
     return false;
     }

     public static boolean verifierExistanteDuneValeur (String table,String champs,Object value){
    if(verifierSiTableExistant(table)==true && verifierSiChampExistant(table,champs)==true){
    String   requete = "select * from "+table+" where "+champs+"=?";     
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
             ResultSet rs = pt.executeQuery();// trajaa base de donnee huh
            while (rs.next()){
                return true;
            }
         } catch (SQLException ex) {
             Logger.getLogger(ReservationC.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
     return false;
     }
     

     
     public static boolean verifierAdresseMail(String email){
    String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
Pattern p = Pattern.compile(regex);
Matcher matcher = p.matcher(email);
     return matcher.matches();
     }

     public static boolean verifierDate(String date){
    String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
Pattern p = Pattern.compile(regex);
Matcher matcher = p.matcher(date);
     return matcher.matches();
     }
     
     public static boolean verifierNumeroPhone(String date){
    String regex = "[1-9][0-9]{7}";
Pattern p = Pattern.compile(regex);
Matcher matcher = p.matcher(date);
     return matcher.matches();
     }
     
        public static String genererRequetteTrie(String table,Map<String,List<Object>> critere){
            if(verifierSiTableExistant(table)){
            String requete=" select * from "+table;
   if(critere.keySet().size()!=0){
   requete+=" where ";
   }
   int taille,i= 0;
   int j=1;
   int taille1=critere.keySet().size();
   for(String cle : critere.keySet()){
       
       if(verifierSiChampExistant(table,cle)){
       requete+=cle+" in (";
       taille=critere.get(cle).size();
       i=1;
       for(Object valeur : critere.get(cle)){
           requete+="'"+valeur+"'";
           
           if(i<taille){
           requete+=",";
           }
           i++;
       }
       requete+=") ";
       
       if(j<taille1){
       requete+=" and ";
       }
       j++;}
       else{
           taille1--;
           System.out.println("le champs "+cle+" n'existe pas");
       }
       
   }
   return requete;
            }else{
                System.out.println("la table n'existe pas");
                return "";
            }
      
   }
        
        public static String genererRequetteInterval(String table,Map<String,Object[]> listeInterval){
            if(verifierSiTableExistant(table)){
            String requete=" select * from "+table;
   if(listeInterval.keySet().size()!=0){
   requete+=" where ";
   }
   int taille;
   int j=1;
   int taille1=listeInterval.keySet().size();
   for(String cle : listeInterval.keySet()){
       if(verifierSiChampExistant(table,cle)){
       requete+=cle+" BETWEEN '"+listeInterval.get(cle)[0]+"' AND '"+listeInterval.get(cle)[1]+"'";
       
       
       if(j<taille1){
       requete+=" and ";
       }
       j++;
       }
       else{
           taille1--;
           System.out.println("le champs "+cle+" n'existe pas");
       }
       
   }
   return requete;
            }else{
                System.out.println("la table n'existe pas");
                return "";
            }
      
   }
        
   public static String genererRequettetrier(String ordre,String table,String champs){
       
       if(verifierSiTableExistant(table)){
           if(verifierSiChampExistant(table,champs)){
               if(ordre.equals("asc")==true || ordre.equals("desc")){
                   String requete = "select * from "+table+" order by "+champs+ " "+ordre;
                   return requete;
               }else{
                System.out.println("l'order  "+champs+" n'existe pas. Nous avond 'asc' ou 'desc'");     
               }
           }else{
            System.out.println("le champs "+champs+" n'existe pas");   
           }
           
       }else{
           System.out.println("la table "+champs+" n'existe pas");
       }
       
       return "";
       
   }
}
