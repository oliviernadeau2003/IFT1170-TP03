import classe.Pays;
import classe.PaysUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

//* Auteur : Olivier Nadeau [IFT1170 Automne 2024]
public class TP03_1170_NumA {
    public static void main(String[] args) throws IOException {
        afficher();
    }

    public static void afficher() throws IOException {
        System.out.println("\n=== Numéro A ===");
        Vector<Pays> paysList = new Vector<Pays>();
        String currentDirectory = System.getProperty("user.dir");
        int nombrePays = readFilePays(currentDirectory + "/src/data/pays_a24.txt", paysList);

        System.out.println("\nAffichage des 15 premiers pays :");
        PaysUtils.afficher(paysList, 0, 15);

        System.out.println("\nModifier le continent de la Russie pour l'Europe :");
        Pays paysTemp = PaysUtils.retrievePays(paysList, "Russie");
        System.out.printf("Avant : %s\n", paysTemp);
        paysTemp.setContinent(PaysUtils.Continent.EUROPE);
        System.out.printf("Après : %s\n", paysTemp);

        System.out.println("\nChanger la population de l'Allemagne :");
        paysTemp = PaysUtils.retrievePays(paysList, "Allemagne");
        System.out.printf("Avant : %s\n", paysTemp);
        paysTemp.setPopulation(paysTemp.getPopulation() * 10);
        System.out.printf("Après : %s\n", paysTemp);

        System.out.println("\nSupprimer le pays 'Des Ouragans' :");
        paysTemp = PaysUtils.retrievePays(paysList, "Des Ouragans");
        paysList.remove(paysTemp);

        System.out.println("\nAffichage des 20 premiers pays :");
        PaysUtils.afficher(paysList, 0, 20);

        System.out.println("\nAffichage des 15 premiers pays :");
        Collections.sort(paysList);
        PaysUtils.afficher(paysList, 0, 10);


        System.out.println("\nChercher avec BinarySearch puis afficher :");
        Pays paysAChercher = new Pays("Canada");
        paysTemp = Collections.binarySearch(paysList, paysAChercher);


        //! COMMENTER CHAQUE METHODES DE CLASSES !

    }

    public static int readFilePays(String fichier, Vector<Pays> paysList) throws IOException {
        int nombrePays = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                Pays pays = PaysUtils.createPays(ligne);
                paysList.add(pays);
                nombrePays++;
            }
        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erreur de format dans le fichier: " + e.getMessage());
        }

        return nombrePays;
    }
}
