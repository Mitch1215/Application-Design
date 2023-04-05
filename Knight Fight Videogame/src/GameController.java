public class GameController extends Object {
    private final GameData data;
    private final CombatEngine engine;
    private final GameView view;

    public GameController(GameData data, GameView view, CombatEngine engine) {
        this.data = data;
        this.view = view;
        this.engine = engine;
    } // End GameController constructor

    public void start() {
        view.splashScreen();
        while(processCommand(view.displayMainMenu().toLowerCase().trim()));
        view.endGame();

    } // End start

    protected boolean processCommand(String command) {
        command = command.toLowerCase();

        if ((command.contains("exit")) || (command.contains("bye"))) {
            return false;
        }
        if ((command.contains("ls")) || (command.contains("list all"))) {
            view.listKnights(data.getKnights());
            return true;
        }
        if ((command.contains("list active"))) {
            view.listKnights(data.getActiveKnights());
            return true;
        }
        if ((command.contains("show"))) {
            processShowKnight(command.substring(command.indexOf("show") + 5).trim());
            return true;
        }
        if ((command.contains("set active"))) {
            processSetActive(command.substring(command.indexOf("active") + 6).trim());
            return true;
        }
        if ((command.contains("remove"))) {
            processRemoveActive(command.substring(command.indexOf("remove") + 6).trim());
            return true;
        }
        if ((command.equalsIgnoreCase("adventure") || command.equalsIgnoreCase("quest") || command.equalsIgnoreCase("explore"))) {
            engine.initialize();
            engine.runCombat();
            engine.clear();
            
            return true;
        } 
        if ((command.equalsIgnoreCase("save"))) {
            data.save("saveData.csv");
            return true;
        } else { 
            view.printHelp();
            return true;
        }

    } // End processCommand

    private void processRemoveActive (String remove) {
        Knight removeKnight = data.getActive(remove);

        if (removeKnight != null) {
            data.removeActive(removeKnight);
        } else {
            view.knightNotFound();
        }
    } // End processRemoveActive
        
    private void processSetActive(String active) {
        Knight setKnight = data.getKnight(active);
        
        if (setKnight != null) {
            data.setActive(setKnight);
        } else if (setKnight == null) {
            view.knightNotFound();
        }
        
    } // End processSetActive

    private void processShowKnight(String nameOrId) {
        Knight showKnight = data.getKnight(nameOrId);

        if (showKnight == null) {
            view.knightNotFound();
        } else {
            view.showKnight(showKnight);
        }
    } // End processShowKnight

} // End GameController class
