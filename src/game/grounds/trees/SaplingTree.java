package game.grounds.trees;

import game.plantactions.DropFruitAction;
import game.plantactions.GrowAction;
import game.scraps.specialscraps.fruits.SmallFruit;

public class SaplingTree extends Inheritree{
    private static final double SAPLING_FRUIT_DROPPING_PROBABILITY = 0.2;
    private static final int SAPLING_TICK_TO_NEXT_STAGE = 6;
    private static final int SAPLING_GROW_ACTION_PRIORITY = 0;
    private static final int SAPLING_DROP_FRUIT_ACTION_PRIORITY = 999;


    public SaplingTree(){
        super('t');
        this.addPlantAction(SAPLING_GROW_ACTION_PRIORITY, new GrowAction(new YoungTree(), SAPLING_TICK_TO_NEXT_STAGE));
        this.addPlantAction(SAPLING_DROP_FRUIT_ACTION_PRIORITY, new DropFruitAction(SAPLING_FRUIT_DROPPING_PROBABILITY, new SmallFruit()));
    }
}
