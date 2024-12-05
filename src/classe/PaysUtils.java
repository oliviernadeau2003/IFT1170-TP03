//* Auteur : Olivier Nadeau [IFT1170 Automne 2024]
package classe;

import java.util.Vector;

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

    static public void afficher(Vector<Pays> pays) {
        for (int i = 0; i < pays.size(); i++)
            System.out.printf("%s - %s\n", i, pays.get(i).toString());
    }

    static public void afficher(Vector<Pays> pays, int start, int end) {
        for (int i = start; i < end; i++)
            System.out.printf("%s - %s\n", i, pays.get(i).toString());
    }

    public static Pays retrievePays(Vector<Pays> paysList, String nomPays) {
        for (Pays pays : paysList) {
            if (pays.getNom().equalsIgnoreCase(nomPays)) {
                return pays;
            }
        }
        return null;
    }

    static public Pays createPays(String ligne) {
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
}