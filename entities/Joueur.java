import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Joueur {
    
    private int id;
    private String monProgramme;
    private int points;
    private int nombreReserviste;
    private boolean estPret;
    private Partie maPartie;
    private List<Zone> mesZones;
    private List<Etudiant> monEquipe;


    public Joueur(Partie p){
        this.mesZones = new ArrayList<>();
        this.monEquipe = new ArrayList<>();
        this.points = 400;
        this.id = 1;
        this.maPartie = p;
    }

    public int getNombreReserviste(){
        return this.nombreReserviste;
    }

    public void managerReserviste(Etudiant e){
        if(e.getReserviste()){
            e.setReserviste(false);
        }
        else{
            if(this.nombreReserviste < 5){
                e.setReserviste(true);
                this.nombreReserviste ++;
            }
            else{
                System.out.println("PAS POSSIBLE, TROP DE RESERVISTE");
            }
        }
    }


    public void setPret(){
        this.estPret = true;
    }

    public Partie getPartie(){
        return this.maPartie;
    }

    public int getPoints(){
        return this.points;
    }

    public void setPoints(int points){
        this.points = points;
    }

    public void deployerEtudiant(List<Etudiant> le, Zone z){
        for(Etudiant e : le){
            this.deployerEtudiant(e, z);
        }
    }

    public void augmenterCaracteristique(Etudiant e, String attribut){
        //TODO
    }

    public void deployerEtudiant(Etudiant e, Zone z){
        e.deployer(z);
    }

    public void reassignerTousEtudiant(Zone z1, Zone z2){
        List<Etudiant> l1 = z1.getEtudiants();
        for(Etudiant e : l1){
            e.deployer(z2);
        }
    }

    public List<Etudiant> getMonEquipe(){
        return this.monEquipe;
    }
}
