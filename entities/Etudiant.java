import strategies.AbstractStrategy;

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
        System.out.println("classe: "+this.classe+" ,(1)force: "+this.force+" ,(2)dextérité: "+ this.dexterite+" ,(3)resistance " + 
        this.resistance+ " ,(4)constitution: "+this.constitution+ " ,(5)initiative: "+ this.initiative+ " ,(6)réserviste: "+this.reserviste);
    }

    public void setCaracteristique(String reponse) {
        int p = 10;
        if(this.joueur.getPoints() <= p){
            System.out.println("PAS ASSEZ DE CREDITS");
        }
        else{
            boolean done = false;
            switch(reponse){
                case "1": 
                this.force += 10;
                done = true;
                break;
    
                case "2":
                this.dexterite += 10;
                done = true;
                break;
    
                case "3":
                this.resistance += 10;
                done = true;
                break;
    
                case "4":
                this.constitution += 10;
                done = true;
                break;
    
                case "5":
                this.initiative += 10;
                done = true;
                break;

                case "6":
                this.joueur.managerReserviste(this);
                break;

                case "":
                break;

                default:
                System.out.println("Input non correct");
                break;
            }
            if(done){
                this.joueur.setPoints(this.joueur.getPoints() - p);
            }
            System.out.println("Fin de la caractérisation");
        }
    }
    
}
