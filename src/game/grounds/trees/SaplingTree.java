package game.grounds.trees;

import game.plantactions.DropFruitAction;
import game.plantactions.GrowAction;
import game.scraps.specialscraps.fruits.SmallFruitFactory;

/**
 * Class that represents a Sapling tree, the second stage of growth for an Inheritree
 */
public class SaplingTree extends Inheritree{
    private static final int SAPLING_TICK_TO_NEXT_STAGE = 6;
    private static final int SAPLING_GROW_ACTION_PRIORITY = 0;
    private static final int SAPLING_DROP_FRUIT_ACTION_PRIORITY = 999;

    /**
     * Initialisation method for a Sapling Tree
     * A GrowAction with YoungTree as the next stage is added
     * A drop fruit action is added with SmallFruitFactory is added
     */
    public SaplingTree(){
        super('t');
        this.addPlantAction(SAPLING_GROW_ACTION_PRIORITY, new GrowAction(new YoungTree(), SAPLING_TICK_TO_NEXT_STAGE));
        this.addPlantAction(SAPLING_DROP_FRUIT_ACTION_PRIORITY, new DropFruitAction(new SmallFruitFactory()));
    }
}
