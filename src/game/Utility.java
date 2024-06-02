package game;
import java.util.Random;


/**
 * Class representing Utility functions such as generating a random Integer
 */
public class Utility {
    /**
     * This function is used to generate random integer in a given range.
     *
     * @param lower the lower bound
     * @param upper the upper bound
     * @return a random integer within the lower range and upper range
     */
    public static int generateRandomInt(int lower, int upper) {
        return lower + new Random().nextInt(upper-lower);
    }
}
