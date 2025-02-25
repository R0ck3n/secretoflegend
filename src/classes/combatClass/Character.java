package classes.combatClass;

abstract class Character {
    protected String name;

    protected Character(String _name) {

        setName(_name);
    }

    abstract String getName();

    abstract void setName(String name);
}
