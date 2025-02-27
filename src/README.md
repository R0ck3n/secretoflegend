# SECRET OF LEGEND

## Description
Ce projet est une simulation de combat RPG entre deux personnages. Chaque joueur peut choisir une classe et une arme, puis s'affronter jusqu'à ce que l'un des deux soit vaincu.

---

## Structure du Projet
Le projet est organisé en plusieurs packages :
- **`classes.game`** : Contient le gestionnaire du jeu (`GameManager`)
- **`classes.factory`** : Contient les **Factories** pour la création des personnages et des armes
- **`classes.combatClass`** : Contient les classes jouables (`Warrior`, `Archer`, `Mage`)
- **`classes.weapons`** : Contient les différentes armes utilisables par les personnages
- **`enums`** : Définit les types de personnages et d'armes
- **`interfaces`** : Définit les interfaces des attaques et des armes

---

## Design Patterns Utilisés
Ce projet implémente deux **Design Patterns** majeurs :

### 1. **Le Singleton pour GameManager**
Le **GameManager** est la classe responsable du déroulement du jeu. Afin de garantir qu'il n'existe qu'une seule instance active, nous avons implémenté le pattern **Singleton**.

#### **Pourquoi utiliser un Singleton ?**
- **Éviter la duplication de gestion du jeu** : Un seul objet contrôle l'ensemble du déroulement
- **Faciliter l'accès global** : La même instance est utilisée partout
- **Économie de ressources** : Pas besoin de recréer l'objet à chaque fois

#### **Implémentation du Singleton dans `GameManager`**
```java
public class GameManager {
    private static GameManager instance; // Instance unique
    private static final Scanner scanner = new Scanner(System.in);

    // Constructeur privé pour empêcher l'instanciation directe
    private GameManager() {}

    // Méthode pour récupérer l'unique instance
    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void startGame() {
        // Lancement du jeu...
    }
}
```

#### **Utilisation dans `Main`**
```java
public class Main {
    public static void main(String[] args) {
        GameManager.getInstance().startGame();
    }
}
```

Grâce à cette approche, `GameManager` ne peut être instancié qu'une seule fois et est accessible globalement.

---

### 2. **Le Factory Pattern pour la création des personnages et des armes**
Nous utilisons le **Factory Pattern** pour encapsuler la logique de création des personnages et des armes.

#### **Pourquoi utiliser une Factory ?**
- **Séparation des responsabilités** : La création des objets est centralisée dans une classe dédiée
- **Facilité de modification** : Ajouter un nouveau type de personnage ou d'arme ne nécessite pas de modification du code existant
- **Réduction de la complexité** : L'instanciation est abstraite et ne dépend pas du code qui en fait usage

#### **Implémentation de `CharacterFactory`**
```java
public class CharacterFactory {
    private static final Map<CharacterClass, BiFunction<String, CharacterClass, PlayableCharacter>> characterMap = new HashMap<>();

    static {
        characterMap.put(CharacterClass.WARRIOR, (name, characterClass) -> new Warrior(name, 1000, 50, 20));
        characterMap.put(CharacterClass.ARCHER, (name, characterClass) -> new Archer(name, characterClass, 1000, 100, 100));
        characterMap.put(CharacterClass.MAGE, (name, characterClass) -> new Mage(name, 1000, 50, 200));
    }

    public static PlayableCharacter createCharacter(CharacterClass characterClass, String name) {
        return characterMap.get(characterClass).apply(name, characterClass);
    }
}
```

#### **Implémentation de `WeaponFactory`**
```java
public class WeaponFactory {
    public static IWeapon createWeapon(WeaponType weaponType) {
        switch (weaponType) {
            case AXE:
                return new Axe("Big Axe", 100);
            case SWORD:
                return new Sword("Big Sword", 100);
            case BOW:
                return new Bow("Basic Bow", 50);
            case CROSSBOW:
                return new Crossbow("Basic Crossbow", 70);
            case WAND:
                return new Wand("Basic Wand", 100);
            case STAFF:
                return new Staff("Basic Staff", 110);
            default:
                throw new IllegalArgumentException("Invalid weapon type");
        }
    }
}
```

#### **Utilisation dans `GameManager`**
Lorsqu'un joueur choisit un personnage et une arme, nous utilisons ces **Factories** :
```java
PlayableCharacter player = CharacterFactory.createCharacter(chosenClass, charName);
player.setWeapon(WeaponFactory.createWeapon(weaponChoice));
```
Ainsi, le code est **modulaire** et **extensible** !

---

## Conclusion
Dans ce projet :
- Le **Singleton** assure une gestion unique du jeu via `GameManager`
- Le **Factory Pattern** facilite la création des personnages et des armes

Ces deux **Design Patterns** permettent un **code plus propre, réutilisable et évolutif** ! 🚀