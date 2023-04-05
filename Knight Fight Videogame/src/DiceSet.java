import java.util.Random;

public class DiceSet {
    private Random rnd = new Random();

    public int roll(DiceType diceType) {
        int myval = 0;
        switch(diceType) {
        case D4:
            myval = rnd.nextInt(4) + 1;
        break;
        case D6:
            myval = rnd.nextInt(6) + 1;
        break;
        case D8:
            myval = rnd.nextInt(8) + 1;
        break;
        case D10:
            myval = rnd.nextInt(10) + 1;
        break;
        case D12:
            myval = rnd.nextInt(12) +1;
        break;
        case D20:
            myval = rnd.nextInt(20) + 1;
        break;

        } // End switch case

        return myval;
    } // End roll
       
} // End DiceSet class
