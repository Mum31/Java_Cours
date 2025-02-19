package com.monprojet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Informations de connexion
        String url = "jdbc:mysql://localhost:3306/mabase"; // Remplacer "mabase" par le nom de votre base
        String utilisateur = "root";
        String motDePasse = "";
        
        System.out.println("Hello World!");

        // Utilisation de try-with-resources pour gérer automatiquement les ressources
        try (Connection conn = DriverManager.getConnection(url, utilisateur, motDePasse);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, nom, email FROM utilisateurs")) {
                 
            System.out.println("Liste des utilisateurs :");

            // Parcourir les résultats
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String email = rs.getString("email");
                System.out.println("ID: " + id + ","+ " NOM: " + nom + "," + " EMAIL: " + email);
            }

        } catch (SQLException e) {
            // Gestion des erreurs de connexion et d'exécution
            System.out.println("Erreur de connexion ou d'exécution de la requête : " + e.getMessage());
        }
    }
}