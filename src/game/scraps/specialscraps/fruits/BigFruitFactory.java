package game.scraps.specialscraps.fruits;

import edu.monash.fit2099.engine.positions.Location;

/**
 * Class that represents a Big Fruit Factory used to create new Big fruit instances in the map
 */
public class BigFruitFactory implements FruitFactory{

    private static final double BIG_FRUIT_DROP_PROBABILITY = 0.2;

    /**
     * The method that spawns a new Big Fruit with a specific probability
     *
     * @param location Location that the Big Fruit can be dropped
     */
    @Override
    public boolean drop(Location location) {
        if (Math.random() <= BIG_FRUIT_DROP_PROBABILITY) {
            BigFruit bigFruit = new BigFruit();
            location.addItem(bigFruit);
            return true;
        }
        return false;
    }
}
