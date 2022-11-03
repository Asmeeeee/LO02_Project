import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Partie {

    private int round;
    private List<Joueur> lesJoueurs;
    private List<Zone> lesZones;

    public Partie(){
        this.lesJoueurs = new ArrayList<>();
        this.lesZones = new ArrayList<>();
    }

    public void setJeux(){
        System.out.println("Création des joueurs");
        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        this.lesJoueurs = Arrays.asList(j1, j2);
        System.out.println("Création des zones");
        Zone z1 = new Zone("La bibliothèque");
        Zone z2 = new Zone("Le Bureau des Etudiants");
        Zone z3 = new Zone("Le Quartier Administratif");
        Zone z4 = new Zone("Les Halles industrielles");
        Zone z5 = new Zone("La Halle Sportive");
        this.lesZones =  Arrays.asList(z1, z2, z3, z4, z5);
    }

    public void configurationEtudiant(){
        Scanner myObj = new Scanner(System.in);   
        for(int i = 0; i <= 1; i++){
            int y = i+1;
            System.out.println("################ JOUEUR " + y + " ##############   Vos crédit ETC "+ this.lesJoueurs.get(i).getPoints());
            EtudiantFactory.createEtudiant(this.lesJoueurs.get(i)); // Création des etudiants(15etu, 2 elite, 1 maitre)
            for(Etudiant e : this.lesJoueurs.get(i).getMonEquipe()){
                System.out.println("----------------------------" + this.lesJoueurs.get(i).getPoints());
                e.afficherTerminal();
                System.out.print("Choississez une caractéristique\n");
                String reponse = myObj.nextLine();// Read user input
                e.setCaracteristique(reponse);
                e.afficherTerminal();
                System.out.println("----------------------------" + this.lesJoueurs.get(i).getPoints());
            /*     try {
                    Thread.sleep(800);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                */
            }
        }
        System.out.println("################ FIN DE LA CONFIGURATION #################");
    }
    
}
