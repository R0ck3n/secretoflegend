package classes.weapons;

import java.util.ArrayList;

public abstract class Weapon {
    protected String name;
    protected String type;
    protected String range;
    protected Integer physical_damage;
    protected Integer magical_damage;
    protected ArrayList<String> allowed_class;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPhysicalDamage() {
        return physical_damage;
    }

    public void setPhysicalDamage(Integer physical_damage) {
        this.physical_damage = physical_damage;
    }

    public Integer getMagicalDamage() {
        return magical_damage;
    }

    public void setMagicalDamage(Integer magical_damage) {
        this.magical_damage = magical_damage;
    }

    public ArrayList<String> getAllowedClass() {
        return allowed_class;
    }

    public void setAllowedClass(ArrayList<String> allowed_class) {
        this.allowed_class = allowed_class;
    }

    public void setRange(String range) {
        this.range = range;
    }
    public String getRange() {
        return range;
    }

    public void  getWeaponInfo() {
        System.out.println("                  ----------");
        System.out.println("       Nom : " + getName());
        System.out.println("       Type : " + getType());
        System.out.println("       Range : " + getRange());
        System.out.println("       Physical damage : " + getPhysicalDamage());
        System.out.println("       Magical damage : " + getMagicalDamage());
        System.out.println("       Allowed class : " + getAllowedClass());
        System.out.println("                  ----------");
    }
}
