import java.util.List;

public interface GameView {

    boolean checkContinue();
    
    String displayMainMenu();
    
    void endGame();
    
    void knightNotFound();
    
    void listKnights(List<Knight> knights);

    void printBattleText(List<MOB> monsters, List<Knight> activeKnights);

    void printBattleTest(MOB deadMob);

    void printDefeated();

    void printFortunes(List<Knight> activeKnights);

    void printHelp();

    void setActiveFailed();

    void showKnight(Knight knight);

    void splashScreen();

} // End GameView interface