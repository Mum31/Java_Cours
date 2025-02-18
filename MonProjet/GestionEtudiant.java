package MonProjet;

import java.util.ArrayList;
import java.util.List;

public class GestionEtudiant {
    // Liste pour stocker les étudiants
    private List<String> etudiants;

    // Constructeur
    public GestionEtudiant() {
        etudiants = new ArrayList<>(); // Initialiser la liste
    }

    // Méthode pour ajouter un étudiant
    public void ajouterEtudiant(String nom , String prenom, String matricule, String adresse, String telephone) {
        etudiants.add(nom); // Ajouter l'étudiant à la liste
        etudiants.add(prenom);
        etudiants.add(matricule);
        System.out.println("Étudiant '" + nom + "' ajouté avec succès.");
    }
   =)
    // Méthode pour afficher tous les étudiants
    public void afficherEtudiants() {
        if (etudiants.isEmpty()) {
            System.out.println("Aucun étudiant à afficher.");
        } else {
            System.out.println("Liste des étudiants :");
            for (String etudiant : etudiants) {
                System.out.println("- " + etudiant); // Afficher chaque étudiant
            }
        }
    }

    // Méthode pour supprimer un étudiant
    public void supprimerEtudiant(String nom) {
        if (etudiants.remove(nom)) { // Essayer de supprimer l'étudiant
            System.out.println("Étudiant '" + nom + "' supprimé avec succès.");
        } else {
            System.out.println("Étudiant '" + nom + "' non trouvé.");
        }
    }
}