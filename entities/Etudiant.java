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

    public void setReserviste(){
        this.reserviste = true;
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
        System.out.println("classe: "+this.classe+" force: "+this.force+" dextérité: "+ this.dexterite+" resistance " + 
        this.resistance+ " constitution: "+this.constitution+ " initiative: "+ this.initiative+ " réserviste: "+this.reserviste);
    }

    public void setCaracteristique(String reponse) {
        if(reponse.equals("1")){
            System.out.println("J augmente la force");
            this.force += 10;
        }
        if(reponse.equals("2"))
            this.dexterite += 10;
        if(reponse.equals("3"))
             this.resistance += 10;   
        if(reponse.equals("4"))
            this.constitution += 10;
        if(reponse.equals("5"))
            this.initiative += 10;
        System.out.println("Fin de la caractérisation");
    }
    
}
