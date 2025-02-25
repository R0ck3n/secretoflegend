package classes.combatClass;

import classes.weapons.Weapon;
import enums.CharacterClass;
import interfaces.IAttacker;
import interfaces.IMageWeapon;
import interfaces.IWeapon;

public class Mage extends PlayableCharacter implements IAttacker {

    public Mage(String name, int health, int resourceQuantity, int baseAttack) {
        super(name, CharacterClass.MAGE, health, "Mana", resourceQuantity, baseAttack);
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
        if (weapon instanceof IMageWeapon) {
            this.weapon = weapon;
        } else {
            System.out.println("Un mage ne peut équiper que des armes de sa classe !");
        }
    }

    @Override
    public void setName(String newName) {
        this.name = newName;
    }

    public void setWeapon(IMageWeapon weapon) {
        this.weapon = weapon;
    }

}
