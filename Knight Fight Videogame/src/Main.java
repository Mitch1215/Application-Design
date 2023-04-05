public class Main extends Object {
    private static String gameData = "gamedata.csv";
    private static String saveData = "knights.csv";

    private static void processArgs(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if(args[i].contains("data")) {
                String tempStr = args[i];
                gameData = tempStr.substring(tempStr.indexOf("=") + 1);
            } else {
                saveData = args[i];
            }
        } // End for-loop

    } // End processArgs
    public static void main (String[] args) {
        processArgs(args); // method that parses the args, optional but cleaned up the code
        GameData data = new CSVGameData(gameData, saveData);
        GameView view  = new ConsoleView();
        CombatEngine engine = new CombatEngine(data, view);
        GameController controller = new GameController(data, view, engine);
        controller.start();

    } // End main method
} // End Main class
