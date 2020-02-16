/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Belgaroui Ghazi
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
