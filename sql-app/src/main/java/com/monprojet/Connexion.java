

package com.monprojet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private static final String URL = "jdbc:mysql://localhost:3306/mabase"; 
    private static final String UTILISATEUR = "root";
    private static final String MOT_DE_PASSE = "root"; 
    private static Connection connexion = null;

    
    public static Connection getConnexion() {
        if (connexion == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); 
                connexion = DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE);
                System.out.println("Connexion réussie à la base de données !");
            } catch (ClassNotFoundException e) {
                System.out.println("Driver JDBC introuvable !");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Erreur de connexion à la base de données !");
                e.printStackTrace();
            }
        }
        return connexion;
    }

   
    public static void fermerConnexion() {
        if (connexion != null) {
            try {
                connexion.close();
                connexion = null;
                System.out.println("Connexion fermée !");
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture de la connexion !");
                e.printStackTrace();
            }
        }
    }
}
