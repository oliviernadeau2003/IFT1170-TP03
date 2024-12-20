//* Auteur : Olivier Nadeau [IFT1170 Automne 2024]
package classe;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PaysUtils {
    public enum Continent {
        AFRIQUE('1'),
        AMERIQUE('2'),
        ASIE('3'),
        OCEANIE('4'),
        EUROPE('5');

        public final char number;

        Continent(char number) {
            this.number = number;
        }
    }

    // Affiche la liste
    static public void afficher(List<Pays> pays) {
        for (int i = 0; i < pays.size(); i++)
            System.out.printf("%s - %s\n", i, pays.get(i).toString());
    }

    // Affiche la liste à partir du start jusqu'à end
    static public void afficher(List<Pays> pays, int start, int end) {
        for (int i = start; i < end; i++)
            System.out.printf("%s - %s\n", i, pays.get(i).toString());
    }

    // Retourne le premier pays égal au nom
    public static Pays retrievePays(List<Pays> paysList, String nomPays) {
        for (Pays pays : paysList) {
            if (pays.getNom().equalsIgnoreCase(nomPays)) {
                return pays;
            }
        }
        return null;
    }

    // Retourne le premier pays égal à la capitale
    public static Pays retrievePaysParCapital(List<Pays> paysList, String capitale) {
        for (Pays pays : paysList) {
            if (pays.getCapitale().equalsIgnoreCase(capitale)) {
                return pays;
            }
        }
        return null;
    }

    // Trier par capitale
    public static void trierParCapitale(List<Pays> paysList) {
        // Trier la liste par capitale
        Comparator<Pays> comparatorByCapital = Comparator.comparing(Pays::getCapitale);
        Collections.sort(paysList, comparatorByCapital);
    }

    // Ajouter à une liste trié
    public static void ajouterACollectionTrierParCapitale(List<Pays> paysList, Pays pays) {
        int index = Collections.binarySearch(paysList, pays, Comparator.comparing(Pays::getCapitale));

        // Si l'index est négatif, il donne -(point d'insertion) - 1
        if (index < 0) {
            index = -(index + 1);
        }

        // Ajouter à l'indice calculé
        paysList.add(index, pays);

        System.out.printf("\nPays %s à été ajouté avec succès.\n", pays.getNom());
    }

    // Crée un instance de pays basé sur le format du fichier numA
    static public Pays createPaysFromFile(String ligne) {
        char continent = ligne.charAt(0);

        // 1 to 36
        String nom = ligne.substring(1, 36).trim();

        // 36 to 55
        String capitale = ligne.substring(36, 55).trim();

        // 55 to 64
        double superficie = Double.parseDouble(ligne.substring(55, 64).trim());

        // 64 till the end
        long population = Long.parseLong(ligne.substring(64).trim());

        return new Pays(continent, nom, capitale, superficie, population);
    }

    // Créer un instance de pays basé sur le format du fichier numB
    static public Pays createPaysFromFileNumB(String ligne) {
        char continent = ligne.charAt(0);

        // 1 to 37
        String nom = ligne.substring(1, 36).trim();

        // 36 to 55
        String capitale = ligne.substring(36, 62).trim();

        // 55 to 64
        double superficie = Double.parseDouble(ligne.substring(62, 75).trim());

        // 64 till the end
        long population = Long.parseLong(ligne.substring(75).trim());

        return new Pays(continent, nom, capitale, superficie, population);
    }
}