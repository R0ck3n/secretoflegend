package classes.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import classes.combatClass.Archer;
import classes.combatClass.Mage;
import classes.combatClass.PlayableCharacter;
import classes.combatClass.Warrior;
import enums.CharacterClass;

public class CharacterFactory {
    private static final Map<CharacterClass, BiFunction<String, CharacterClass, PlayableCharacter>> characterMap = new HashMap<>();

    static {
        characterMap.put(CharacterClass.WARRIOR, (name, characterClass) -> new Warrior(name, 100, 50, 20));
        characterMap.put(CharacterClass.ARCHER, (name, characterClass) -> new Archer(name, characterClass, 100, 100, 100));
        characterMap.put(CharacterClass.MAGE, (name, characterClass) -> new Mage(name, 100, 50, 200));
    }

    public static PlayableCharacter createCharacter(CharacterClass characterClass, String name) {
        return characterMap.get(characterClass).apply(name, characterClass);
    }
}
