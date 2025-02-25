package classes.combatClass;

import classes.weapons.Weapon;
import interfaces.IArcherWeapon;
import interfaces.IAttacker;
import interfaces.IWeapon;


public class Archer extends PlayableCharacter implements IAttacker {

    public Archer(String name, int health, int resourceQuantity, int baseAttack) {
        super(name, "Archer", health, "Energy", resourceQuantity, baseAttack);
    }

    @Override
    public int attack() {
        int totalWeaponDamage = (weapon != null) ? ((Weapon) weapon).getMagicalDamage() + ((Weapon) weapon).getPhysicalDamage() : 0;

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

    public void setWeapon(IArcherWeapon weapon) {
        this.weapon = weapon;
    }

}
