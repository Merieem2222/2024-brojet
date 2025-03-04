package com.monprojet;

import java.sql.*;
import java.util.ArrayList;

public class GestionUtilisateur {
    private Connection connexion;

    public GestionUtilisateur() {
        this.connexion = Connexion.getConnexion();
    }

    public void ajouterUtilisateur(String nom, String email) {
        String sql = "INSERT INTO utilisateurs (nom, email) VALUES (?, ?)";

        try (PreparedStatement stmt = connexion.prepareStatement(sql)) {
            stmt.setString(1, nom);
            stmt.setString(2, email);
            stmt.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur !");
            e.printStackTrace();
        }
    }

    public void afficherUtilisateurs() {
        String sql = "SELECT id, nom, email FROM utilisateurs";
        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();

        try (Statement stmt = connexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String email = rs.getString("email");

                Utilisateur user = new Utilisateur(id, nom, email);
                utilisateurs.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des utilisateurs !");
            e.printStackTrace();
        }

        System.out.println("\n--- Liste des Utilisateurs ---");
        if (utilisateurs.isEmpty()) {
            System.out.println("Aucun utilisateur trouvé.");
        } else {
            for (Utilisateur u : utilisateurs) {
                System.out.println("ID: " + u.getId() + " | Nom: " + u.getNom() + " | Email: " + u.getEmail());
            }
        }
    }

    public void supprimerUtilisateur(int id) {
        String sql = "DELETE FROM utilisateurs WHERE id = ?";

        try (PreparedStatement stmt = connexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Utilisateur supprimé avec succès !");
            } else {
                System.out.println("Aucun utilisateur trouvé avec cet ID.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de l'utilisateur !");
            e.printStackTrace();
        }
    }

    public void editerUtilisateur(int id, String nouveauNom, String nouvelEmail) {
        String sql = "UPDATE utilisateurs SET nom = ?, email = ? WHERE id = ?";

        try (PreparedStatement stmt = connexion.prepareStatement(sql)) {
            stmt.setString(1, nouveauNom);
            stmt.setString(2, nouvelEmail);
            stmt.setInt(3, id);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Utilisateur mis à jour avec succès !");
            } else {
                System.out.println("Aucun utilisateur trouvé avec cet ID.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour de l'utilisateur !");
            e.printStackTrace();
        }
    }

    public void rechercherUtilisateur(String nomRecherche) {
        String sql = "SELECT id, nom, email FROM utilisateurs WHERE nom LIKE ?";

        try (PreparedStatement stmt = connexion.prepareStatement(sql)) {
            stmt.setString(1, "%" + nomRecherche + "%");
            ResultSet rs = stmt.executeQuery();

            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println("ID: " + rs.getInt("id") + " | Nom: " + rs.getString("nom") + " | Email: " + rs.getString("email"));
            }

            if (!found) {
                System.out.println("Aucun utilisateur trouvé avec ce nom.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche de l'utilisateur !");
            e.printStackTrace();
        }
    }
}
