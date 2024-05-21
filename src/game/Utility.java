package game;
import java.util.Random;

public class Utility {
    /**
     * This function is used to generate random integer in a given range.
     * @param lower the lower bound
     * @param upper the upper bound
     */
    public static int generateRandomInt(int lower, int upper) {
        return lower + new Random().nextInt(upper-lower);
    }
}
