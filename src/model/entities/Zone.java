package model.entities;

import java.util.ArrayList;
import java.util.List;

import model.tools.ComparatorEtc;
import model.tools.ComparatorInitiative;

public class Zone implements Comparable{

    private String nomZone;
    private List<Etudiant> etudiantList;
    private Joueur joueur = null;

    public Zone(String nom){
        this.nomZone = nom;
        this.etudiantList = new ArrayList();
    }

    public Joueur getJoueur(){
        return this.joueur;
    }

    public int getNombreETC(){
        int res = 0;
        for(Etudiant e : etudiantList){
            if(e.estVivant()){
                res += e.getCreditETC();
            }
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

    public Etudiant getEtudiantMoinsDeVieAllie(Etudiant soigneur){
        ComparatorEtc comparatorEtc = new ComparatorEtc();
        List<Etudiant> l1 = this.etudiantList;
        l1.stream().filter(e -> e.getJoueur()==soigneur.getJoueur()).toList();
        //On retire le soigneur de la liste pour empecher le cas ou le soigneur se soigne soi-même
        l1.remove(soigneur);
        l1.sort(comparatorEtc);
        if(l1.size()>=1){
            return l1.get(0);
        }
        return null;
    }

    public Etudiant getEtudiantMoinsDeVieEnnemie(Etudiant attaquant){
        ComparatorEtc comparatorEtc = new ComparatorEtc();
        List<Etudiant> l1 = this.etudiantList;
        l1.stream().filter(e -> e.getJoueur()!=attaquant.getJoueur()).toList();
        l1.sort(comparatorEtc);
        if(l1.size()>=1){
            return l1.get(0);
        }
        return null;
    }

    public void jouerLaZone(int i){
        //trier la liste d etudiant par initiative
        ComparatorInitiative comparatorInitiative = new ComparatorInitiative();
        this.etudiantList.sort(comparatorInitiative);

        //L'étudiant à l'index i joue
        Etudiant etu = this.etudiantList.get(i);
        etu.jouer();

        //Le joueur qui possede l'étudiant qui joue
        Joueur j = etu.getJoueur();
        //Si il n'y a plus d'ennemie
        if(this.verifierJoueurEnnemie(j)){
            this.joueur = j;
            this.joueur.getMesZones().add(this);
        }
    }

    //TODO reparer la methode, la faire avec la boucle while. Il y a un probleme index out of range dans un cas exeptionnelle. source inconnue
    public boolean verifierJoueurEnnemie(Joueur j){
        boolean res = true;
        //int i = 0;
        //System.out.println(this.getEtudiants().size() - 1);
        // while(res || i <= this.getEtudiants().size() - 1 ){
        //     System.out.println(i);
        //     if(this.getEtudiants().get(i).getJoueur() != j){
        //         res = false;
        //     }
        //     i++;
        // }
        for(Etudiant e : this.getEtudiants()){
            if(e.getJoueur() != j){
                res = false;
            }
        }
        return res;
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