public class Etudiant {
    
    private int id;
    private Strategie maStrategie;
    private Zone zone;
    private Joueur joueur;
    private int creditETC;
    private int force;
    private int dexterite;
    private int resistance;
    private int constitution;
    private int initiative;
    private boolean reserviste;
    private String classe;

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
