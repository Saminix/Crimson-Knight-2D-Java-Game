package game;

import java.io.*;

/**
 * A utility class for saving and loading game levels.
 */
public class GameSaverLoader {

    /**
     * Saves the specified game level to a file.
     *
     * @param level    The game level to save.
     * @param fileName The name of the file to save the level to.
     * @throws IOException If an I/O error occurs while saving the level.
     */
    public static void save(GameLevel level, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(level.getLevelName() + "," + level.getPlayerStats());
        }
    }

    /**
     * Loads a game level from a file.
     *
     * @param game     The Game instance associated with the level.
     * @param fileName The name of the file containing the level data.
     * @return The loaded GameLevel object.
     * @throws IOException If an I/O error occurs while loading the level.
     */
    public static GameLevel load(Game game, String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            String[] data = line.split(",");
            String levelName = data[0];
            String playerStats = data[1]; // Assuming player stats are stored in the save file

            // Create the appropriate level based on the level name
            return createLevel(game, levelName, playerStats);
        }
    }

    /**
     * Creates a specific level based on the provided Game instance, level name, and player stats.
     *
     * @param game        The Game instance associated with the level.
     * @param levelName   The name of the level to create.
     * @param playerStats The player statistics for the level.
     * @return A GameLevel object representing the specified level.
     */
    private static GameLevel createLevel(Game game, String levelName, String playerStats) {
        switch (levelName) {
            case "Level1":
                return new Level1(game, playerStats);
            case "Level2":
                return new Level2(game, playerStats);
            case "Level3":
                return new Level3(game, playerStats);
            case "Level4":
                return new Level4(game, playerStats);
            default:
                // Handle unknown level name or return a default level
                return null;
        }
    }
}
