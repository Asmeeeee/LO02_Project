import java.util.List;

public class Zone{

    private String nomZone;
    private List<Etudiant> etudiantList;
    private Joueur joueur;

    public Zone(String nom){
        this.nomZone = nom;
    }

    public int getNombreETC(){
        return 1;
    }

    public List<Etudiant> getEtudiants(){
        return this.etudiantList;
    }

    public void retirerEtudiant(Etudiant e){
        this.etudiantList.remove(e);
    }

    public void ajouterEtudiant(Etudiant e){
        this.etudiantList.add(e);
    }
}