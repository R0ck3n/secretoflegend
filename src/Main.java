import classes.weapons.Axe;
import classes.combatClass.Warrior;
import interfaces.IWarriorWeapon;

public class Main {
    public static void main(String[] args) { // Ajout de la méthode main

        IWarriorWeapon axe = new Axe("Battle Axe", 50, 10);
        Warrior warrior = new Warrior("Conan", 100, "Rage",50, 20);
        warrior.equipWeapon(axe);
        warrior.getPlayerInfo();



    }
}
