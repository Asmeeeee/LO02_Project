import java.time.Year;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class Executable{
    public static void main(String[]args){
        // System.out.println(e1.getClasse() + " "+e1.getForce());
        // System.out.println(e2.getClasse() + " "+e2.getForce());
        // System.out.println(e3.getClasse() + " "+e3.getForce());
        //for(int i = 0; i < 20; i++){
        //    System.out.println(Math.round( Math.random() ));
        //}

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Bienvenue, C'est du Brutal!!!");
        System.out.println("Voulez-vous jouer? y/n");

        String reponse = myObj.nextLine();// Read user input
        if(reponse == "n" || reponse == "non"){
            System.out.println("Pas de probleme");
            System.out.println("Au revoir");
        }
        else{
            System.out.println("Creation de la partie");
            Partie partie = new Partie();
            partie.setJeux();
            partie.configurationEtudiant();
        }

    }
}