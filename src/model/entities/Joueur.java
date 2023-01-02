package model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.strategies.StratAleatoire;
import model.strategies.StratDefensive;
import model.strategies.StratOffensive;
import model.tools.Message;

/**
 * Class Joueur
 * @author jerem
 *
 */
public class Joueur {
    
    private int id;
    private String monProgramme;
    private int points;
    private int nombreReserviste;
    private Partie maPartie;
    private List<Zone> mesZones;
    private List<Etudiant> monEquipe;


    public Joueur(Partie p, int id){
        this.mesZones = new ArrayList<>();
        this.monEquipe = new ArrayList<>();
        this.points = 400;
        this.id = id;
        this.maPartie = p;
    }

    public int getId(){
        return this.id;
    }

    public List<Zone> getMesZones(){
        return this.mesZones;
    }

    public int getNombreReserviste(){
        return this.nombreReserviste;
    }

    /**
     * Autorise ou non d'inverser le boolean reserviste d un etudiant
     * @param e
     */
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


    public Partie getPartie(){
        return this.maPartie;
    }

    public int getPoints(){
        return this.points;
    }

    public void setPoints(int points){
        this.points = points;
    }

    /**
     * Declenche la methode deployerEtudiant de tous les etudiants du joueur
     * @param le
     * @param z
     */
    public void deployerEtudiant(List<Etudiant> le, Zone z){
        for(Etudiant e : le){
            this.deployerEtudiant(e, z);
        }
    }

    /**
     * declenche la methode deployer 
     * @param e
     * @param z
     */
    public void deployerEtudiant(Etudiant e, Zone z){
        e.deployer(z);
    }

    /**
     * deplace tous le etudiants d'une zone vers une autre
     * @param z1
     * @param z2
     */
    public void reassignerTousEtudiant(Zone z1, Zone z2){
        List<Etudiant> l1 = z1.getEtudiants();
        for(Etudiant e : l1){
            e.deployer(z2);
        }
    }

    public List<Etudiant> getMonEquipe(){
        return this.monEquipe;
    }

    /**
     * Affichage visuel sous forme de string de tout les etudiant de la liste mise en parametre
     * @param reservistes
     */
    public void afficherEtudiants(List<Etudiant> reservistes){
        String chaine = "";
        int i = 1;
        for(Etudiant e : reservistes){
            chaine += "(" + i + ")"+e.afficherTerminal2();
            i++;
        }
        System.out.println(chaine);
    }
    
    /**
     * retourne tous les reserviste du joueur
     * @return
     */
    public List<Etudiant> reserviste() {
    	return new ArrayList<>(this.getMonEquipe().stream().filter(t -> t.getReserviste()).toList());
    }

    /**
     * interface dans le terminal pour gerer les reservistes
     */
    public void menuReserviste() {
        Scanner myObj = new Scanner(System.in);
        boolean fini = false;
        int cpt = 0;
        List<Etudiant> reservistes = new ArrayList<>(this.getMonEquipe().stream().filter(t -> t.getReserviste()).toList());
        while(!fini && !reservistes.isEmpty()){
            this.afficherEtudiants(reservistes);
            System.out.println("Veuillez choisir un réserviste");
            String reponse = myObj.nextLine();
            if(reponse.isBlank()){
                System.out.println("Avez-vous fini d'avoir choisi les réserviste y/n");
                String reponse2 = myObj.nextLine();
                if(reponse2.equals("y")){
                    if(cpt <= 0){
                        System.out.println("veuillez déployer au moin un réserviste");
                    }
                    else{
                        fini = true;
                    }
                }
            }
            else{
                try {
                    Etudiant etudiant = reservistes.get(Integer.parseInt(reponse)-1);
                    System.out.print(etudiant.toString());
                    reservistes.remove(etudiant);
                    etudiant.setReserviste(false);
                    List<Zone> zoneNonControle = new ArrayList<>(Partie.lesZones.stream().filter(z->z.getJoueur()==null).toList());
                    etudiant.deplacer(zoneNonControle);
                    cpt++;
                } catch (Exception e) {
                    System.out.println(e);
                    Message.IncorrectInput();
                }
            }
        }
    }
    
    public List<Etudiant> getReserviste(){
    	return new ArrayList<>(this.getMonEquipe().stream().filter(t -> t.getReserviste()).toList());
    }
    
    /**
     * retourne les etudiant a redeployer sous certaine condition, vivant et au moins dans la zone 
     * @return
     */
    public List<Etudiant> etuARedeployer(){
    	List<Etudiant> etu = new ArrayList<>();
    	for(Zone z : this.mesZones) {
    		if(z.getEtudiants().size() > 1) {
    			for(Etudiant e : z.getEtudiants()) {
    				if(e.estVivant()) {
    					etu.add(e);
    				}
    			}
    		}
    	}
    	return etu;
    }
   
    /**
     * Interface terminal pour redeployer toute une troue d'une zone controle
     */
    public void redeployerTroupeDUneZoneControlee() {
        Scanner myObj = new Scanner(System.in);
        boolean fini = false;
        for(Zone z : this.mesZones){
            System.out.println("Pour la Zone " + z.getNomZone());
            List<Etudiant> listEtu = z.getEtudiants();
            while(!fini && listEtu.size() > 1){
                this.afficherEtudiants(listEtu);
                System.out.println("Veuillez choisir un étudiant à redeployer (Vous devez laisser un étudiant afin de garantir le controle)");
                String reponse = myObj.nextLine();
                if(reponse.isBlank()){
                    System.out.println("Avez-vous fini de redeployer vos troupe? y/n");
                    String reponse2 = myObj.nextLine();
                    if(reponse2.equals("y")){
                        fini = true;
                    }
                }
                else{
                    try {
                        int i = Integer.parseInt(reponse);
                        if(i > 0 && i <= listEtu.size()){
                            Etudiant etu = listEtu.get(i-1);
                            List<Zone> zonesRedeploiment = new ArrayList<>(Partie.lesZones.stream().filter(t -> t != etu.getZone()).toList());
                            etu.deplacer(zonesRedeploiment);
                            listEtu.remove(etu);
                            this.menuChangerStrategie(etu);
                        }
                    } catch (Exception e) {
                        Message.IncorrectInput();
                    }
                }
            }
        }
    }

    /**
     * interface terminal pour changer la strategie d un etudiant
     * @param etu
     */
    private void menuChangerStrategie(Etudiant etu) {
        Scanner myObj = new Scanner(System.in);
        Message.strategies();
        System.out.println("Quelle stratégie souhaitez-vous appliquer?");
        String chaine = "";
        String reponse = myObj.nextLine();
        try {
            int var = Integer.parseInt(reponse);
            switch (var) {
                case 1:
                    etu.setStrategie(new StratOffensive(etu));
                    chaine = "offensive";
                    break;
                case 2:
                    etu.setStrategie(new StratDefensive(etu));
                    chaine = "défensive";
                    break;

                case 3:
                    etu.setStrategie(new StratAleatoire(etu));
                    chaine = "aléatoire";
                    break;

                default:
                    this.menuChangerStrategie(etu);
                    break;
        }
        System.out.println("L'étudiant a maintenant une stratégie " + chaine);
        } catch (Exception e) {
            // TODO: handle exception
            this.menuChangerStrategie(etu);
        }
        
    }
}
