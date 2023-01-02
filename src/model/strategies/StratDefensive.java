package model.strategies;

import model.entities.Etudiant;

public class StratDefensive extends AbstractStrategy{

    public StratDefensive(Etudiant e) {
        super(e);
        //TODO Auto-generated constructor stub
    }

    /**
     * joue la mthode soigner
     */
    @Override
    public void jouer() {
         this.soigner();
    }
    
}
