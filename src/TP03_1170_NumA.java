import classe.Pays;
import classe.PaysUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

//* Auteur : Olivier Nadeau [IFT1170 Automne 2024]
public class TP03_1170_NumA {
    public static void main(String[] args) {
        afficher();
    }

    public static void afficher() {
        System.out.println("\n=== Numéro A ===");
        Vector<Pays> paysList = new Vector<Pays>();
        String currentDirectory = System.getProperty("user.dir");
        int nombrePays = readFilePays(currentDirectory + "/src/data/pays_a24.txt", paysList);

        PaysUtils.afficher(paysList, 0, 15);
    }
    
    public static int readFilePays(String fichier, Vector<Pays> paysList) {
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
