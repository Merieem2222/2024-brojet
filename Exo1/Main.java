package Exo1;

import java.util.Scanner; 
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 

      
        Voiture voiture = new Voiture();

    
        System.out.print("Entrez la couleur de la voiture : ");
        voiture.couleur = scanner.nextLine();

        
        voiture.marque = "Toyota";
        voiture.modele = "Corolla";

       
        System.out.println("Voiture créée : " + voiture.marque + " " + voiture.modele + " de couleur " + voiture.couleur);
        voiture.demarrer();

     
        scanner.close();
    }
}
