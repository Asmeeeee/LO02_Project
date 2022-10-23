import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    
}
