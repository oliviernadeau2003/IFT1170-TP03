import classe.Pays;
import classe.PaysUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

//* Auteur : Olivier Nadeau [IFT1170 Automne 2024]
public class TP03_1170_NumB {
    public static void main(String[] args) throws IOException {
        afficher();
    }

    // Affiche le numéro B
    public static void afficher() throws IOException {
        System.out.println("\n=== Numéro B ===");
        LinkedList<Pays> paysList = new LinkedList<Pays>();
        String currentDirectory = System.getProperty("user.dir");
        int nombrePays = readFilePaysBis(currentDirectory + "/src/data/pays_bis.txt", paysList);

        //System.out.println("\nAffichage des 15 premiers pays :");
        //PaysUtils.afficher(paysList);

        Pays paysTemp = PaysUtils.retrievePays(paysList, "Washington");

        paysTemp = PaysUtils.retrievePays(paysList, "Ottawa");

        paysTemp = PaysUtils.retrievePays(paysList, "Santiago");


    }

    // Lis le fichier et  rempli la LinkedList des pays d'Amérique
    public static int readFilePaysBis(String fichier, LinkedList<Pays> paysList) throws IOException {
        int nombrePays = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                Pays pays = PaysUtils.createPaysNumB(ligne);
                if (pays.getContinent() == PaysUtils.Continent.AMERIQUE.number) {
                    paysList.add(pays);
                    nombrePays++;
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erreur de format dans le fichier: " + e.getMessage());
        }

        return nombrePays;
    }
}
