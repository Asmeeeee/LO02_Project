package model.entities;
/**
 * Fichier permettant la crétion des Etudiants
 * @author jerem
 *
 */
public abstract class EtudiantFactory {

    public static void createEtudiant(Joueur j){
        for(int i = 0; i < 15; i++){
            getEtudiant(j);
        }
        for(int i = 0; i < 4; i++){
            getEtudiantElite(j);
        }
        getMaitreDuGobi(j);
    }

    /**
     * Constructeur retournant un étudiant basique attribué au joueur j
     * @param j
     * @return
     */
    public static Etudiant getEtudiant(Joueur j){
        Etudiant e = new Etudiant(j);
        return e;
    }

    /**
     * Constructeur retournant un étudiant maxSpec attribué au joueur j
     * @param j
     * @return
     */
    public static Etudiant getEtudiantMaxSpec(Joueur j){
        Etudiant e = new Etudiant(j);
        e.setForce(10);
        e.setDexterite(10);
        e.setResistance(10);
        e.setConstitution(30);
        e.setInitiative(10);
        return e;
    }

    /**
     * Constructeur retournant un étudiant elite attribué au joueur j
     * @param j
     * @return
     */
    public static Etudiant getEtudiantElite(Joueur j){
        Etudiant e = new Etudiant(j);
        e.setForce(1);
        e.setDexterite(1);
        e.setResistance(1);
        e.setConstitution(5);
        e.setInitiative(1);
        e.setClasse("elite");
        return e;
    }

    /**
     * Constructeur retournant un maitre du gobi attribué au joueur j
     * @param j
     * @return
     */
    public static Etudiant getMaitreDuGobi(Joueur j){
        Etudiant e = new Etudiant(j);
        e.setForce(2);
        e.setDexterite(2);
        e.setResistance(2);
        e.setConstitution(10);
        e.setInitiative(2);
        e.setClasse("maitre");
        return e;
    }
}
