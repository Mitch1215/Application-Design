import java.util.List;
import java.util.Scanner;

public class ConsoleView extends Object implements GameView {
    private final Scanner in = new Scanner(System.in);

    public void splashScreen() {
        System.out.println("======== WELCOME ======");
        System.out.println("=  Round Table Games  =");
        System.out.println("=                     =");
        System.out.println("=     Introduces      =");
        System.out.println("=     Knight Fight    =");
        System.out.println("= Quest for the Grail =");
        System.out.println("=                     =");
        System.out.println("=======================");
    } // End splashScreen

    public void endGame() {
        System.out.println("Congratulations! You beat the game!");
    } // End endGame

    public String displayMainMenu() {
        System.out.print("What would you like to do? ");
        System.out.println();
        System.out.println("\tls or list all  - listing the knights");
        System.out.println("\tlist active  - list the active knights knights only");
        System.out.println("\tshow <name> or <id> - show the knight details card");
        System.out.println("\tset active <name> or <id> - set knight as active (note: only 4 knights can be active)");
        System.out.println("\tremove active <name> or <id> - remove a knight from active status (heals knight)"); // FIX ME
        System.out.println("\texplore or adventure or quest - find random monsters to fight"); // FIX ME
        System.out.println("\tsave <filename> - save the game to the file name (default: saveData.csv)");
        System.out.println("\texit or goodbye - to leave the game");
        System.out.println();
        System.out.println("Game rules: You can have four active knights. As long as they are active, they won't heal, but they can gain XP by going on adventures.");
        System.out.println("When you make a knight inactive, they will heal. How many monsters can you defeat before, you have to heal?");
        System.out.println();
        String userInput = in.nextLine();
        return userInput;
    } // End displayMainMenu

    public void printHelp() {
        System.out.println("Unsure what to do, here are some options:");

        System.out.println("\tls or list all  - listing the knights");
        System.out.println("\tlist active  - list the active knights knights only");
        System.out.println("\tshow <name> or <id> - show the knight details card");
        System.out.println("\tset active <name> or <id> - set knight as active (note: only 4 knights can be active)");
        System.out.println("\tremove active <name> or <id> - remove a knight from active status (heals knight)");
        System.out.println("\texplore or adventure or quest - find random monsters to fight");
        System.out.println("\tsave <filename> - save the game to the file name (default: saveData.csv)");
        System.out.println("\texit or goodbye - to leave the game");
        System.out.println();
        System.out.println("Game rules: You can have four active knights. As long as they are active, they won't heal, but they can gain XP by going on adventures.");
        System.out.println("When you make a knight inactive, they will heal. How many monsters can you defeat before, you have to heal?");
        System.out.println();
    } // End printHelp
    
    public void listKnights(List<Knight> knights) {
        for(int i = 0; i < knights.size(); i++) {
            System.out.println(knights.get(i).getId() + ": " + knights.get(i).getName());  
        }
        System.out.println();

        if (knights.size() == 0) {
        System.out.println("No knights to list");
 
        }
    } // End listKnights

    public void knightNotFound() {
        System.out.println("Knight not found!");
    } // End knightNotFound

    public void showKnight(Knight knight) { 
        System.out.println(knight.toString());
        System.out.println();
    } // End showKnight

    public void setActiveFailed() {
        System.out.println("Unable to set active knight. Only four can be active at a time");
        System.out.println();
    } // End setActiveFailed

    public void printBattleText (List<MOB> monsters, List<Knight> activeKnights) {
        String battleText;
        battleText = "Our heroes come across the following monsters. Prepare for battle!\n";
        battleText += String.format("%-27s %s\n", "Knights", "Foes");
        for (int i = 0; i <= activeKnights.size(); i++) {
            for (int j = 0; j <= activeKnights.size(); j++) {
        battleText += String.format("%-27s %s\n", activeKnights.get(i), monsters.get(j)); 
            }
        }

        System.out.print(battleText);

    } // End printBattleText

    public void printBattleText(MOB dead) {
        System.out.println(dead.getName() + " was defeated!");
        System.out.println();
    } // End printBattleText for defeated

    public void printFortunes(List<Knight> activeKnights) {
        String outputStr;
        outputStr = "For this quest, our knights drew the following fortunes!";
        for (int i = 0; i <= activeKnights.size(); i++) {
            outputStr += activeKnights.get(i).getName() + " drew\n";
            if (((Knight) activeKnights).getActiveFortune() != null) {
                outputStr += ((Knight) activeKnights).getActiveFortune().toString();
            } else {
                outputStr += "No fortune";            
            }
        } // End for-loop

        System.out.println(outputStr);
    
    } // End printFortunes

    public boolean checkContinue() {
        System.out.println("Would you like to continue on your quest (y/n)?");
        if (in.nextLine() == "y") {
            return true;
        } else if (in.nextLine() == "n") {
            return false;
        }

        return false;
        
    } // checkContinue

    public void printDefeated() {
        System.out.println("All active knights have been defeated");
        System.out.println();
    } // End printDefeated

    @Override
    public void printBattleTest(MOB deadMob) {
        // TODO Auto-generated method stub
        
    }
    
} // End ConsoleView
