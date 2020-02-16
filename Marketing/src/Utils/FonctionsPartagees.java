/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Core.LocationC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Meriem
 */
public class FonctionsPartagees {
          public static int calculerNombreSeconde(Timestamp date1,Timestamp date2){
              long intervalle = date2.getTime() - date1.getTime();
        return (int) TimeUnit.SECONDS.convert(intervalle, TimeUnit.MILLISECONDS);
        }
 
        public static float calculerPrixParraportAuTemps(float prixDuneHeure,int seconde){
        return ((float) seconde/3600)*prixDuneHeure;
        }
          
}
