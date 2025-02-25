import classes.combatClass.Archer;
import classes.combatClass.Mage;
import classes.weapons.Axe;
import classes.combatClass.Warrior;
import classes.weapons.Bow;
import classes.weapons.Wand;
import interfaces.IArcherWeapon;
import interfaces.IMageWeapon;
import interfaces.IWarriorWeapon;

public class Main {
    public static void main(String[] args) { // Ajout de la méthode main

        IWarriorWeapon axe = new Axe("Battle Axe", 50);
        Warrior warrior = new Warrior("Conan", 100,50, 20);
        warrior.setWeapon(axe);
        warrior.getPlayerInfo();

        IArcherWeapon bow = new Bow("Battle Bow", 70, 10);
        Archer archer = new Archer("Robin", 75,50, 20);
        archer.setWeapon(bow);
        archer.getPlayerInfo();

        IMageWeapon wand = new Wand("Baguette moisie", 45);
        Mage mage = new Mage("Harry", 50, 200, 100);
        mage.setWeapon(wand);
        mage.getPlayerInfo();

        
    }
}
