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

    public static void mapPresentation(){
        System.out.println("\n(1)La bibliothèque (2)Le Bureau des Etudiants (3)Le Quartier Administratif (4)Les Halles industrielles (5)La Halle Sportive");
    }

    public static void liner(){
        System.out.println("----------------------------");
    }

    public static String tag(){
        return "################";
    }
}