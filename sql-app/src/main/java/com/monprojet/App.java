package com.monprojet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // Informations de connexion
        String url = "jdbc:mysql://localhost:3306/mabase"; // Remplace "mabase" par le nom de ta base
        String utilisateur = "root";
        String motDePasse = "root";

        try (Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse)) {
            System.out.println("Connexion réussie !");

            // Exécuter une requête
            String requete = "SELECT id, nom, email FROM utilisateurs";

            try (Statement stmt = connexion.createStatement();
                 ResultSet rs = stmt.executeQuery(requete)) {

                System.out.println("Liste des utilisateurs :");

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nom = rs.getString("nom");
                    String email = rs.getString("email");
                    System.out.println("ID : " + id + ", Nom : " + nom + ", Email : " + email);
                }
            } // Le Statement et ResultSet seront automatiquement fermés ici

        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        }
    }
}
