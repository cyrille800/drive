/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Core.EventC;
import Core.OffreC;
import Utils.Criteres;
import Utils.Interval;

/**
 *
 * @author Armand
 */
public class DriveIntegration {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventC us = new EventC();

        Criteres critere = new Criteres();
       critere.ajouterCritere("depart", "Tunis");
       critere.ajouterCritere("arrivee", "Carthage");
        System.out.println(us.filterSelonDesCritere(critere));
        
      //  System.out.println(us.afficherEvent());
        System.out.println("*******************************************************"); 
     OffreC oc = new OffreC();
     //  System.out.println(oc.afficherReduction()); 
       System.out.println(oc.afficherPromo());
        Interval listeInterval = new Interval();

        listeInterval.ajouter("depart", "Tunis", 2);
        listeInterval.ajouter("arrivee", 15, 16);
        System.out.println(us.filtrerParInterval(listeInterval));
    }

}
