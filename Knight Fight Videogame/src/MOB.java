public class MOB extends Object implements Attributes {
    protected int armor;
    protected int damage;
    protected DiceType damageDie;
    protected int hitModifier;
    protected int maxHP;
    private final String name;

    public MOB(String name, int hp, int armor, int hitModifier, DiceType damageDie) {
        this.name = name;
        this.maxHP = hp;
        this.armor = armor;
        this.hitModifier = hitModifier;
        this.damageDie = damageDie;
    } // End MOB constructor

    @Override
    public int getHitModifier() {
        return hitModifier;
    }

    @Override
    public int getArmor() { 
        return armor;
    }

    @Override
    public int getMaxHP() {
        return maxHP;
    }

    public int getDamage() {
        return maxHP - (maxHP - damage);
    }

    public String getName() {
        return name;
    }

    public void addDamage(int damage) {
        this.damage += damage;
    }

    public int getHP() {
        return this.getMaxHP() - this.getDamage();
    }

    public void resetDamage() {
        damage = 0;
    }

    @Override
    public DiceType getDamageDie() {
        return this.damageDie;
    }

    public String toString() {
        return "+============================+\n" +
                String.format("| %-27s|%n", getName()) +
                "|                            |\n" +
                String.format("|         Health: %-10d |%n", getHP())  +
                String.format("|  Power: %-6s  Armor: %-4d|%n", getDamageDie().toString(), getArmor()) +
                "|                            |\n" +
                "+============================+";
    }

    public MOB copy() {
        MOB newMob = new MOB(this.getName(), this.getMaxHP(), this.getArmor(), this.getHitModifier(), this.getDamageDie());
        return newMob;
    }

} // End MOB class
