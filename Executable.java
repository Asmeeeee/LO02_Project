public class Executable{
    public static void main(String[]args){
        Etudiant e1 = EtudiantFactory.getEtudiant();
        Etudiant e2 = EtudiantFactory.getEtudiantElite();
        Etudiant e3 = EtudiantFactory.getMaitreDuGobi();
        // System.out.println(e1.getClasse() + " "+e1.getForce());
        // System.out.println(e2.getClasse() + " "+e2.getForce());
        // System.out.println(e3.getClasse() + " "+e3.getForce());
        for(int i = 0; i < 20; i++){
            System.out.println(Math.round( Math.random() ));
        }

    }
}