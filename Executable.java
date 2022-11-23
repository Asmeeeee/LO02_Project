
import java.util.Scanner;


public class Executable{
    public static void main(String[]args){

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
            //partie.configurationEtudiant();
            //TODO Creer 4 etudaint avec attribut max
            partie.demarrerMelee();
            partie.demarrerTreve();
        }

    }
}