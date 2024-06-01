package game;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.GroundFactory;

import java.util.List;

/**
 * Class representing the GameMapFactory that manage the map name, map string, and teleport location through computer terminal.
 */
public class GameMapFactory {
    private List<String> mapString;
    private String mapName;
    private GameMap map;
    private int travelXLocation;
    private int travelYLocation;

    /**
     * Constructor for the GameMapFactory.
     *
     * @param mapString A string representing the structure of the map.
     * @param mapName A string representing the name of the map.
     * @param travelXLocation An integer representing the x position of the teleport location through computer terminal.
     * @param travelYLocation An integer representing the y position of the teleport location through computer terminal.
     */
    public GameMapFactory(List<String> mapString, String mapName, int travelXLocation, int travelYLocation) {
        this.mapString = mapString;
        this.mapName = mapName;
        this.travelXLocation = travelXLocation;
        this.travelYLocation = travelYLocation;
    }

    /**
     * Setter to create the GameMap for the map.
     *
     * @param groundFactory the ground factory used to construct the map.
     */
    public void setMap(GroundFactory groundFactory) {
        map = new GameMap(groundFactory, mapString);
    }

    /**
     * Getter to retrieve the GameMap of the map.
     *
     * @return a GameMap of the map.
     */
    public GameMap getMap(){
        return map;
    }

    /**
     * Getter to retrieve the map name.
     *
     * @return a string representing the map name.
     */
    public String getMapName() {
        return mapName;
    }

    /**
     * Getter to retrieve the x position of the teleport location through computer terminal.
     *
     * @return an integer representing the x position of the teleport location.
     */
    public int getTravelXLocation() {
        return travelXLocation;
    }

    /**
     * Getter to retrieve the y position of the teleport location through computer terminal.
     *
     * @return an integer representing the y position of the teleport location.
     */
    public int getTravelYLocation() {
        return travelYLocation;
    }
}
