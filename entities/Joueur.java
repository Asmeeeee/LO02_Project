import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Joueur {
    
    private int id;
    private String monProgramme;
    private int points;
    private int nombreReserviste;
    private boolean estPret;
    private Partie maPartie;
    private List<Zone> mesZones;
    private List<Etudiant> monEquipe;


    public Joueur(Partie p, int id){
        this.mesZones = new ArrayList<>();
        this.monEquipe = new ArrayList<>();
        this.points = 400;
        this.id = id;
        this.maPartie = p;
    }

    public int getId(){
        return this.id;
    }

    public int getNombreReserviste(){
        return this.nombreReserviste;
    }

    public void managerReserviste(Etudiant e){
        if(e.getReserviste()){
            e.setReserviste(false);
        }
        else{
            if(this.nombreReserviste < 5){
                e.setReserviste(true);
                this.nombreReserviste ++;
            }
            else{
                System.out.println("PAS POSSIBLE, TROP DE RESERVISTE");
            }
        }
    }


    public void setPret(){
        this.estPret = true;
    }

    public Partie getPartie(){
        return this.maPartie;
    }

    public int getPoints(){
        return this.points;
    }

    public void setPoints(int points){
        this.points = points;
    }

    public void deployerEtudiant(List<Etudiant> le, Zone z){
        for(Etudiant e : le){
            this.deployerEtudiant(e, z);
        }
    }

    public void augmenterCaracteristique(Etudiant e, String attribut){
        //TODO
    }

    public void deployerEtudiant(Etudiant e, Zone z){
        e.deployer(z);
    }

    public void reassignerTousEtudiant(Zone z1, Zone z2){
        List<Etudiant> l1 = z1.getEtudiants();
        for(Etudiant e : l1){
            e.deployer(z2);
        }
    }

    public List<Etudiant> getMonEquipe(){
        return this.monEquipe;
    }

    public void afficherReservistes(List<Etudiant> reservistes){
        String chaine = "";
        int i = 1;
        for(Etudiant e : reservistes){
            chaine += i + " "+e.toString()+" ";
            i++;
        }
        System.out.println(chaine);
    }

    public void menuReserviste() {
        Scanner myObj = new Scanner(System.in);
        boolean fini = false;
        List<Etudiant> reservistes = new ArrayList<>(this.getMonEquipe().stream().filter(t -> t.getReserviste()).toList());
        while(!fini || !reservistes.isEmpty()){
            this.afficherReservistes(reservistes);
            System.out.println("Veuillez choisir un réserviste");
            String reponse = myObj.nextLine();
            if(reponse.isBlank()){
                System.out.println("Avez-vous fini d'avoir choisi les réserviste y/n");
                String reponse2 = myObj.nextLine();
                System.out.println(reponse2);
                if(reponse2.equals("y")){
                    fini = true;
                }
                System.out.println(fini);
            }
            else{
                try {
                    Etudiant etudiant = reservistes.get(Integer.parseInt(reponse)-1);
                    System.out.print(etudiant.toString());
                    reservistes.remove(etudiant);
                    etudiant.deplacer();
                } catch (Exception e) {
                    System.out.println(e);
                    Message.IncorrectInput();
                }
            }
        }
    }
}
