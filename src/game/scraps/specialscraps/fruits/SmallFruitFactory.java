package game.scraps.specialscraps.fruits;

import edu.monash.fit2099.engine.positions.Location;

/**
 * Class that represents a Small Fruit Factory used to create new small fruit instances in the map
 */
public class SmallFruitFactory implements FruitFactory{
    private static final double SMALL_FRUIT_DROP_PROBABILITY = 0.3;

    /**
     * The method that spawns a new Small Fruit with a specific probability
     *
     * @param location Location that the Small Fruit can be dropped
     */
    @Override
    public boolean drop(Location location) {
        if (Math.random() <= SMALL_FRUIT_DROP_PROBABILITY) {
            SmallFruit smallFruit = new SmallFruit();
            location.addItem(smallFruit);
            return true;
        }
        return false;
    }
}
