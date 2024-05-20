package game.grounds.trees;


import game.plantactions.DropFruitAction;
import game.scraps.specialscraps.fruits.BigFruit;

public class MatureTree extends Inheritree {

    private static final double MATURE_FRUIT_DROPPING_PROBABILITY = 0.3;

    private static final int MATURE_DROP_FRUIT_ACTION_PRIORITY = 999;

    public MatureTree(){
        super('T');
        this.addPlantAction(MATURE_DROP_FRUIT_ACTION_PRIORITY, new DropFruitAction(MATURE_FRUIT_DROPPING_PROBABILITY, new BigFruit()));
    }
}
