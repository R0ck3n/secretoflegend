package classes.combatClass;

import classes.Weapons.Weapon;
import interfaces.IAttacker;

public class Warrior extends PlayableCharacter implements IAttacker {
    public Warrior(String name, int health, String resourceType, Weapon weapon, int resourceQuantity, int baseAttack) {
        super(name, health, resourceType, weapon, resourceQuantity, baseAttack);

    }

    @Override
    public int attack() {
        int totalWeaponDamage = Math.min(weapon.getMagicalDamage() + weapon.getPhysicalDamage(), 0);

        return baseAttack + totalWeaponDamage;
    }

}
