package game.grounds.trees;

import game.plantactions.GrowAction;

public class SproutTree extends Inheritree{
    private static final int SPROUT_TICK_TO_NEXT_STAGE = 3;
    private static final int SPROUT_GROW_ACTION_PRIORITY = 0;

    public SproutTree(){
        super(',');
        this.addPlantAction(SPROUT_GROW_ACTION_PRIORITY, new GrowAction(new SaplingTree(), SPROUT_TICK_TO_NEXT_STAGE));
    }
}
