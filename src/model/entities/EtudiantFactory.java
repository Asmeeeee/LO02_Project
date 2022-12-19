package model.entities;

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

    public static Etudiant getEtudiant(Joueur j){
        Etudiant e = new Etudiant(j);
        return e;
    }

    public static Etudiant getEtudiantMaxSpec(Joueur j){
        Etudiant e = new Etudiant(j);
        e.setForce(10);
        e.setDexterite(10);
        e.setResistance(10);
        e.setConstitution(30);
        e.setInitiative(10);
        return e;
    }

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
