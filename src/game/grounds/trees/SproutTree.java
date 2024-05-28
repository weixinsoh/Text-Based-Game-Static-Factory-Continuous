package game.grounds.trees;

import game.plantactions.GrowAction;

/**
 * Class that represents a Sprout tree, the initial stage of growth for an Inheritree
 */
public class SproutTree extends Inheritree{
    private static final int SPROUT_TICK_TO_NEXT_STAGE = 3;
    private static final int SPROUT_GROW_ACTION_PRIORITY = 0;

    /**
     * Initialisation method for a Sprout Tree
     * A GrowAction with SaplingTree as the next stage is added
     */
    public SproutTree(){
        super(',');
        this.addPlantAction(SPROUT_GROW_ACTION_PRIORITY, new GrowAction(new SaplingTree(), SPROUT_TICK_TO_NEXT_STAGE));
    }
}
