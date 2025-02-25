package classes.weapons;

import interfaces.IArcherWeapon;

import java.util.ArrayList;
import java.util.Arrays;

public class Crossbow extends Weapon implements IArcherWeapon {
    public Crossbow(String name, int physicalDamage, int magicDamage) {
        setName(name);
        setType("Crossbow");
        setRange("Ranged");
        setPhysicalDamage(physicalDamage);
        setMagicalDamage(magicDamage);
        setAllowedClass(new ArrayList<>(Arrays.asList("Archer")));
    }

    public Crossbow(String name, int physicalDamage) {
        this(name, physicalDamage, 0);
    }


}
