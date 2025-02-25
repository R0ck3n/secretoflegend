import classes.combatClass.Warrior;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) { // Ajout de la méthode main

        Scanner sc = new Scanner(System.in);

        // Choix du type d'élément
        System.out.println("Quel type de personnage souhaitez-vous créer ?");
        System.out.println("1. Guerrier");
        System.out.println("2. Archer");
        System.out.println("3. Mage");
        int classChoice = sc.nextInt();

        if (classChoice < 4 && classChoice > 0) {System.out.print("Entrez le nom du personnage : ");
        }
        switch (classChoice) {
            case 1:
                // Création d'un Guerrier
                String name = sc.next();
                try {
                    Warrior warrior = new Warrior(name);
                    System.out.println("Character name: " + warrior.getName());
                } catch (IllegalArgumentException e) {
                    System.out.println("Erreur : " + e.getMessage());
                    sc.close();
                    return;
                }

                break;
            case 2:
                break;
            case 3:
                break;
            default:
                System.out.println("Choix invalide.");
                sc.close();
                return;
        }

    }
}
