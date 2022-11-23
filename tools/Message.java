import java.util.List;

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
}