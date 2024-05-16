package game.maps;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.GroundFactory;
import edu.monash.fit2099.engine.positions.NumberRange;

import java.util.List;

public class GameMapFactory {
    private List<String> mapString;
    private String mapName;
    private GameMap map;
    private int travelXLocation;
    private int travelYLocation;

    public GameMapFactory(List<String> mapString, String mapName, int travelXLocation, int travelYLocation) {
        this.mapString = mapString;
        this.mapName = mapName;
        this.travelXLocation = travelXLocation;
        this.travelYLocation = travelYLocation;
    }

    public void setMap(GroundFactory groundFactory) {
        map = new GameMap(groundFactory, mapString);
    }

    public GameMap getMap(){
        return map;
    }

    public String getMapName() {
        return mapName;
    }

    public int getTravelXLocation() {
        return travelXLocation;
    }

    public int getTravelYLocation() {
        return travelYLocation;
    }
}
