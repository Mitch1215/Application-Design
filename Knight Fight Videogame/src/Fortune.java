public class Fortune implements Attributes {
    private final int armor;
    private final DiceType dtype;
    private final int hitModifier;
    private final int hpBonus;
    private final String name;

    public Fortune(String name, int hpBonus, int armor, int hitModifier) {
        this.name = name;
        this.hpBonus = hpBonus;
        this.armor = armor;
        this.hitModifier = hitModifier;
        this.dtype = null;
    } // End basic Fortune constructor

    public Fortune(String name, int hpBonus, int armor, int hitModifier, DiceType type) {
        this.name = name;
        this.hpBonus = hpBonus;
        this.armor = armor;
        this.hitModifier = hitModifier;
        this.dtype = type;
       
    } // End DiceType Fortune constructor

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public int getMaxHP() {
        return hpBonus;
    }

    @Override
    public DiceType getDamageDie() {
        return dtype;
    }

    @Override
    public int getHitModifier() {
        return hitModifier;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        String firstString;
        String name;
        String HP;
        String AC;
        String hitBonus;
        String damageAdj;

        firstString = "+======================+\n";
        name = String.format("|%-22s|\n", getName());
        HP = String.format("|HP Bonus: %12s|\n", "+" + getMaxHP());
        AC = String.format("|AC Bonus: %12s|\n", "+" + getArmor());
        hitBonus = String.format("|Hit Bonus: %11s|\n", "+" + getHitModifier());
        
        if (getDamageDie() != null) {
            damageAdj = String.format("|Damage Adj: %10s|\n", getDamageDie());
        } else {
            damageAdj = String.format("|Damage Adj: %10s|\n", "-");
        }

        return firstString + name + HP + AC + hitBonus + damageAdj + firstString;
    }
    
} // End Fortune
