package game.grounds.trees;


import game.plantactions.DropFruitAction;
import game.scraps.specialscraps.fruits.BigFruit;
import game.scraps.specialscraps.fruits.BigFruitFactory;

public class MatureTree extends Inheritree {


    private static final int MATURE_DROP_FRUIT_ACTION_PRIORITY = 999;

    public MatureTree(){
        super('T');
        this.addPlantAction(MATURE_DROP_FRUIT_ACTION_PRIORITY, new DropFruitAction(new BigFruitFactory()));
    }
}
