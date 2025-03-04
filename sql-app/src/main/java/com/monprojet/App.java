package com.monprojet;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionUtilisateur gestion = new GestionUtilisateur(); 

        int choix;
        do {
            System.out.println("\n--- Gestion des utilisateurs ---");
            System.out.println("1. Ajouter un utilisateur");
            System.out.println("2. Afficher la liste des utilisateurs");
            System.out.println("3. Supprimer un utilisateur par son identifiant");
            System.out.println("4. Éditer un utilisateur par son ID");
            System.out.println("5. Rechercher un utilisateur par son nom");
            System.out.println("6. Quitter");
            System.out.print("Votre choix : ");

            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre valide !");
                scanner.next();
            }
            choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1:
                    System.out.print("Nom de l'utilisateur : ");
                    String nom = scanner.nextLine();
                    System.out.print("Email de l'utilisateur : ");
                    String email = scanner.nextLine();
                    gestion.ajouterUtilisateur(nom, email); 
                    break;

                case 2:
                    gestion.afficherUtilisateurs(); 
                    break;

                case 3:
                    System.out.print("ID de l'utilisateur à supprimer : ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Veuillez entrer un ID valide !");
                        scanner.next();
                    }
                    int idSupp = scanner.nextInt();
                    scanner.nextLine();
                    gestion.supprimerUtilisateur(idSupp);
                    break;

                case 4:
                    System.out.print("ID de l'utilisateur à éditer : ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Veuillez entrer un ID valide !");
                        scanner.next();
                    }
                    int idEdit = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nouveau nom : ");
                    String nouveauNom = scanner.nextLine();
                    System.out.print("Nouvel email : ");
                    String nouvelEmail = scanner.nextLine();
                    gestion.editerUtilisateur(idEdit, nouveauNom, nouvelEmail);
                    break;

                case 5:
                    System.out.print("Nom de l'utilisateur à rechercher : ");
                    String nomRecherche = scanner.nextLine();
                    gestion.rechercherUtilisateur(nomRecherche);
                    break;

                case 6:
                    System.out.println("Bye !");
                    break;

                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choix != 6);

        scanner.close();
    }
}
