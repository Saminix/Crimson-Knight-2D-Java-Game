package game;

import java.io.*;


public class GameSaverLoader {
    public static void save(GameLevel level, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(level.getLevelName() + "," + level.getWarriorStats());
        }
    }

    public static GameLevel load(Game game, String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            String[] data = line.split(",");
            String levelName = data[0];
            String warriorStats = data[1];

            GameLevel loadedLevel = null;
            if (levelName.equals("Level1")) {
                loadedLevel = new Level1(game, warriorStats);
            } else if (levelName.equals("Level2")) {
                loadedLevel = new Level2(game, warriorStats);
            }else if (levelName.equals("Level3")) {
                loadedLevel = new Level2(game, warriorStats);
            }else if (levelName.equals("Level4")) {
                loadedLevel = new Level2(game, warriorStats);
            }

            return loadedLevel;
        }
    }
}