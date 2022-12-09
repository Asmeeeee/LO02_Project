public class StratDefensive extends AbstractStrategy{

    public StratDefensive(Etudiant e) {
        super(e);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void jouer() {
         this.soigner(this.getEtudiant());
    }
    
}
