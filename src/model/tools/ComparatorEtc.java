package model.tools;

import java.util.Comparator;

import model.entities.Etudiant;

public class ComparatorEtc implements Comparator<Etudiant>{

	/**
	 * compare 2 etudiant en fonction de leur cretit ETC
	 */
    @Override
    public int compare(Etudiant o1, Etudiant o2) {
        // TODO Auto-generated method stub
        return Integer.compare(o1.getCreditETC(), o2.getCreditETC());
    }



}
