package MonProjet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Lancement du programme - V1");
        
        int choix = 0;
        Scanner sc = new Scanner(System.in);
        GestionEtudiant gestionEtudiant = new GestionEtudiant(); // Créer une instance de GestionEtudiant
        
        do {
            System.out.println("Que voulez-vous faire ?");
            System.out.println("1 - Ajouter un étudiant");
            System.out.println("2 - Afficher les étudiants");
            System.out.println("3 - Supprimer un étudiant");
            System.out.println("4 - Quitter");
            
            choix = sc.nextInt();
            sc.nextLine(); // Pour consommer la nouvelle ligne après nextInt()

            switch (choix) {
                case 1:
                    System.out.print("Entrez le nom de l'étudiant : ");
                    String nomAjout = sc.nextLine();
                    gestionEtudiant.ajouterEtudiant(nomAjout);
                    break;
                case 2:
                    gestionEtudiant.afficherEtudiants();
                    break;
                case 3:
                    System.out.print("Entrez le nom de l'étudiant à supprimer : ");
                    String nomSuppression = sc.nextLine();
                    gestionEtudiant.supprimerEtudiant(nomSuppression);
                    break;
                case 4:
                    System.out.println("Au revoir");
                    break;
                default:
                    System.out.println("Choix non valide. Veuillez réessayer.");
                    break;
            }
           
        } while (choix != 4);
        
        sc.close();
    } 
}