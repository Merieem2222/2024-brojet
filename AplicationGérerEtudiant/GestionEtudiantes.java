package AplicationGérerEtudiant;
import java.util.ArrayList;
import java.util.Iterator;
class GestionEtudiants {
    private ArrayList<Etudiant> listeEtudiants = new ArrayList<>();

    public void ajouterEtudiant(String nom, int age) {
        listeEtudiants.add(new Etudiant(nom, age));
        System.out.println("Étudiant ajouté avec succès ");
    }

    public void afficherEtudiants() {
        if (listeEtudiants.isEmpty()) {
            System.out.println("Aucun étudiant dans la liste");
        } else {
            System.out.println("Liste des étudiants :");
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
                System.out.println("Étudiant supprimé avec succès ");
                break;
            }
        }
        if (!found) {
            System.out.println("Aucun étudiant trouvé avec ce nom");
        }
    }
}
