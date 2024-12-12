import classe.Pays;
import classe.PaysUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
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

        // Recherche séquentielle
        Pays paysTemp;
        // Washington
        System.out.println("\nPays ou la capitale est Washington :");
        paysTemp = PaysUtils.retrievePaysParCapital(paysList, "Washington");
        if (paysTemp == null) System.out.printf("Aucun pays ne correspond au critère.\n");
        else System.out.printf("%s\n", paysTemp);

        // Ottawa
        System.out.println("\nPays ou la capitale est Ottawa :");
        paysTemp = PaysUtils.retrievePaysParCapital(paysList, "Ottawa");
        if (paysTemp == null) System.out.printf("Aucun pays ne correspond au critère.\n");
        else System.out.printf("%s\n", paysTemp);

        // Santiago
        System.out.println("\nPays ou la capitale est Santiago :");
        paysTemp = PaysUtils.retrievePaysParCapital(paysList, "Santiago");
        if (paysTemp == null) System.out.printf("Aucun pays ne correspond au critère.\n");
        else System.out.printf("%s\n", paysTemp);

        // Trier avec Collections.Sort via la capitale
        PaysUtils.trierParCapitale(paysList);

        // Afichage des 7 premier pays de la liste
        System.out.println("\nAffichage des 7 premiers pays :");
        PaysUtils.afficher(paysList, 0, 7);

        // Ajouter à la liste en gardant la liste trier
        Pays chili = new Pays(PaysUtils.Continent.AMERIQUE.number, "CHILI", "SANTIAGO", 756950, 15328467);
        // Utiliser binarySearch pour trouver l'indice d'insertion
        PaysUtils.ajouterACollectionTrierParCapitale(paysList,chili);

        // Afficher tous les pays de la liste
        System.out.println("\nAffichage de tous les pays de la liste :");
        PaysUtils.afficher(paysList);

    }

    // Lis le fichier et  rempli la LinkedList des pays d'Amérique
    public static int readFilePaysBis(String fichier, LinkedList<Pays> paysList) throws IOException {
        int nombrePays = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                Pays pays = PaysUtils.createPaysFromFileNumB(ligne);
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
