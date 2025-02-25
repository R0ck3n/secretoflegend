package classes.Weapons;

import interfaces.IWarriorWeapon;
import java.util.ArrayList;
import java.util.Arrays;

public class Axe extends Weapon implements IWarriorWeapon {
    public Axe(String name, int physicalDamage, int magicDamage) {
        setName(name);
        setType("Axe");
        setRange("Melee");
        setPhysicalDamage(physicalDamage);
        setMagicalDamage(magicDamage);
        setAllowedClass(new ArrayList<>(Arrays.asList("Warrior")));
    }

    public Axe(String name, int physicalDamage) {
        this(name, physicalDamage, 0);
    }


}
