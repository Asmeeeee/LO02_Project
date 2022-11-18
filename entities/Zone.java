import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Zone{

    private String nomZone;
    private List<Etudiant> etudiantList;
    private Joueur joueur;

    public Zone(String nom){
        this.nomZone = nom;
        this.etudiantList = new ArrayList();
    }

    public int getNombreETC(){
        int res = 0;
        for(Etudiant e : etudiantList){
            res += e.getCreditETC();
        }
        return res;
    }

    public List<Etudiant> getEtudiants(){
        return this.etudiantList;
    }

    public String getNomZone(){
        return this.nomZone;
    }

    public void retirerEtudiant(Etudiant e){
        this.etudiantList.remove(e);
    }

    public void ajouterEtudiant(Etudiant e){
        this.etudiantList.add(e);
    }

    public Etudiant getEtudiantMoinsDeVie(){
        this.etudiantList.sort(new ComparatorEtc());
        return this.etudiantList.stream().filter(etudiant -> etudiant.getCreditETC() == )
    }
}