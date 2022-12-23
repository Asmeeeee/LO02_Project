package model.entities;

import java.util.List;
import java.util.Scanner;

import model.strategies.AbstractStrategy;
import model.strategies.StratOffensive;
import model.tools.Message;

public class Etudiant {
    
    private int id;
    private AbstractStrategy maStrategie = new StratOffensive(this);
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
    private String classe = "basique";

    public Etudiant(Joueur j){
        this.joueur = j;
        j.getMonEquipe().add(this);
    }

    public AbstractStrategy getStrategie(){
        return this.maStrategie;
    }

    public void setStrategie(AbstractStrategy aStrategy){
        this.maStrategie = aStrategy;
    }

    public boolean estVivant(){
        return this.estVivant;
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
        if(this.zone != null){
        	this.zone.retirerEtudiant(this);
        }
        this.zone = z;
        this.zone.ajouterEtudiant(this);
    }

    public void afficherTerminal() {
        String var = this.reserviste?"oui":"non";
        System.out.println("|classe: "+this.classe+" |(1)force: "+this.force+" |(2)dextérité: "+ this.dexterite+" |(3)resistance " + 
        this.resistance+ " |(4)constitution: "+this.constitution+ " |(5)initiative: "+ this.initiative+ " |(6)réserviste: " + var + "|");
    }

    public String afficherTerminal2() {
        String var = this.reserviste?"oui":"non";
        return "|classe: "+this.classe+" |force: "+this.force+" |dextérité: "+ this.dexterite+" |resistance " + 
        this.resistance+ " |constitution: "+this.constitution+ " |initiative: "+ this.initiative+ " |réserviste: " + var + "|"+this.toString()+"|\n";
    }

    public void menuCaracteristique(){
        int p;
        boolean pointDepense = false;
        String c = "test";
        Scanner myObj = new Scanner(System.in);  
        System.out.println( Message.liner2()+" "+this.getJoueur().getPoints()+" points à dépenser");
        this.afficherTerminal();
        while(!c.isBlank()){
            pointDepense = false;
            System.out.print("Choississez une caractéristique:\n");
            c = myObj.nextLine();// Read user inputy
            if(!c.isBlank()){
                try {
                    int c2 = Integer.parseInt(c);
                    if(c2>0 && c2 < 6){
                        if(c2 != 6){
                            System.out.print("Combien de points souhaitez-vous dépenser?\n");
                            try {
                                p = Integer.parseInt(myObj.nextLine());
                                this.setCaracteristique(c, p);
                                pointDepense = true;
                            } catch (Exception e) {
                                Message.IncorrectInput();
                            }
                        }
                        else{
                            this.setCaracteristique(c,0);
                        }
                    }
                    else{
                        Message.IncorrectInput();
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    Message.IncorrectInput();
                }
                if(pointDepense){
                    System.out.println("Votre solde est désormais de "+this.getJoueur().getPoints() + " points");
                }
                this.afficherTerminal();
            }
        }
        this.deplacer(Partie.lesZones);
        Message.liner();
    }

    public void deplacer(List<Zone> lesZones){
        Scanner myObj = new Scanner(System.in);
        Message.mapPresentation(lesZones);
        System.out.println("Choississez une zone");
        String reponse = myObj.nextLine();
        if(!reponse.isBlank()){
            try {
                int i = Integer.parseInt(reponse);
                if(i>0 && i<=lesZones.size()){
                    if(this.zone!=null){
                        this.zone.getEtudiants().remove(this);
                    }
                    this.zone = lesZones.get(i-1);
                    this.zone.getEtudiants().add(this);
                    System.out.println("L'étudiant est dorénavent à la zone "+ this.zone.getNomZone());
                }
                else{
                    Message.IncorrectInput();
                    this.deplacer(lesZones);
                }
            } catch (Exception e) {
                Message.IncorrectInput();
                this.deplacer(lesZones);
            }
        }
        else{
            System.out.println("Veuillez choisir une zone.");
            this.deplacer(lesZones);
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
                if(this.force + p > 10){
                    p = 10 - this.force;
                    this.force = 10;
                }
                else{
                    this.force += p;
                }
                done = true;
                break;
    
                case "2":
                if(this.dexterite + p > 10){
                    p = 10 - this.dexterite;
                    this.dexterite = 10;
                }
                else{
                    this.dexterite += p;
                }
                done = true;
                break;
    
                case "3":
                if(this.resistance + p > 10){
                    p = 10 - this.resistance;
                    this.resistance = 10;
                }
                else{
                    this.resistance += p;
                }
                done = true;
                break;
    
                case "4":
                if(this.constitution + p > 30){
                    p = 30 - this.constitution;
                    this.constitution = 30;
                }
                else{
                    this.constitution += p;
                }
                done = true;
                break;
    
                case "5":
                if(this.initiative + p > 10){
                    p = 10 - this.initiative;
                    this.initiative = 10;
                }
                else{
                    this.initiative += p;
                }
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
