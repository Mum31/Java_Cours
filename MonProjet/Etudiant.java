package MonProjet;
import java.util.Scanner;

public class Etudiant {
    public String nom;
    public String prenom;
    public String classe;

    public Etudiant(String pnom, String pprenom, String pclasse) {
        this.nom = pnom;
        this.prenom = pprenom;
        this.classe = pclasse;

    }
    @Override
    public String toString() {
        return this.nom + " " + this.prenom + " " + this.classe;
    }
  
   
}
