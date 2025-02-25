package classes.combatClass;

import classes.Weapons.Weapon;
import interfaces.IAttacker;
import interfaces.IWarriorWeapon;

public class Warrior extends PlayableCharacter implements IAttacker {

    public Warrior(String name, int health, String resourceType, int resourceQuantity, int baseAttack) {
        super(name, health, resourceType, resourceQuantity, baseAttack);
    }

    @Override
    public int attack() {
        int totalWeaponDamage = (weapon != null) ? ((Weapon) weapon).getMagicalDamage() + ((Weapon) weapon).getPhysicalDamage() : 0;

        return baseAttack + Math.max(totalWeaponDamage, 0);
    }
}
