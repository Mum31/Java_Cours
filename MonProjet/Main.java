package MonProjet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Lancement du programme - V1");
        
        int choix=4;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("que voulez vous faire ?");
            System.out.println("1 - Ajouter un etudiant");
            System.out.println("2 - Afficher les etudiants");
            System.out.println("3 - Supprimer un etudiant");
            System.out.println("4 - Quitter");
            choix = sc.nextInt();

            switch (choix) {
                case 1:
                System.out.println("Ajout d'un etudiant");
                   break;
                case 2:
                System.out.println("Affichage des etudiants");
                   break;
                case 3:
                System.out.println("Suppression d'un etudiant");
                   break;
                case 4:
                System.out.println("Au revoir");
                   break;
            default:
            System.out.println("Choix non valide");
            }
           
        } while (choix != 4);
        sc.close();

    } 
}

