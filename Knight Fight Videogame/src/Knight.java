public class Knight extends MOB {
   
    private Fortune activeFortune;
    protected final int id;
    protected int xp;

    Knight(int id, String name, int hp, int armor, int hitModifier, DiceType damageDie, int xp) {
        super(name, hp, armor, hitModifier, damageDie);
        this.id =id;
        this.xp = xp;
    } // End Knight Constructor

    public int getArmor() {
        int currentArmor = super.getArmor();
        Fortune currentFortune = this.getActiveFortune();

        if (currentFortune != null) {
            currentArmor += currentFortune.getArmor();
 
        }
       
        return currentArmor;
    }

    public int getMaxHP() {
        int currentMaxHP = super.getMaxHP();
        Fortune currentFortune = this.getActiveFortune();

        if (currentFortune != null) {
            currentMaxHP += currentFortune.getMaxHP();
        }

        return currentMaxHP;
    }

    public DiceType getDamageDie() {
        DiceType currentDamageDie = super.getDamageDie();
        Fortune currentFortune = this.getActiveFortune();

        if ((currentFortune != null) && (currentFortune.getDamageDie() != null)) {
            return currentFortune.getDamageDie();
            
        }
        return currentDamageDie;
        
    }

    public int getHitModifier() {
        int currentHitModifier = super.getHitModifier();
        Fortune currentFortune = this.getActiveFortune();

        if (currentFortune != null) {
            currentHitModifier += currentFortune.getHitModifier();
        }
        return currentHitModifier;
    }

    public int getXP() {
        return this.xp;
    }

    public Fortune getActiveFortune() {
        return activeFortune;
    }

    public void setActiveFortune(Fortune activeFortune) {
        this.activeFortune = activeFortune;
    }

    public void addXP(int xp) {
        this.xp += xp;
    }

    public Integer getId() {
        return this.id;
    }

    public String toString() {
        String intro;
        String name;
        String id;
        String space;
        String HealthXp;
        String powerArmour;
        
        intro = "+============================+\n";
        name = String.format("| %-27s|\n", this.getName());
        id = String.format("| id: %-23d|\n", this.getId());
        space = String.format("|%28s|\n", " ");
        HealthXp = String.format("| Health: %-6d ", getHP());
        HealthXp += String.format(" XP: %-7d|\n", this.getXP());
        powerArmour = String.format("|  Power: %-6s  ", this.getDamageDie());
        powerArmour += String.format("Armor: %-4d|\n", this.getArmor());
        
        return intro + name + id + space + HealthXp + powerArmour + space + intro;
    } // End toString

    public String toCSV() {
        return this.getName() + "," + this.getMaxHP() + "," + this.getArmor() + "," + this.getHitModifier() + "," + this.getDamageDie() + "," + this.getXP();
    }

    // public static void main(String[] args) {
    //     Knight Gwain = new Knight(14, "Gwain", 30, 14, 0, DiceType.D8, 0);
    //     Knight Joe = new Knight(72, "Sir Joseph of the South", 50, 25, 10, DiceType.D20, 144);

    //     System.out.println(Gwain.toString());

    //     System.out.println(Joe.toString());
    // }

} //End Knight class

