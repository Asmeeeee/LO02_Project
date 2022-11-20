import java.nio.IntBuffer;
import java.util.Scanner;

public class Etudiant {
    
    private int id;
    private AbstractStrategy maStrategie;
    private Zone zone;
    private Joueur joueur;
    private int creditETC = 30;
    private int force = 0;
    private int dexterite = 0;
    private int resistance = 0;
    private int constitution = 0;
    private int initiative = 0;
    private boolean reserviste = false;
    private boolean estVivant = true;
    private String classe = "base";

    public Etudiant(Joueur j){
        this.joueur = j;
        j.getMonEquipe().add(this);
    }

    public Joueur getJoueur(){
        return this.joueur;
    }

    public void setJoueur(Joueur j){
        this.joueur = j;
    }

    public Zone getZone(){
        return this.zone;
    }

    public void setZone(Zone z){
        this.zone = z;
    }

    public int getCreditETC(){
        return this.creditETC;
    }

    public void setCreditETC(int c){
        this.creditETC = c;
    }

    public int getForce(){
        return this.force;
    }

    public void setForce(int f){
        this.force = f;
    }

    public int getDexterite(){
        return this.dexterite;
    }

    public void setDexterite(int d){
        this.dexterite = d;
    }

    public int getResistance(){
        return this.resistance;
    }

    public void setResistance(int r){
        this.resistance = r;
    }

    public int getConstitution(){
        return this.constitution;
    }

    public void setConstitution(int c){
        this.constitution = c;
    }

    public int getInitiative(){
        return this.initiative;
    }

    public void setInitiative(int i){
        this.initiative = i;
    }

    public String getClasse(){
        return this.classe;
    }

    public void setClasse(String classe){
        this.classe = classe;
    }

    public boolean getReserviste(){
        return this.reserviste;
    }

    public void setReserviste(Boolean b){
        this.reserviste = b;
    }

    public void jouer(){
        this.maStrategie.jouer();
    }
    
    public void deployer(Zone z){
        if(this.zone == null){
        }
        else{
            this.zone.retirerEtudiant(this);
            this.zone = z;
            this.zone.ajouterEtudiant(this);
        }
    }

    public void afficherTerminal() {
        String var = this.reserviste?"oui":"non";
        System.out.println("|classe: "+this.classe+" |(1)force: "+this.force+" |(2)dextérité: "+ this.dexterite+" |(3)resistance " + 
        this.resistance+ " |(4)constitution: "+this.constitution+ " |(5)initiative: "+ this.initiative+ " |(6)réserviste: " + var + "|");
    }

    public void menuCaracteristique(){
        int p;
        String c = "test";
        Scanner myObj = new Scanner(System.in);  
        Message.liner();
        this.afficherTerminal();
        while(!c.isBlank()){
            System.out.print("Choississez une caractéristique   "+ this.getJoueur().getPoints()+" points à dépenser\n");
            c = myObj.nextLine();// Read user inputy
            if(!c.isBlank()){
                if(!c.equals("6")){
                    System.out.print("Combien de points souhaitez-vous dépenser?\n");
                    try {
                        p = Integer.parseInt(myObj.nextLine());
                        this.setCaracteristique(c, p);
                    } catch (Exception e) {
                        Message.IncorrectInput();
                    }
                }
                else{
                    this.setCaracteristique(c,0);
                }
                this.afficherTerminal();
            }
        }
        this.deplacer();
        Message.liner();
    }

    public void deplacer(){
        Scanner myObj = new Scanner(System.in);
        Message.mapPresentation();
        System.out.println("Choississez une zone");
        String reponse = myObj.nextLine();
        if(!reponse.isBlank()){
            try {
                int i = Integer.parseInt(reponse);
                if(i>0 && i<6){
                    this.zone = this.joueur.getPartie().getLesZones().get(i-1);
                    System.out.println("L'étudiant est dorénavent à la zone "+ this.zone.getNomZone());
                }
                else{
                    Message.IncorrectInput();
                    this.deplacer();
                }
            } catch (Exception e) {
                Message.IncorrectInput();
                this.deplacer();
            }
        }
        else{
            System.out.println("Veuillez choisir une zone.");
            this.deplacer();
        }

    }

    public void setCaracteristique(String reponse, int p) {
        if(this.joueur.getPoints() < p){
            Message.notEnoughCredit();
        }
        else{
            boolean done = false;
            switch(reponse){
                case "1": 
                this.force += p;
                done = true;
                break;
    
                case "2":
                this.dexterite += p;
                done = true;
                break;
    
                case "3":
                this.resistance += p;
                done = true;
                break;
    
                case "4":
                this.constitution += p;
                done = true;
                break;
    
                case "5":
                this.initiative += p;
                done = true;
                break;

                case "6":
                this.joueur.managerReserviste(this);
                break;

                case "":
                break;

                default:
                Message.IncorrectInput();
                break;
            }
            if(done){
                this.joueur.setPoints(this.joueur.getPoints() - p);
            }
        }
    }

    public void mourir() {
        this.estVivant = false;
        this.zone.getEtudiants().remove(this);
    }
    
}
