import classes.Utils;
import classes.combatClass.Archer;
import classes.combatClass.Mage;
import classes.weapons.Axe;
import classes.combatClass.Warrior;
import classes.weapons.Bow;
import classes.weapons.Wand;
import interfaces.IArcherWeapon;
import interfaces.IMageWeapon;
import interfaces.IWarriorWeapon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Utils utils = new Utils();
        int turn = 0 ;

        utils.displayTitle();
        Scanner intScanner = new Scanner(System.in);
        Scanner strScanner = new Scanner(System.in);

        System.out.println("Sélectionner la classe du  le 1er personnage :");

        System.out.println("1. Guerrier");
        System.out.println("2. Archer");
        System.out.println("3. Mage");
        int classeChoice = intScanner.nextInt();

        System.out.println("Sélectionner le nom du personnage :");
        String charName = strScanner.next();


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



    intScanner.close();
    strScanner.close();



    }
}
