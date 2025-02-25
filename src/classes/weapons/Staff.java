package classes.weapons;


import interfaces.IMageWeapon;

import java.util.ArrayList;
import java.util.Arrays;

public class Staff extends Weapon implements IMageWeapon {
    public Staff(String name, int magicDamage, int physicalDamage) {
        setName(name);
        setType("Staff");
        setRange("Magic");
        setPhysicalDamage(physicalDamage);
        setMagicalDamage(magicDamage);
        setAllowedClass(new ArrayList<>(Arrays.asList("Mage")));
    }

    public Staff(String name, int magicDamage) {
        this(name, magicDamage, 0);
    }


}
