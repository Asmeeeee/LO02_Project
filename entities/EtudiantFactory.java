public abstract class EtudiantFactory {

    public static Etudiant getEtudiant(){
        Etudiant e = new Etudiant();
        return e;
    }

    public static Etudiant getEtudiantElite(){
        Etudiant e = new Etudiant();
        e.setForce(1);
        e.setDexterite(1);
        e.setResistance(1);
        e.setConstitution(5);
        e.setInitiative(1);
        e.setClasse("elite");
        return e;
    }

    public static Etudiant getMaitreDuGobi(){
        Etudiant e = new Etudiant();
        e.setForce(2);
        e.setDexterite(2);
        e.setResistance(2);
        e.setConstitution(10);
        e.setInitiative(2);
        e.setClasse("maitre");
        return e;
    }
}
