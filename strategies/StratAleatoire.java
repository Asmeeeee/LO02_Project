package strategies;

public class StratAleatoire extends AbstractStrategy{

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
