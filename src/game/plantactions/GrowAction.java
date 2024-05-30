package game.plantactions;

import edu.monash.fit2099.engine.positions.Location;
import game.grounds.trees.Inheritree;

/**
 * Class that represents the action of a plant growing in a single tick
 */
public class GrowAction implements PlantAction {
    private int treeAge;
    private Inheritree nextStage;
    private int tickToNextStage;

    /**
     * Initialising a GrowAction with the necessary parameters
     *
     * @param nextStage The  next stage of growth for the tree
     * @param tickToNextStage Integer representing the amount of ticks required before the tree grows to the nest stage
     */
    public GrowAction(Inheritree nextStage, int tickToNextStage){
        this.treeAge = 0;
        this.nextStage = nextStage;
        this.tickToNextStage = tickToNextStage;
    }

    /**
     * Method that executes the growing action for the plant
     *
     * @param location The location where the growing plant action should be executed
     * @return boolean that represents whether the execution of the growing plant action has been successful
     */
    @Override
    public boolean executeAction(Location location){
        this.treeAge++;
        if (treeAge >= tickToNextStage){
            location.setGround(nextStage);
            return true;
        }
        return false;
    }
}
