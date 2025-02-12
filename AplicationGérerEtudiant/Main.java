package AplicationGérerEtudiant;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       
       
       
       
        Scanner scanner = new Scanner(System.in);
        GestionEtudiants gestion = new GestionEtudiants();
        int choix;

        do {
            System.out.println("Menu Gestion etudiants ");
            System.out.println("1. Ajouter un etudiant");
            System.out.println("2. Afficher la liste des etudiants");
            System.out.println("3. Supprimer un etudiant par son nom");
            System.out.println("4. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1:
                    System.out.print("Nom de l'etudiant : ");
                    String nom = scanner.nextLine();
                    System.out.print("Age de l'etudiant : ");
                    int age = scanner.nextInt();
                    gestion.ajouterEtudiant(nom, age);
                    break;
                case 2:
                    gestion.afficherEtudiants();
                    break;
                case 3:
                    System.out.print("Nom de l'etudiant à supprimer : ");
                    String nomSupp = scanner.nextLine();
                    gestion.supprimerEtudiant(nomSupp);
                    break;
                case 4:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Choix invalide veuillez réessayer");
            }
        } while (choix != 4);
        
        scanner.close();
    }
}

