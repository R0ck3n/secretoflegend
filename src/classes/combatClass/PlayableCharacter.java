package classes.combatClass;

import java.util.Scanner;

import classes.weapons.Axe;
import classes.weapons.Bow;
import classes.weapons.Crossbow;
import classes.weapons.Staff;
import classes.weapons.Sword;
import classes.weapons.Wand;
import classes.weapons.Weapon;
import interfaces.IWeapon;

public abstract class PlayableCharacter {
    protected String name;
    protected String playerClass;
    protected Integer health;
    protected String resourceType;
    protected Integer resourceQuantity;
    protected IWeapon weapon;
    protected Integer baseAttack;

    public static PlayableCharacter playerCreation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sélectionner la classe du personnage :");
        System.out.println("1. Guerrier");
        System.out.println("2. Archer");
        System.out.println("3. Mage");

        int classeChoice;
        do {
            System.out.print("Votre choix : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre valide.");
                scanner.next();
            }
            classeChoice = scanner.nextInt();
        } while (classeChoice < 1 || classeChoice > 3);

        scanner.nextLine();

        System.out.print("Sélectionner le nom du personnage : ");
        String charName = scanner.nextLine();

        PlayableCharacter player = null;

        switch (classeChoice) {
            case 1:
                player = new Warrior(charName, 100, 50, 20);
                System.out.println("Select a weapon : ");
                System.out.println("1. Hâche");
                System.out.println("2. Epée");
                break;
            case 2:
                player = new Archer(charName, 75, 50, 20);
                System.out.println("Select a weapon : ");
                System.out.println("1. Arc");
                System.out.println("2. Arbalète");
                break;
            case 3:
                player = new Mage(charName, 50, 200, 100);
                System.out.println("Select a weapon : ");
                System.out.println("1. Baguette");
                System.out.println("2. Baton");
                break;
        }

        int selectedWeapon;
        do {
            System.out.print("Votre choix : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre valide.");
                scanner.next();
            }
            selectedWeapon = scanner.nextInt();
        } while (selectedWeapon < 1 || selectedWeapon > 2);

        if (player != null) {
            IWeapon weapon = null;
            switch (classeChoice) {
                case 1:
                    weapon = (selectedWeapon == 1) ? new Axe("Big Axe", 100) : new Sword("Big Sword", 100);
                    break;
                case 2:
                    weapon = (selectedWeapon == 1) ? new Bow("Basic Bow", 50) : new Crossbow("Basic Crossbow", 70);
                    break;
                case 3:
                    weapon = (selectedWeapon == 1) ? new Wand("Basic Wand", 100) : new Staff("Basic Staff", 110);
                    break;
            }
            player.setWeapon(weapon);
        }

        System.out.println("\nPersonnage créé avec succès !");
        return player;
    }

    protected PlayableCharacter(String name, String playerClass, int health, String resourceType, int resourceQuantity,
            int baseAttack) {
        this.setName(name);
        this.setPlayerClass(playerClass);
        this.setHealth(health);
        this.setResourceType(resourceType);
        this.setResourceQuantity(resourceQuantity);
        this.setBaseAttack(baseAttack);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name != null && !name.isEmpty() ? name : "Unknown";
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType != null && !resourceType.isEmpty() ? resourceType : "None";
    }

    public int getResourceQuantity() {
        return resourceQuantity;
    }

    public void setResourceQuantity(int resourceQuantity) {
        this.resourceQuantity = Math.max(resourceQuantity, 0);
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = Math.max(baseAttack, 0);
    }

    public IWeapon getWeapon() {
        return weapon;
    }

    abstract void setWeapon(IWeapon weapon);

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void getPlayerInfo() {
        System.out.println("--------------------------------");
        System.out.println("Nom : " + getName());
        System.out.println("Classe : " + getPlayerClass());
        System.out.println("Santé : " + getHealth());
        System.out.println("Type de ressource : " + getResourceType());
        System.out.println("Quantité de ressource : " + getResourceQuantity());
        System.out.println("Attaque de base : " + getBaseAttack());

        if (weapon != null) {
            System.out.println("Arme équipée : ");
            if (weapon instanceof Weapon) {
                ((Weapon) weapon).getWeaponInfo();
            }
        } else {
            System.out.println("Aucune arme équipée.");
        }

        System.out.println("--------------------------------");
    }

}
