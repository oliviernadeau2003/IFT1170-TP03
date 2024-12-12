//* Auteur : Olivier Nadeau [IFT1170 Automne 2024]
import classe.Pays;
import classe.PaysUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Vector;

public class TP03_1170_NumA {
    public static void main(String[] args) throws IOException {
        afficher();
    }

    // Affiche le numéro A
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
        Collections.sort(paysList); // En utilisant la fonction overide CompareTo de la classe
        PaysUtils.afficher(paysList, 0, 10);

        System.out.println("\nChercher avec BinarySearch puis afficher :");

        // Canada
        Pays paysAChercher = new Pays(PaysUtils.Continent.AFRIQUE.number, "Canada", "s", 0, 0);
        int indexPaysTrouver = Collections.binarySearch(paysList, paysAChercher);
        paysTemp = paysList.get(indexPaysTrouver);
        System.out.printf("Canada : %s\n", paysTemp);

        // Mexique
        paysAChercher = new Pays(PaysUtils.Continent.AFRIQUE.number, "Mexique", "s", 0, 0);
        indexPaysTrouver = Collections.binarySearch(paysList, paysAChercher);
        paysTemp = paysList.get(indexPaysTrouver);
        System.out.printf("Mexique : %s\n", paysTemp);

        // Japon
        paysAChercher = new Pays(PaysUtils.Continent.AFRIQUE.number, "Japon", "s", 0, 0);
        indexPaysTrouver = Collections.binarySearch(paysList, paysAChercher);
        paysTemp = paysList.get(indexPaysTrouver);
        System.out.printf("Japon : %s\n", paysTemp);

