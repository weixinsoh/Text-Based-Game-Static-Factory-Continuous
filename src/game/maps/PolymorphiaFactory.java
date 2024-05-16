package game.maps;

import edu.monash.fit2099.engine.positions.NumberRange;

import java.util.Arrays;
import java.util.List;

public class PolymorphiaFactory extends GameMapFactory {
    private static List<String> mapString = Arrays.asList(
                                    "...~~~~.........~~~...........",
                                    "...~~~~.......................",
                                    "...~~~........................",
                                    "..............................",
                                    ".............#####............",
                                    ".............#___#...........~",
                                    "........t....#___#..........~~",
                                    ".............##_##.........~~~",
                                    ".................~~........~~~",
                                    "................~~~~.......~~~",
                                    ".............~~~~~~~........~~",
                                    "......~.....~~~~~~~~.........~",
                                    ".....~~~...~~~~~~~~~..........",
                                    ".....~~~~~~~~~~~~~~~~........~",
                                    ".....~~~~~~~~~~~~~~~~~~~....~~");

    public PolymorphiaFactory() {
        super(mapString, "Polymorphia", 15, 5);
    }
}
