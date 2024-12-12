//* Auteur : Olivier Nadeau [IFT1170 Automne 2024]
import classe.Pays;
import classe.PaysUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

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


/* Exécution

=== Numéro B ===

Pays ou la capitale est Washington :
Continent #2, Nom: ETATS-UNIS, Capital: WASHINGTON, Superficie: 9629047.0km2, Population: 291289535 habitant(s)

Pays ou la capitale est Ottawa :
Continent #2, Nom: CANADA, Capital: OTTAWA, Superficie: 9984670.0km2, Population: 31499560 habitant(s)

Pays ou la capitale est Santiago :
Aucun pays ne correspond au critère.

Affichage des 7 premiers pays :
0 - Continent #2, Nom: GUAM, Capital: AGANA, Superficie: 541.0km2, Population: 160796 habitant(s)
1 - Continent #2, Nom: PARAGUAY, Capital: ASUNCIO, Superficie: 406750.0km2, Population: 5734139 habitant(s)
2 - Continent #2, Nom: SAINT KITTSETNEVIS, Capital: BASSETERRE, Superficie: 261.0km2, Population: 38756 habitant(s)
3 - Continent #2, Nom: BELIZE, Capital: BELMOPAN, Superficie: 22966.0km2, Population: 266440 habitant(s)
4 - Continent #2, Nom: COLOMBIE, Capital: BOGOTA, Superficie: 1138910.0km2, Population: 41088227 habitant(s)
5 - Continent #2, Nom: BRESIL, Capital: BRASILIA, Superficie: 8511965.0km2, Population: 174468575 habitant(s)
6 - Continent #2, Nom: BARBADE, Capital: BRIDGETOWN, Superficie: 430.0km2, Population: 276607 habitant(s)

Pays CHILI à été ajouté avec succès.

Affichage de tous les pays de la liste :
0 - Continent #2, Nom: GUAM, Capital: AGANA, Superficie: 541.0km2, Population: 160796 habitant(s)
1 - Continent #2, Nom: PARAGUAY, Capital: ASUNCIO, Superficie: 406750.0km2, Population: 5734139 habitant(s)
2 - Continent #2, Nom: SAINT KITTSETNEVIS, Capital: BASSETERRE, Superficie: 261.0km2, Population: 38756 habitant(s)
3 - Continent #2, Nom: BELIZE, Capital: BELMOPAN, Superficie: 22966.0km2, Population: 266440 habitant(s)
4 - Continent #2, Nom: COLOMBIE, Capital: BOGOTA, Superficie: 1138910.0km2, Population: 41088227 habitant(s)
5 - Continent #2, Nom: BRESIL, Capital: BRASILIA, Superficie: 8511965.0km2, Population: 174468575 habitant(s)
6 - Continent #2, Nom: BARBADE, Capital: BRIDGETOWN, Superficie: 430.0km2, Population: 276607 habitant(s)
7 - Continent #2, Nom: ARGENTINE, Capital: BUENOS AIRES, Superficie: 2766890.0km2, Population: 37812817 habitant(s)
8 - Continent #2, Nom: VENEZUALA, Capital: CARACAS, Superficie: 912050.0km2, Population: 23542649 habitant(s)
9 - Continent #2, Nom: SAINTE LUCIE, Capital: CASTRIES, Superficie: 620.0km2, Population: 160145 habitant(s)
10 - Continent #2, Nom: ILES CAIMANS, Capital: GEORGE TOWN, Superficie: 262.0km2, Population: 39000 habitant(s)
11 - Continent #2, Nom: GUYANA, Capital: GEORGETOWN, Superficie: 214970.0km2, Population: 697181 habitant(s)
12 - Continent #2, Nom: GUATEMALA, Capital: GUATEMALA CIUDAD, Superficie: 108890.0km2, Population: 12974361 habitant(s)
13 - Continent #2, Nom: BERMUDES, Capital: HAMILTON, Superficie: 53.0km2, Population: 113208 habitant(s)
14 - Continent #2, Nom: JAMAIQUE, Capital: KINGSTON, Superficie: 10991.0km2, Population: 1695867 habitant(s)
15 - Continent #2, Nom: SAINT-VINCENT-ET-LES GRENADINES, Capital: KINGSTOWN, Superficie: 389.0km2, Population: 116812 habitant(s)
16 - Continent #2, Nom: CUBA, Capital: LA HAVANE, Superficie: 100860.0km2, Population: 11184023 habitant(s)
17 - Continent #2, Nom: BOLIVIE, Capital: LA PAZ, Superficie: 1098580.0km2, Population: 8724156 habitant(s)
18 - Continent #2, Nom: PEROU, Capital: LIMA, Superficie: 1285220.0km2, Population: 27949639 habitant(s)
19 - Continent #2, Nom: NICARAGUA, Capital: MANAGUA, Superficie: 129494.0km2, Population: 5128517 habitant(s)
20 - Continent #2, Nom: MEXIQUE, Capital: MEXICO, Superficie: 1972550.0km2, Population: 103400165 habitant(s)
21 - Continent #2, Nom: URUGUAY, Capital: MONTEVIDEO, Superficie: 176220.0km2, Population: 3360105 habitant(s)
22 - Continent #2, Nom: BAHAMAS, Capital: NASSAU, Superficie: 13940.0km2, Population: 300529 habitant(s)
23 - Continent #2, Nom: ARUBA, Capital: ORANJESTAD, Superficie: 193.0km2, Population: 69000 habitant(s)
24 - Continent #2, Nom: CANADA, Capital: OTTAWA, Superficie: 9984670.0km2, Population: 31499560 habitant(s)
25 - Continent #2, Nom: PANAMA, Capital: PANAMA, Superficie: 78200.0km2, Population: 2845647 habitant(s)
26 - Continent #2, Nom: SURINAME, Capital: PARAMARIBO, Superficie: 163270.0km2, Population: 433998 habitant(s)
27 - Continent #2, Nom: TRINITE-ET-TOBAGO, Capital: PORT D'ESPAGNE, Superficie: 5128.0km2, Population: 1104209 habitant(s)
28 - Continent #2, Nom: HAITI, Capital: PORT-AU-PRINCE, Superficie: 27750.0km2, Population: 7527817 habitant(s)
29 - Continent #2, Nom: EQUATEUR, Capital: QUITO, Superficie: 283560.0km2, Population: 13183978 habitant(s)
30 - Continent #2, Nom: ILES VIERGES BRITANNIQUES, Capital: ROAD TOWN, Superficie: 153.0km2, Population: 19000 habitant(s)
31 - Continent #2, Nom: REPUBLIQUE DOMINICAINE, Capital: SAINT-DOMINGUE, Superficie: 48730.0km2, Population: 8442533 habitant(s)
32 - Continent #2, Nom: GRENADE, Capital: SAINT-GEORGES, Superficie: 344.0km2, Population: 89260 habitant(s)
33 - Continent #2, Nom: ANTIGUA-ET-BARBUDA, Capital: SAINT-JOHNS, Superficie: 442.0km2, Population: 67448 habitant(s)
34 - Continent #2, Nom: COSTA RICA, Capital: SAN JOSE, Superficie: 51100.0km2, Population: 3835000 habitant(s)
35 - Continent #2, Nom: PORTO RICO, Capital: SAN JUAN, Superficie: 8959.0km2, Population: 3000000 habitant(s)
36 - Continent #2, Nom: EL SALVADOR, Capital: SAN SALVADOR, Superficie: 21041.0km2, Population: 6122075 habitant(s)
37 - Continent #2, Nom: CHILI, Capital: SANTIAGO, Superficie: 756950.0km2, Population: 15328467 habitant(s)
38 - Continent #2, Nom: HONDURAS, Capital: TEGUCIGALPA, Superficie: 112090.0km2, Population: 6249598 habitant(s)
39 - Continent #2, Nom: ETATS-UNIS, Capital: WASHINGTON, Superficie: 9629047.0km2, Population: 291289535 habitant(s)
40 - Continent #2, Nom: ANTILLES NEERLANDAISES, Capital: WILLEMSTAD, Superficie: 800.0km2, Population: 210000 habitant(s)

Process finished with exit code 0

*/