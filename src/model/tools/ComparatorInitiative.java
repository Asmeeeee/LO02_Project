package model.tools;

import java.util.Comparator;

import model.entities.Etudiant;

public class ComparatorInitiative implements Comparator<Etudiant>{

    @Override
    public int compare(Etudiant o1, Etudiant o2) {
        // TODO Auto-generated method stub
        return Integer.compare(o1.getInitiative(), o2.getInitiative());
    }

}




