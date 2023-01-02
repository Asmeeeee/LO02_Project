package model.tools;

import java.util.List;

import model.entities.Zone;

/**
 * Class stockant differentes lignes textuelles récurrentes
 * @author jerem
 *
 */
public abstract class Message{
    
    public static void IncorrectInput(){
        System.out.println("Entré incorrecte");
    }

    public static void notEnoughCredit(){
        System.out.println("Pas assez de crédits");
    }

    public static void noMoreCredit(){
        System.out.println("Vous n'avez plus de crédit");
    }

    public static void mapPresentation(List<Zone> lesZones){
        String chaine = "";
        int i = 1;
        for(Zone z : lesZones){
            chaine += "("+i+")"+z.getNomZone()+" " ;
            i++;
        }
        System.out.println("\n" + chaine);
    }

    public static void liner(){
        System.out.println("----------------------------");
    }

    public static String tag(){
        return "################";
    }

    public static String liner2() {
        return "----------------------------";
    }

    public static void strategies() {
        System.out.println("(1)Offensive (2)Défensive (3)Aléatoire");
    }
}