package game.plantactions;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.Utility;
import game.scraps.specialscraps.fruits.FruitFactory;

import java.util.List;

/**
 * Class that represents the action of a plant dropping fruit
 */
public class DropFruitAction implements PlantAction{

    private FruitFactory fruitFactory;

    /**
     * Initialising a DropFruitAction with the necessary parameters
     *
     * @param fruitFactory The fruit factory that creates a new fruit instance
     */
    public DropFruitAction(FruitFactory fruitFactory){
        this.fruitFactory = fruitFactory;
    }

    /**
     * Method that executes the drop fruit action for the plant
     *
     * @param location The location where dropping of fruit should be executed
     * @return boolean that represents whether the dropping of fruit action has been successful
     */
    @Override
    public boolean executeAction(Location location){
        List<Exit> exits = location.getExits();
        Location destination = exits.get(Utility.generateRandomInt(0, exits.size())).getDestination();
        return fruitFactory.drop(destination);
    }

}
