package classes.weapons;

import interfaces.IWarriorWeapon;

import java.util.ArrayList;
import java.util.Arrays;

public class Sword extends Weapon implements IWarriorWeapon {
    public Sword(String name, int physicalDamage, int magicDamage) {
        setName(name);
        setType("Axe");
        setRange("Melee");
        setPhysicalDamage(physicalDamage);
        setMagicalDamage(magicDamage);
        setAllowedClass(new ArrayList<>(Arrays.asList("Warrior")));
    }

    public Sword(String name, int physicalDamage) {
        this(name, physicalDamage, 0);
    }


}
