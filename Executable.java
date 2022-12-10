
import java.time.Year;
import java.util.Scanner;


public class Executable{
    public static void main(String[]args){
        Scanner myObj = new Scanner(System.in);
        boolean replay = true;
        while(replay){
            lancerPartie();
            System.out.println("Voulez-vous rejouer? y/n");
            String reponse = myObj.nextLine();
            if(!reponse.equals("y")){
                replay = false;
            }
        }
    }







    public static void lancerPartie(){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println(Message.tag()+" DEMARRAGE "+Message.tag());
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
            //TEST
            partie.configurationEtudiant();
            //TODO Creer 4 etudaint avec attribut max
            // for(Joueur j : partie.getLesJoueurs()){
            //     for(Zone z : partie.getLesZones()){
            //         for(int i = 0; i < 3; i++){
            //             Etudiant e = EtudiantFactory.getEtudiantMaxSpec(j);
            //             e.setZone(z);
            //             z.getEtudiants().add(e);
            //             if(i%2!=0){
            //                 e.setReserviste(true);
            //             }
            //         }
            //     }
            // }
            //FIN TEST
            while(partie.getLesJoueurs().get(0).getMesZones().size()<3 && partie.getLesJoueurs().get(1).getMesZones().size()<3){
                partie.demarrerMelee();
                if(partie.getLesJoueurs().get(0).getMesZones().size()>=3 || partie.getLesJoueurs().get(1).getMesZones().size()>=3){
                    break;
                }
                partie.demarrerTreve();
            }
            String vainqueur;
            if(partie.getLesJoueurs().get(0).getMesZones().size()>=3){
                vainqueur = "1";
            }
            else{
                vainqueur = "2";
            }
            System.out.println("La partie est fini");
            System.out.println("Le vainqueur est " + vainqueur);
        }
    }
}