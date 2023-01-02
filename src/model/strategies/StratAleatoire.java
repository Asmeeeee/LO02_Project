package model.strategies;

import model.entities.Etudiant;

public class StratAleatoire extends AbstractStrategy{

    public StratAleatoire(Etudiant e) {
        super(e);
        //TODO Auto-generated constructor stub
    }

    /**
     * joue de facon aleatoire soit la methode attaquer soit soigner
     */
    @Override
    public void jouer() {
        if(Math.round( Math.random()) == 1){
            this.attaquer();
        }
        else{
            this.soigner();
        } 
    }
    
}
