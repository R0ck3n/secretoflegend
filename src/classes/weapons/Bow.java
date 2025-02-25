package classes.weapons;

import interfaces.IArcherWeapon;

import java.util.ArrayList;
import java.util.Arrays;

public class Bow extends Weapon implements IArcherWeapon {
    public Bow(String name, int physicalDamage, int magicDamage) {
        setName(name);
        setType("Bow");
        setRange("Ranged");
        setPhysicalDamage(physicalDamage);
        setMagicalDamage(magicDamage);
        setAllowedClass(new ArrayList<>(Arrays.asList("Archer")));
    }

    public Bow(String name, int physicalDamage) {
        this(name, physicalDamage, 0);
    }


}
