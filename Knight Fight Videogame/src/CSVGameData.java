import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CSVGameData extends GameData {

    public CSVGameData(String gameData, String saveData) {
        loadGameData(gameData);
        loadSaveData(saveData);
        System.gc();
    } // End CVSGameData constructor

    private void loadSaveData(String saveData) {
        int counter = 0;
        Scanner file = readFile(saveData);
        if(file == null) {
            return;
        }

        while(file.hasNextLine()) {
            Scanner line = new Scanner(file.nextLine());
            line.useDelimiter(","); 
            Knight kt = new Knight(++counter, line.next().trim(), line.nextInt(), line.nextInt(), line.nextInt(), DiceType.valueOf(line.next()), line.nextInt());

            knights.add(kt);
        } // End while loop
    } // End loadSaveData

    private Scanner readFile(String fileName) {
        Scanner readFile = null;
        try { 
        readFile = new Scanner(new FileInputStream(fileName)); 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return readFile;

    } // End readFile

    private void loadGameData(String gameData) {
        Scanner loadGame = readFile(gameData);
       
        while (loadGame.hasNext()) {
            Scanner readLoadGame = new Scanner(loadGame.nextLine());
            String [] line = readLoadGame.nextLine().split(",");

            if (line[0].contains("MOB")) {
                MOB newMonster = new MOB(line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4]), DiceType.valueOf(line[5]));
                monsters.add(newMonster);
            } else if (line[0].contains("FORTUNE")) {
                if (line[5].equals("-")) {
                    Fortune newFortune = new Fortune(line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4]));
                    fortunes.add(newFortune);
                } else if (!line[5].equals("-")) {
                    Fortune newFortune = new Fortune(line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4]), DiceType.valueOf(line[5]));
                    fortunes.add(newFortune);
                }
            } // End if-else statement
        } // End while loop
    } // End loadGameData

    @Override
    public void save(String fileName) {
        try (FileWriter saveGame = new FileWriter(fileName)) {
            saveGame.write(fileName.toString());
            saveGame.close();
            System.out.println("Game saved at file location " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving file");
            e.printStackTrace();
        } // End try/catch block
        
    } // End save
    
} // End CVSGameData class
