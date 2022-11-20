import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Zone implements Comparable{

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
        ComparatorEtc comparatorEtc = new ComparatorEtc();
        List<Etudiant> l1 = this.etudiantList;
        l1.sort(comparatorEtc);
        return l1.get(0);
    }

    public void jouerLaZone(int i){
        //trier la liste d etudiant par initiative
        ComparatorInitiative comparatorInitiative = new ComparatorInitiative();
        this.etudiantList.sort(comparatorInitiative);
        this.etudiantList.get(i).jouer();
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Zone){
            Zone z = (Zone) o;
            return Integer.compare(this.getEtudiants().size(), z.getEtudiants().size());
        }
        return 0;
    }
}