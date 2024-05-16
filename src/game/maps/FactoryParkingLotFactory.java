package game.maps;

import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.NumberRange;

import java.util.Arrays;
import java.util.List;

public class FactoryParkingLotFactory extends GameMapFactory {
    private static List<String> MAPSTRING = Arrays.asList(
                                    ".......",
                                    ".#####.",
                                    ".#___#.",
                                    ".#___#.",
                                    ".##_##.",
                                    ".......",
                                    ".......",
                                    ".......",
                                    ".......");

    public FactoryParkingLotFactory() {
        super(MAPSTRING, "factory's parking lot", 2, 3);
    }
}
