package model.strategies;

import java.util.Random;

import model.entities.Etudiant;

/**
 * Class abstract AbstractStrategy
 * @author jerem
 *
 */
public abstract class AbstractStrategy{

    private Etudiant etudiant;

    public AbstractStrategy(Etudiant e){
        this.etudiant = e;
        e.setStrategie(this);
    }

    public Etudiant getEtudiant(){
        return this.etudiant;
    }

    /**
     * signature de méthode forcant les classe héritant de celle-ci de défénir cette méthode jouer
     */
    public abstract void jouer();

    /**
     * méthode attaquer, pour plus d'information voir sujet
     */
    public void attaquer(){
        Random r = new Random();
        //joueur a attaquer
        Etudiant etuAttaque = this.etudiant.getZone().getEtudiantMoinsDeVieEnnemie(this.etudiant);
        //calcul si l'attaque est bien porté
        int low = 0;
        int high = 100;
        int result = r.nextInt(high-low) + low;
        if(result > 0 && result < 40+6*this.etudiant.getDexterite()){
            double min = 0.1;
            double max = 1;
            double y = r.nextDouble(max - min) - min; 
            int coefDegat = Math.max(0, Math.min(100, 10 * this.etudiant.getForce() - 5 * etuAttaque.getResistance()));
            double degatInfglige =(y * (1 + coefDegat) * 10);
            etuAttaque.setCreditETC(etuAttaque.getCreditETC() - (int) degatInfglige);
        }
        //Si l'adversaire n'a plus de creditEtc, alors il "meurt"
        if(etuAttaque.getCreditETC() <= 0){
            System.out.println("LE JOUEUR "+etuAttaque.getJoueur().getId()+" a perdu un étudiant "+etuAttaque.getClasse()+" a la zone "+etuAttaque.getZone().getNomZone());
            etuAttaque.mourir();
        }
    }

    /**
     * méthode soigner, pour plus d'information voir sujet
     * @param soigneur
     */
    public void soigner(){
        Random r = new Random();
        //joueur a soigner
        Etudiant etuSoigne = this.etudiant.getZone().getEtudiantMoinsDeVieAllie(this.etudiant);
        //calcul si le soin est réussi
        int low = 0;
        int high = 100;
        int result = r.nextInt(high-low) + low;
        if(result > 0 && result < 20+6*this.etudiant.getDexterite()){
            double min = 0.1;
            double max = 0.6;
            double y = r.nextDouble(max - min) - min; 
            double gainDeSoin = y * (10 + etuSoigne.getConstitution());
            if(gainDeSoin > 30 + etuSoigne.getConstitution()){
                gainDeSoin = 30 + etuSoigne.getConstitution();
            }
            etuSoigne.setCreditETC(etuSoigne.getCreditETC() + (int) gainDeSoin);
        }
    }
}
