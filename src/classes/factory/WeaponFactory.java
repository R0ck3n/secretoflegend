package classes.factory;

import classes.weapons.Axe;
import classes.weapons.Bow;
import classes.weapons.Crossbow;
import classes.weapons.Staff;
import classes.weapons.Sword;
import classes.weapons.Wand;
import enums.WeaponType;
import interfaces.IWeapon;

public class WeaponFactory {
    public static IWeapon createWeapon(WeaponType weaponType) {
        switch (weaponType) {
            case AXE:
                return new Axe("Big Axe", 100);
            case SWORD:
                return new Sword("Big Sword", 100);
            case BOW:
                return new Bow("Basic Bow", 50);
            case CROSSBOW:
                return new Crossbow("Basic Crossbow", 70);
            case WAND:
                return new Wand("Basic Wand", 100);
            case STAFF:
                return new Staff("Basic Staff", 110);
            default:
                throw new IllegalArgumentException("Invalid weapon type");
        }
    }
}
