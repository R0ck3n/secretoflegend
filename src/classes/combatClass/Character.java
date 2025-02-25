package classes.combatClass;

abstract class Character {
    protected String name;

    protected Character(String _name) {

        setName(_name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
