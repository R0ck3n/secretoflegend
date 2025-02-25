package classes.combatClass;
import classes.weapons.Weapon;
import interfaces.IWeapon;

abstract class PlayableCharacter {
    protected String name;
    protected Integer health;
    protected String resourceType;
    protected Integer resourceQuantity;
    protected IWeapon weapon;
    protected Integer baseAttack;

    protected PlayableCharacter(String name, int health, String resourceType, int resourceQuantity, int baseAttack) {
        this.setName(name);
        this.setHealth(health);
        this.setResourceType(resourceType);
        this.setResourceQuantity(resourceQuantity);
        this.setBaseAttack(baseAttack);

    }

    public void equipWeapon( IWeapon weapon) {
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

    public IWeapon getWeapon() {
        return weapon;
    }

    public void setWeapon(IWeapon weapon) {
        this.weapon = weapon;
    }

    public void getPlayerInfo() {
        System.out.println("--------------------------------");
        System.out.println("Nom : " + getName());
        System.out.println("Santé : " + getHealth());
        System.out.println("Type de ressource : " + getResourceType());
        System.out.println("Quantité de ressource : " + getResourceQuantity());
        System.out.println("Attaque de base : " + getBaseAttack());

        if (weapon != null) {
            System.out.println("Arme équipée : ");
            if (weapon instanceof Weapon) {
                ((Weapon) weapon).getWeaponInfo();
            }
        } else {
            System.out.println("Aucune arme équipée.");
        }

        System.out.println("--------------------------------");
    }


}
