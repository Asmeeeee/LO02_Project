public class Etudiant {
    
    private int id;
    private Strategie maStrategie;
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

    public void jouer(){
        this.maStrategie.jouer();
    }
    public void deployer(Zone z){
        if(this.zone == null){
        }
        else{
            this.zone.retirerEtudiant(this);
            this.zone = z;
            z.ajouterEtudiant(this);
        }
    }
}
