package game.grounds.trees;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.plantactions.PlantAction;

import java.util.Map;
import java.util.TreeMap;

/**
 * Abstract class Inheritree that represents a tree
 */
public abstract class Inheritree extends Ground {
    private Map<Integer, PlantAction> plantActions = new TreeMap<>();

    /**
     * Constructor of the Inheritree class.
     *
     * @param displayChar the character that will represent the Inheritree in the display
     */
    public Inheritree(char displayChar) {
        super(displayChar);

    }

    /**
     * Add a behaviour to the TreeMap behaviours with given key.
     *
     * @param key An integer to indicate the priority of the behaviour.
     * @param plantAction The plantBehaviour to add to.
     */
    public void addPlantAction(int key, PlantAction plantAction) {
        plantActions.put(key, plantAction);
    }

    /**
     * At each turn, select a valid action to perform.
     * Overrides Actor.playTurn(ActionList, Action, GameMap, Display)
     *
     * @see Ground#tick(Location) 
     * @param location Location
     */
    @Override
    public void tick(Location location){
        for(PlantAction plantAction: plantActions.values()){
            if(plantAction.executeAction(location)){
                return;
            }
        }
    }

    /**
     * Set Inheritree to block thrown objects.
     * Overrides Ground.blocksThrownObjects()
     *
     * @see Ground#blocksThrownObjects()
     * @return true indicating thrown objects will be blocked.
     */
    @Override
    public boolean blocksThrownObjects() {
        return true;
    }

}
