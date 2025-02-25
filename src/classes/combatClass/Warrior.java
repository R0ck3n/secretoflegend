package classes.combatClass;

public class Warrior extends Character {
        public Warrior(String _name) {
            super(_name);
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
