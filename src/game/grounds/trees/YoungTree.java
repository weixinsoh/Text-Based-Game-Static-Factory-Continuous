package game.grounds.trees;

import game.plantactions.GrowAction;

public class YoungTree extends Inheritree{

    private static final int YOUNG_TICK_TO_NEXT_STAGE = 5;
    private static final int YOUNG_GROW_ACTION_PRIORITY = 0;
    public YoungTree(){
        super('y');
        this.addPlantAction(YOUNG_GROW_ACTION_PRIORITY, new GrowAction(new MatureTree(), YOUNG_TICK_TO_NEXT_STAGE));
    }
}
