public class StratAleatoire extends AbstractStrategy{

    public StratAleatoire(Etudiant e) {
        super(e);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void jouer() {
        if(Math.round( Math.random()) == 1){
            this.attaquer();
        }
        else{
            this.soigner(this.getEtudiant());
        } 
    }
    
}
