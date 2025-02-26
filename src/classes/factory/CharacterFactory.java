package classes.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import classes.combatClass.Archer;
import classes.combatClass.Mage;
import classes.combatClass.PlayableCharacter;
import classes.combatClass.Warrior;
import enums.CharacterClass;

public class CharacterFactory {
    private static final Map<CharacterClass, Supplier<PlayableCharacter>> characterMap = new HashMap<>();

    static {
        characterMap.put(CharacterClass.WARRIOR, () -> new Warrior("Bob", 100, 50, 20));
        characterMap.put(CharacterClass.ARCHER,
                () -> new Archer("Bob", CharacterClass.ARCHER, 100, 100, 100));
        characterMap.put(CharacterClass.MAGE, () -> new Mage("Bob", 100, 50, 200));
    }

    public static PlayableCharacter createCharacter(CharacterClass characterClass, String name) {
        PlayableCharacter character = characterMap.get(characterClass).get();
        character.setName(name);
        return character;
    }
}