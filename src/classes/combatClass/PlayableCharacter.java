package classes.combatClass;

import classes.Weapons.Weapon;

abstract class PlayableCharacter {
    protected String name;
    protected Integer health;
    protected String resourceType;
    protected Integer resourceQuantity;
    protected Weapon weapon;
    protected Integer baseAttack;

    protected PlayableCharacter(String name, int health, String resourceType, int resourceQuantity, int baseAttack,
            Weapon weapon) {
        this.setName(name);
        this.setHealth(health);
        this.setResourceType(resourceType);
        this.setResourceQuantity(resourceQuantity);
        this.setBaseAttack(baseAttack);
        this.setWeapon(weapon);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name != null && !name.isEmpty() ? name : "Unknown";
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType != null && !resourceType.isEmpty() ? resourceType : "None";
    }

    public int getResourceQuantity() {
        return resourceQuantity;
    }

    public void setResourceQuantity(int resourceQuantity) {
        this.resourceQuantity = Math.max(resourceQuantity, 0);
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = Math.max(baseAttack, 0);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

}
