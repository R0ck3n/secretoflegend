package classes.combatClass;

import classes.weapons.Weapon;
import enums.CharacterClass;
import interfaces.IWeapon;

public abstract class PlayableCharacter {
    protected String name;
    protected CharacterClass playerClass;
    protected int health;
    protected String resourceType;
    protected int resourceQuantity;
    protected IWeapon weapon;
    protected int baseAttack;

    protected PlayableCharacter(String name, CharacterClass playerClass, int health, String resourceType,
            int resourceQuantity, int baseAttack) {
        this.name = name;
        this.playerClass = playerClass;
        this.health = Math.max(health, 0);
        this.resourceType = resourceType;
        this.resourceQuantity = Math.max(resourceQuantity, 0);
        this.baseAttack = Math.max(baseAttack, 0);
    }

    public String getName() {
        return name;
    }

    public CharacterClass getPlayerClass() {
        return playerClass;
    }

    public int getHealth() {
        return health;
    }

    public String getResourceType() {
        return resourceType;
    }

    public int getResourceQuantity() {
        return resourceQuantity;
    }

    public IWeapon getWeapon() {
        return weapon;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    public void setResourceQuantity(int resourceQuantity) {
        this.resourceQuantity = Math.max(resourceQuantity, 0);
    }

    public void setWeapon(IWeapon weapon) {
        this.weapon = weapon;
    }

    public abstract void setName(String name);

    public void displayInfo() {
        System.out.println("--------------------------------");
        System.out.println("Nom : " + name);
        System.out.println("Classe : " + playerClass);
        System.out.println("Santé : " + health);
        System.out.println("Type de ressource : " + resourceType);
        System.out.println("Quantité de ressource : " + resourceQuantity);
        System.out.println("Attaque de base : " + baseAttack);
        if (weapon instanceof Weapon) {
            System.out.print("Arme équipée : ");
            ((Weapon) weapon).getWeaponInfo();
        } else {
            System.out.println("Arme équipée : Aucune");
        }
        System.out.println("--------------------------------");
    }
}
