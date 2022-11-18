public abstract class AbstractStrategy<Etudiant>{

    private Etudiant etudiant;

    public AbstractStrategy(Etudiant e){
        this.etudiant = e;
    }

    public Etudiant getEtudiant(){
        return this.etudiant;
    }

    public abstract void jouer();

    public void attaquer(){
        //TODO
    }

    public void soigner(){
        //joueur a soigner
    }
}
