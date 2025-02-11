
package exo1;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String choice;

        System.out.println("Selectionner la couleur de la voiture :");
        System.out.println("1.Rouge");
        System.out.println("2.Vert");
        System.out.println("3.Orange");
        System.out.println("4.Bleu");

         System.out.println("Entrez voitre choix :");

         choice = sc.nextLine();
       
       System.out.println("votre voiture est :" + choice );

    }
}