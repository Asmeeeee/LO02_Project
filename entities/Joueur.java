import java.util.List;
import java.util.Random;

public class Joueur {
    
    private int id;
    private String monProgramme;
    private int points;
    private Partie maPartie;
    private List<Zone> mesZones;
    private List<Etudiant> monEquipe;

    public Joueur(){
        this.points = 400;
        this.id = 1;
    }
}
