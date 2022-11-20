import java.util.Comparator;

public class ComparatorEtc implements Comparator<Etudiant>{

    @Override
    public int compare(Etudiant o1, Etudiant o2) {
        // TODO Auto-generated method stub
        return Integer.compare(o1.getCreditETC(), o2.getCreditETC());
    }



}
