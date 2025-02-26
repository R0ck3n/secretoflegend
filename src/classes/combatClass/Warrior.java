package classes.combatClass;

import classes.weapons.Weapon;
import enums.CharacterClass;
import interfaces.IAttacker;
import interfaces.IWarriorWeapon;
import interfaces.IWeapon;

public class Warrior extends PlayableCharacter implements IAttacker {

    public Warrior(String name, int health, int resourceQuantity, int baseAttack) {
        super(name, CharacterClass.WARRIOR, health, "Rage", resourceQuantity, baseAttack);
    }

    @Override
    public int attack() {
        int totalWeaponDamage = (weapon != null)
                ? ((Weapon) weapon).getMagicalDamage() + ((Weapon) weapon).getPhysicalDamage()
                : 0;

        return baseAttack + Math.max(totalWeaponDamage, 0);
    }

    @Override
    public void setWeapon(IWeapon weapon) {
        if (weapon instanceof IWarriorWeapon) {
            this.weapon = weapon;
        } else {
            System.out.println("Un guerrier ne peut équiper que des armes de sa classe !");
        }
    }

    @Override
    public void setName(String newName) {
        this.name = newName;
    }

    public void setWeapon(IWarriorWeapon weapon) {
        this.weapon = weapon;
    }

}
