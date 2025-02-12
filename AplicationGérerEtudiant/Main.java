package AplicationGérerEtudiant;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionEtudiants gestion = new GestionEtudiants();
        int choix;

        do {
            System.out.println("\n Menu Gestion Étudiants ");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Afficher la liste des étudiants");
            System.out.println("3. Supprimer un étudiant par son nom");
            System.out.println("4. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1:
                    System.out.print("Nom de l'étudiant : ");
                    String nom = scanner.nextLine();
                    System.out.print("Âge de l'étudiant : ");
                    int age = scanner.nextInt();
                    gestion.ajouterEtudiant(nom, age);
                    break;
                case 2:
                    gestion.afficherEtudiants();
                    break;
                case 3:
                    System.out.print("Nom de l'étudiant à supprimer : ");
                    String nomSupp = scanner.nextLine();
                    gestion.supprimerEtudiant(nomSupp);
                    break;
                case 4:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choix != 4);
        
        scanner.close();
    }
}

