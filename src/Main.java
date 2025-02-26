import classes.Utils;
import classes.combatClass.Archer;
import classes.combatClass.Mage;
import classes.combatClass.PlayableCharacter;
import classes.combatClass.Warrior;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.displayTitle();
        int turn = 0;

        System.out.println("CREATION DU PREMIER PERSONNAGE");
        PlayableCharacter player1 = PlayableCharacter.playerCreation();
        System.out.println("CREATION DU SECOND PERSONNAGE");
        PlayableCharacter player2 = PlayableCharacter.playerCreation();
        player1.getPlayerInfo();
        player2.getPlayerInfo();

    }
}
