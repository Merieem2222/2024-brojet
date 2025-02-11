package Exo1;

import java.util.Scanner; // Importation de Scanner pour lire l'entrée utilisateur

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Création d'un objet Scanner

        // Création d'un objet Voiture
        Voiture voiture = new Voiture();

        // Demande à l'utilisateur d'entrer la couleur
        System.out.print("Entrez la couleur de la voiture : ");
        voiture.couleur = scanner.nextLine(); // Lecture de l'entrée utilisateur

        // Définition des autres attributs
        voiture.marque = "Toyota";
        voiture.modele = "Corolla";

        // Affichage des informations et démarrage
        System.out.println("Voiture créée : " + voiture.marque + " " + voiture.modele + " de couleur " + voiture.couleur);
        voiture.demarrer();

        // Fermeture du scanner (bonne pratique)
        scanner.close();
    }
}
