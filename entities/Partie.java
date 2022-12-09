import java.io.IOError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Partie {

    private int round;
    private List<Joueur> lesJoueurs;
    static List<Zone> lesZones;

    public List<Zone> getLesZones(){
        return this.lesZones;
    }

    public List<Joueur> getLesJoueurs(){
        return this.lesJoueurs;
    }

    public Partie(){
        this.lesJoueurs = new ArrayList<>();
        this.lesZones = new ArrayList<>();
    }

    public void setJeux(){
        System.out.println("Création des joueurs");
        Joueur j1 = new Joueur(this, 1);
        Joueur j2 = new Joueur(this, 2);
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
        //Pour chaque joueur
        for(Joueur j : lesJoueurs){
            System.out.println(Message.tag() +" JOUEUR " + j.getId() + " "+ Message.tag()+ "  Vos crédit ETC: "+ j.getPoints());
            EtudiantFactory.createEtudiant(j); // Création des etudiants(15etu, 2 elite, 1 maitre)
            int y = 1;
            for(Etudiant e : j.getMonEquipe()){
                if(j.getPoints() > 0){
                    System.out.print(y+"/"+j.getMonEquipe().size()+" etudiant a configurer\n");
                    e.menuCaracteristique();
                    y++;
                }
                else{
                    Message.noMoreCredit();
                }
            }
        }
        System.out.println(Message.tag() +" FIN DE LA CONFIGURATION " +Message.tag());
    }

    public void demarrerMelee() {
        System.out.println(Message.tag() + " DEBUT DE LA MELEE "+ Message.tag());
        boolean enCours = true;
        int iZone = 0;
        int iEtudiant = 0;
        int round = 1;
        int indexZoneControle = 0;
        while(enCours){
            System.out.println(Message.liner2() + " ROUND "+ round+ Message.liner2());
            if(this.getLesZones().get(iZone).getJoueur() == null){ //si la zone n est pas controlée
                if(iEtudiant <= this.getLesZones().get(iZone).getEtudiants().size()-1){ // l index de l etudiant est bien compris dans la taille de la liste de la zone que nous parcourons
                    if(this.getLesZones().get(iZone).getEtudiants().get(iEtudiant).estVivant()){ // l etudiant est bien vivant
                        this.getLesZones().get(iZone).jouerLaZone(iEtudiant);
                        if( this.getLesZones().get(iZone).getJoueur() != null ){ // Si la zone est controlée 
                            indexZoneControle = iZone; 
                            enCours = false;
                        }
                    }
                }
            } 
            if(iZone % 4 == 0 && iZone != 0){
                iZone = 0;
                iEtudiant ++;
            }
            else{
                iZone ++;
            }
            round++;
        }
        Zone zoneControlee = this.getLesZones().get(indexZoneControle);
        System.out.println("La Zone \""+ zoneControlee.getNomZone() +"\" a été controlé par le Joueur " + zoneControlee.getJoueur().getId());
        System.out.println(Message.tag() +" FIN DE LA MELEE "+Message.tag());
    }

    public void demarrerTreve() {
        System.out.println(Message.tag() + " DEBUT DE LA TREVE "+ Message.tag());
        Scanner myObj = new Scanner(System.in);   
        for(Joueur j : lesJoueurs){
            System.out.println(Message.tag() +" JOUEUR " + j.getId() + " "+ Message.tag());
            j.menuReserviste();
            //TODO Redployer soldat d'une zone controlé
            j.redeployerTroupeDUneZoneControlee();
            this.afficherCreditETCParZone();
        }
        System.out.println(Message.tag() +" FIN DE LA TREVE "+Message.tag());
    }

    private void afficherCreditETCParZone() {
        Scanner myObj = new Scanner(System.in);
        for(Zone z : Partie.lesZones){
            System.out.println(z.getNomZone()+": "+ z.getNombreETC()+" crédit ETC ");
        }
        myObj.nextLine();
    }

}
