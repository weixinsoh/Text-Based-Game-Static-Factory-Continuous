package game.grounds.trees;

import game.plantactions.DropFruitAction;
import game.scraps.specialscraps.fruits.BigFruitFactory;

/**
 * Class that represents a Mature tree, the final stage of growth for an Inheritree
 */
public class MatureTree extends Inheritree {

    private static final int MATURE_DROP_FRUIT_ACTION_PRIORITY = 999;

    /**
     * Initialisation method for a Mature Tree
     * A drop fruit action is added with BigFruitFactory is added
     */
    public MatureTree(){
        super('T');
        this.addPlantAction(MATURE_DROP_FRUIT_ACTION_PRIORITY, new DropFruitAction(new BigFruitFactory()));
    }
}
