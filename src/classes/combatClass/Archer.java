package classes.combatClass;

import classes.weapons.Weapon;
import enums.CharacterClass;
import interfaces.IArcherWeapon;
import interfaces.IAttacker;
import interfaces.IWeapon;

public class Archer extends PlayableCharacter implements IAttacker {

    public Archer(String name, CharacterClass playerClass, int health, int resourceQuantity,
            int baseAttack) {
        super(name, CharacterClass.ARCHER, health, "Energy", resourceQuantity, baseAttack);
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
        if (weapon instanceof IArcherWeapon) {
            this.weapon = weapon;
        } else {
            System.out.println("Un archer ne peut équiper que des armes de sa classe !");
        }
    }

    @Override
    public void setName(String newName) {
        this.name = newName;
    }

    public void setWeapon(IArcherWeapon weapon) {
        this.weapon = weapon;
    }

}
