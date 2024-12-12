//* Auteur : Olivier Nadeau [IFT1170 Automne 2024]
public class TP03_1170_NumC {
    public static void main(String[] args) {
        afficher();
    }

    // Affiche le numéro C
    public static void afficher() {
        System.out.println("\n=== Numéro C ===");

        final int nombre1 = 2731;
        final int nombre2 = 41376;

        System.out.println("\n- Itération -");
        System.out.printf("Nombre %d:\n", nombre1);
        afficherIteration(nombre1);
        System.out.printf("Nombre %d:\n", nombre2);
        afficherIteration(nombre2);

        System.out.println("\n- Récursivité -");
        System.out.printf("Nombre %d:\n", nombre1);
        afficherRecursivite(nombre1);
        System.out.printf("Nombre %d:\n", nombre2);
        afficherRecursivite(nombre2);
    }

    // Fonction Ittérative
    static void afficherIteration(int nombre) {
        String nombreStr = Integer.toString(nombre);
        for (int i = 0; i < nombreStr.length(); i++)
            System.out.println(nombreStr.charAt(i));
    }

    // Fonction Récursive
    static void afficherRecursivite(int nombre) {
        if (nombre < 10)
            System.out.println(nombre);
        else {
            System.out.println(nombre % 10);
            afficherRecursivite(nombre / 10);
        }
    }
}


/*  Exécution

=== Numéro C ===

- Itération -
Nombre 2731:
2
7
3
1
Nombre 41376:
4
1
3
7
6

- Récursivité -
Nombre 2731:
1
3
7
2
Nombre 41376:
6
7
3
1
4

 */