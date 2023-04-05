import java.util.List;
// import java.util.Random;

public class CombatEngine extends Object {
    private final GameData data;
    private final GameView view;
    // private final DiceSet dice = new DiceSet();
    // private final Random rnd = new Random();
   

    public CombatEngine(GameData data, GameView view) {
        this.data = data;
        this.view = view;
    } // End CombatEngine constructor

    public void initialize() {
        for (Knight activeKnights : data.getActiveKnights()) {
            activeKnights.setActiveFortune(data.getRandomFortune());
        } // End for-loop

        view.printFortunes(data.getActiveKnights());
    } // End initialize method

    public void runCombat() {
        System.out.println("not implemented");
    } // End runCombat

    public int doBattle(List<MOB> attackersList, List<MOB> defList) {
        int numVictories = 0;
        return numVictories;
    } // End doBattle

    public void clear() {
        for (Knight knights : data.getKnights()) {
            knights.setActiveFortune(null);
        }
    } // End clear

} // End CombatEngine class
