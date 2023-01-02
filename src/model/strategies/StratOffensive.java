package model.strategies;

import model.entities.Etudiant;

public class StratOffensive extends AbstractStrategy{

    public StratOffensive(Etudiant e) {
        super(e);
        //TODO Auto-generated constructor stub
    }

    /**
     * joue la methode attaquer
     */
    @Override
    public void jouer() {
        this.attaquer();
    }
    
}
