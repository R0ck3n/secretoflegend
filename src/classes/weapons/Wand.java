package classes.weapons;


import interfaces.IMageWeapon;

import java.util.ArrayList;
import java.util.Arrays;

public class Wand extends Weapon implements IMageWeapon {
    public Wand(String name, int magicDamage, int physicalDamage) {
        setName(name);
        setType("Wand");
        setRange("Magic");
        setPhysicalDamage(physicalDamage);
        setMagicalDamage(magicDamage);
        setAllowedClass(new ArrayList<>(Arrays.asList("Mage")));
    }

    public Wand(String name, int magicDamage) {
        this(name, magicDamage, 0);
    }


}
