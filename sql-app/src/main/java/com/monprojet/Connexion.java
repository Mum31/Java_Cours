package com.monprojet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private Connection connection;

    public Connexion(String url, String utilisateur, String motDePasse) {
        try {
            // Initialiser la connexion
            this.connection = DriverManager.getConnection(url, utilisateur, motDePasse);
            System.out.println("Connexion réussie !");
        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
}