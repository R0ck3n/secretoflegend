import classes.Utils;
import classes.combatClass.Archer;
import classes.combatClass.Mage;
import classes.combatClass.PlayableCharacter;
import classes.combatClass.Warrior;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Utils utils = new Utils();
        PlayableCharacter player1 = null;
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


        switch (classeChoice) {
            case 1:
                player1 = new Warrior(charName, 100,50, 20);
                break;
            case 2:
                player1 = new Archer(charName, 75,50, 20);
                break;
            case 3:
                 player1 = new Mage(charName, 50, 200, 100);
                 break;
            default:
                  System.out.println("mauvais choix de classe");
                  System.exit(0);
                  break;
        }

        if (player1 != null) {
            player1.getPlayerInfo();
        }




        intScanner.close();
    strScanner.close();



    }
}
