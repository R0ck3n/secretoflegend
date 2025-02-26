package classes.game;

import java.util.Scanner;

import classes.combatClass.PlayableCharacter;
import classes.factory.CharacterFactory;
import classes.factory.WeaponFactory;
import enums.CharacterClass;
import enums.WeaponType;
import interfaces.IAttacker;

public class GameManager {
    private static final Scanner scanner = new Scanner(System.in);

    public static void startGame() {
        System.out.println("=== Création des personnages ===");
        System.out.println("CREATION DU PREMIER PERSONNAGE");
        PlayableCharacter player1 = createPlayer();
        System.out.println("CREATION DU SECOND PERSONNAGE");
        PlayableCharacter player2 = createPlayer();

        System.out.println("\n=== Début du combat ! ===\n");
        startCombat(player1, player2);
    }

    private static PlayableCharacter createPlayer() {
        System.out.println("Sélectionner la classe du personnage :");
        System.out.println("1. Guerrier\n2. Archer\n3. Mage");

        CharacterClass chosenClass = selectCharacterClass();
        System.out.print("Sélectionner le nom du personnage : ");
        String charName = scanner.nextLine();

        PlayableCharacter player = CharacterFactory.createCharacter(chosenClass, charName);
        WeaponType weaponChoice = selectWeapon(chosenClass);
        player.setWeapon(WeaponFactory.createWeapon(weaponChoice));

        System.out.println("\nPersonnage créé avec succès !");
        player.displayInfo();
        return player;
    }

    private static CharacterClass selectCharacterClass() {
        int choice;
        do {
            System.out.print("Votre choix : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre valide.");
                scanner.next();
            }
            choice = scanner.nextInt();
        } while (choice < 1 || choice > 3);
        scanner.nextLine();

        return CharacterClass.values()[choice - 1];
    }

    private static WeaponType selectWeapon(CharacterClass characterClass) {
        System.out.println("Sélectionner une arme :");
        switch (characterClass) {
            case WARRIOR:
                System.out.println("1. Hâche\n2. Épée");
                break;
            case ARCHER:
                System.out.println("1. Arc\n2. Arbalète");
                break;
            case MAGE:
                System.out.println("1. Baguette\n2. Bâton");
                break;
        }
        int choice;
        do {
            System.out.print("Votre choix : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre valide.");
                scanner.next();
            }
            choice = scanner.nextInt();
        } while (choice < 1 || choice > 2);
        scanner.nextLine();

        switch (characterClass) {
            case WARRIOR:
                return (choice == 1) ? WeaponType.AXE : WeaponType.SWORD;
            case ARCHER:
                return (choice == 1) ? WeaponType.BOW : WeaponType.CROSSBOW;
            case MAGE:
                return (choice == 1) ? WeaponType.WAND : WeaponType.STAFF;
            default:
                throw new IllegalStateException("Unexpected value: " + characterClass);
        }
    }

    private static void startCombat(PlayableCharacter player1, PlayableCharacter player2) {
        while (player1.getHealth() > 0 && player2.getHealth() > 0) {
            System.out.println("\n=== Tour de combat ===\n");

            attack(player1, player2);
            if (player2.getHealth() <= 0) {
                System.out
                        .println(player2.getName() + " est vaincu ! " + player1.getName() + " remporte la victoire !");
                break;
            }

            attack(player2, player1);
            if (player1.getHealth() <= 0) {
                System.out
                        .println(player1.getName() + " est vaincu ! " + player2.getName() + " remporte la victoire !");
                break;
            }
        }
        System.out.println("\n=== Fin du combat ===");
    }

    private static void attack(PlayableCharacter attacker, PlayableCharacter defender) {
        if (attacker instanceof IAttacker) {
            int damage = ((IAttacker) attacker).attack();
            defender.setHealth(defender.getHealth() - damage);
            System.out.println(
                    attacker.getName() + " attaque " + defender.getName() + " et inflige " + damage + " dégâts !");
            System.out.println(defender.getName() + " a maintenant " + defender.getHealth() + " points de vie.");
        }
    }
}
