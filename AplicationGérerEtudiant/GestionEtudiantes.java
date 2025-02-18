package AplicationGérerEtudiant;
import java.util.ArrayList;
import java.util.Iterator;
class GestionEtudiants {
    private ArrayList<Etudiant> listeEtudiants = new ArrayList<>();

    public void ajouterEtudiant(String nom, int age) {
        listeEtudiants.add(new Etudiant(nom, age));
        System.out.println("Etudiant ajoute avec succes ");
    }

    public void afficherEtudiants() {
        if (listeEtudiants.isEmpty()) {
            System.out.println("Aucun etudiant dans la liste");
        } else {
            System.out.println("Liste des etudiants :");
            for (Etudiant e : listeEtudiants) {
                System.out.println(e);
            }
        }
    }

    public void supprimerEtudiant(String nom) {
        Iterator<Etudiant> it = listeEtudiants.iterator();
        boolean found = false;
        while (it.hasNext()) {
            if (it.next().getNom().equalsIgnoreCase(nom)) {
                it.remove();
                found = true;
                System.out.println("Etudiant supprime avec succets ");
                break;
            }
        }
        if (!found) {
            System.out.println("Aucun etudiant trouve avec ce nom");
        }
    }
}
