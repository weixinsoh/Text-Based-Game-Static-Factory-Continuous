package game.grounds.trees;

import game.plantactions.GrowAction;

/**
 * Class that represents a Young tree, the third stage of growth for an Inheritree
 */
public class YoungTree extends Inheritree{

    private static final int YOUNG_TICK_TO_NEXT_STAGE = 5;
    private static final int YOUNG_GROW_ACTION_PRIORITY = 0;

    /**
     * Initialisation method for a Young Tree
     * A GrowAction with MatureTree as the next stage is added
     */
    public YoungTree(){
        super('y');
        this.addPlantAction(YOUNG_GROW_ACTION_PRIORITY, new GrowAction(new MatureTree(), YOUNG_TICK_TO_NEXT_STAGE));
    }
}
