public class ComparatorEtc implements Comparable<AbstractStrategy>{


    @Override
    public int compareTo(AbstractStrategy o) {
        return Integer.compare(1, o.getEtudiant().getCreditETC());
    }
    
}
