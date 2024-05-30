package game.plantactions;

import edu.monash.fit2099.engine.positions.Location;

/**
 * Interface representing possible actions that can be taken by plants each tick
 */
public interface PlantAction {

    /**
     * Method that executes a plant action
     *
     * @param location The location where the plant action should be executed
     * @return boolean that represents whether the execution of the plant action has been successful
     */
    boolean executeAction(Location location);
}
