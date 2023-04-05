import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public abstract class GameData extends Object {
    protected final List<Knight> activeKnights = new ArrayList<>();
    protected final List<Fortune> fortunes = new ArrayList<>();
    protected final List<Knight> knights = new ArrayList<>();
    protected final List<MOB> monsters = new ArrayList<>();

    private static final int MAX_ACTIVE = 4;
    private static final Random random = new Random();

    public List<Knight> getKnights() {
        return this.knights;
    } // End getKnights

    public List<Knight> getActiveKnights() {
        return activeKnights;
    } // End getActiveKnights

    public Knight getActive(String nameOrId) {
        return findKnight(nameOrId, activeKnights);
    } // End getActive

    public Knight getKnight(String nameOrId) {
        if (getKnights() != null) {
            return findKnight(nameOrId.toLowerCase(), knights);
        }
        return null;
    } // End getKnights

    protected Knight findKnight(String nameOrId, List<Knight> list) {
        nameOrId = nameOrId.toLowerCase();

        for (Knight knight : list) {
            if (knight.getName().toLowerCase().contains(nameOrId) || knight.getId().toString().contains(nameOrId)) {
                return knight;
            }
        }
        return null;
    } // End findKnight

    public boolean setActive(Knight knight) {
        if (activeKnights.size() < MAX_ACTIVE) {
            activeKnights.add(knight);
            return true;
        } else if (activeKnights.size() > MAX_ACTIVE) {
            return false;
        }
        return false;

    } // End setActive

    public void removeActive(Knight knight) {
       if(activeKnights.remove(knight) == true) {
            knight.resetDamage();
       }
    } // End removeActive

    public Fortune getRandomFortune() {
        return fortunes.get(random.nextInt(fortunes.size()));
    } // End getRandomFortune

    public List<MOB> getRandomMonsters() {
        return getRandomMonsters(random.nextInt(activeKnights.size() - 1));
    } // End getRandomMonsters

    public List<MOB> getRandomMonsters(int number) {
        List<MOB> randomMonster = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            randomMonster.add(monsters.get(random.nextInt(monsters.size())).copy());
        }
        return randomMonster;
    } // End getRandomMonsters w/ Integer parameter

    public abstract void save(String fileName); // End save

} // End GameData class