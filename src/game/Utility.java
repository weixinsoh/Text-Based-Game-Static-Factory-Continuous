package game;
import java.util.Random;

public class Utility {
    public static int generateRandomInt(int lower, int upper) {
        return new Random().nextInt(lower, upper);
    }
}
