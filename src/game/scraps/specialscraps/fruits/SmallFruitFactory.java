package game.scraps.specialscraps.fruits;

import edu.monash.fit2099.engine.positions.Location;

public class SmallFruitFactory implements FruitFactory{
    private static final double SMALL_FRUIT_DROP_PROBABILITY = 0.3;

    /**
     * The method that spawns a new Big Fruit with a specific probability
     *
     * @param location Location that the Big Fruit can be dropped
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