        // Chili
        paysAChercher = new Pays(PaysUtils.Continent.AFRIQUE.number, "Chili", "s", 0, 0);
        indexPaysTrouver = Collections.binarySearch(paysList, paysAChercher);
        paysTemp = paysList.get(indexPaysTrouver);
        System.out.printf("Chili : %s\n", paysTemp);
    }

    // Lis le fichier et rempli le vector de tous les pays
    public static int readFilePays(String fichier, Vector<Pays> paysList) throws IOException {
        int nombrePays = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                Pays pays = PaysUtils.createPaysFromFile(ligne);
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

/* Exécution
=== Numéro A ===

Affichage des 15 premiers pays :
0 - Continent #4, Nom: ETATS-UNIS, Capital: WASHINGTON, Superficie: 9629047.0km2, Population: 291289535 habitant(s)
1 - Continent #3, Nom: CHINE, Capital: PEKIN, Superficie: 9596960.0km2, Population: 1273111290 habitant(s)
2 - Continent #2, Nom: RUSSIE, Capital: MOSCOU, Superficie: 1.70754E7km2, Population: 143954573 habitant(s)
3 - Continent #4, Nom: AUSTRALIE, Capital: CANBERRA, Superficie: 7686850.0km2, Population: 19834248 habitant(s)
4 - Continent #3, Nom: JAPON, Capital: KYOTO, Superficie: 377835.0km2, Population: 12761000 habitant(s)
5 - Continent #4, Nom: DES OURAGANS, Capital: TEMPETE, Superficie: 1.0km2, Population: 1 habitant(s)
6 - Continent #5, Nom: ALLEMAGNE, Capital: BERLIN, Superficie: 357027.0km2, Population: 8253700 habitant(s)
7 - Continent #5, Nom: FRANCE, Capital: MARSEILLE, Superficie: 543964.0km2, Population: 61387038 habitant(s)
8 - Continent #5, Nom: ITALIE, Capital: ROME, Superficie: 301230.0km2, Population: 57715620 habitant(s)
9 - Continent #3, Nom: COREE DU SUD, Capital: SEOUL, Superficie: 99274.0km2, Population: 483240 habitant(s)
10 - Continent #5, Nom: ROYAUME-UNI, Capital: LONDRES, Superficie: 244101.0km2, Population: 58789194 habitant(s)
11 - Continent #2, Nom: CUBA, Capital: LA HAVANE, Superficie: 100860.0km2, Population: 11184023 habitant(s)
12 - Continent #5, Nom: UKRAINE, Capital: KIEV, Superficie: 603700.0km2, Population: 48396470 habitant(s)
13 - Continent #5, Nom: HONGRIE, Capital: BUDAPEST, Superficie: 93030.0km2, Population: 10106017 habitant(s)
14 - Continent #5, Nom: ROUMANIE, Capital: BUCAREST, Superficie: 238390.0km2, Population: 22272000 habitant(s)

Modifier le continent de la Russie pour l'Europe :
Avant : Continent #2, Nom: RUSSIE, Capital: MOSCOU, Superficie: 1.70754E7km2, Population: 143954573 habitant(s)
Après : Continent #5, Nom: RUSSIE, Capital: MOSCOU, Superficie: 1.70754E7km2, Population: 143954573 habitant(s)

Changer la population de l'Allemagne :
Avant : Continent #5, Nom: ALLEMAGNE, Capital: BERLIN, Superficie: 357027.0km2, Population: 8253700 habitant(s)
Après : Continent #5, Nom: ALLEMAGNE, Capital: BERLIN, Superficie: 357027.0km2, Population: 82537000 habitant(s)

Supprimer le pays 'Des Ouragans' :

Affichage des 20 premiers pays :
0 - Continent #4, Nom: ETATS-UNIS, Capital: WASHINGTON, Superficie: 9629047.0km2, Population: 291289535 habitant(s)
1 - Continent #3, Nom: CHINE, Capital: PEKIN, Superficie: 9596960.0km2, Population: 1273111290 habitant(s)
2 - Continent #5, Nom: RUSSIE, Capital: MOSCOU, Superficie: 1.70754E7km2, Population: 143954573 habitant(s)
3 - Continent #4, Nom: AUSTRALIE, Capital: CANBERRA, Superficie: 7686850.0km2, Population: 19834248 habitant(s)
4 - Continent #3, Nom: JAPON, Capital: KYOTO, Superficie: 377835.0km2, Population: 12761000 habitant(s)
5 - Continent #5, Nom: ALLEMAGNE, Capital: BERLIN, Superficie: 357027.0km2, Population: 82537000 habitant(s)
6 - Continent #5, Nom: FRANCE, Capital: MARSEILLE, Superficie: 543964.0km2, Population: 61387038 habitant(s)
7 - Continent #5, Nom: ITALIE, Capital: ROME, Superficie: 301230.0km2, Population: 57715620 habitant(s)
8 - Continent #3, Nom: COREE DU SUD, Capital: SEOUL, Superficie: 99274.0km2, Population: 483240 habitant(s)
9 - Continent #5, Nom: ROYAUME-UNI, Capital: LONDRES, Superficie: 244101.0km2, Population: 58789194 habitant(s)
10 - Continent #2, Nom: CUBA, Capital: LA HAVANE, Superficie: 100860.0km2, Population: 11184023 habitant(s)
11 - Continent #5, Nom: UKRAINE, Capital: KIEV, Superficie: 603700.0km2, Population: 48396470 habitant(s)
12 - Continent #5, Nom: HONGRIE, Capital: BUDAPEST, Superficie: 93030.0km2, Population: 10106017 habitant(s)
13 - Continent #5, Nom: ROUMANIE, Capital: BUCAREST, Superficie: 238390.0km2, Population: 22272000 habitant(s)
14 - Continent #5, Nom: GRECE, Capital: ATHENES, Superficie: 131940.0km2, Population: 10623835 habitant(s)
15 - Continent #5, Nom: NORVEGE, Capital: OSLO, Superficie: 324220.0km2, Population: 4525116 habitant(s)
16 - Continent #5, Nom: PAYS-BAS, Capital: AMSTERDAM, Superficie: 41526.0km2, Population: 16135992 habitant(s)
17 - Continent #2, Nom: BRESIL, Capital: BRASILIA, Superficie: 8511965.0km2, Population: 174468575 habitant(s)
18 - Continent #5, Nom: SUEDE, Capital: STOCKHOLM, Superficie: 449964.0km2, Population: 8875053 habitant(s)
19 - Continent #5, Nom: ESPAGNE, Capital: MADRID, Superficie: 504782.0km2, Population: 40037995 habitant(s)

Affichage des 15 premiers pays :
0 - Continent #3, Nom: AFGHANISTAN, Capital: KABOUL, Superficie: 652225.0km2, Population: 29547078 habitant(s)
1 - Continent #1, Nom: AFRIQUE DU SUD, Capital: PRETORIA, Superficie: 1219912.0km2, Population: 42718530 habitant(s)
2 - Continent #5, Nom: ALBANIE, Capital: TIRANA, Superficie: 28748.0km2, Population: 3510484 habitant(s)
3 - Continent #1, Nom: ALGERIE, Capital: ALGER, Superficie: 2381740.0km2, Population: 31763053 habitant(s)
4 - Continent #5, Nom: ALLEMAGNE, Capital: BERLIN, Superficie: 357027.0km2, Population: 82537000 habitant(s)
5 - Continent #5, Nom: ANDORRE, Capital: ANDORRA LA VELLA, Superficie: 468.0km2, Population: 67627 habitant(s)
6 - Continent #1, Nom: ANGOLA, Capital: LUANDA, Superficie: 1246700.0km2, Population: 10766471 habitant(s)
7 - Continent #2, Nom: ANTIGUA-ET-BARBUDA, Capital: SAINT-JOHNS, Superficie: 442.0km2, Population: 67448 habitant(s)
8 - Continent #2, Nom: ANTILLES NEERLANDAISES, Capital: WILLEMSTAD, Superficie: 800.0km2, Population: 210000 habitant(s)
9 - Continent #3, Nom: ARABIE SAOUDITE, Capital: RIYAD, Superficie: 1960582.0km2, Population: 23513330 habitant(s)

Chercher avec BinarySearch puis afficher :
Canada : Continent #2, Nom: CANADA, Capital: OTTAWA, Superficie: 9984670.0km2, Population: 31499560 habitant(s)
Mexique : Continent #2, Nom: MEXIQUE, Capital: MEXICO, Superficie: 1972550.0km2, Population: 103400165 habitant(s)
Japon : Continent #3, Nom: JAPON, Capital: KYOTO, Superficie: 377835.0km2, Population: 12761000 habitant(s)
Chili : Continent #3, Nom: CHILI, Capital: SANTIAGO, Superficie: 756950.0km2, Population: 15328467 habitant(s)

Process finished with exit code 0
 */