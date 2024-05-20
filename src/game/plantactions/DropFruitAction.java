package game.plantactions;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.Utility;

import java.util.List;

public class DropFruitAction implements PlantAction{

    private double droppingProbability;
    private Item fruitToDrop;

    public DropFruitAction(double droppingProbability, Item fruitToDrop){
        this.droppingProbability = droppingProbability;
        this.fruitToDrop = fruitToDrop;
    }

    @Override
    public boolean executeAction(Location location){
        List<Exit> exits = location.getExits();
        Location destination = exits.get(Utility.generateRandomInt(0, exits.size())).getDestination();
        if(Math.random() <= droppingProbability){
            destination.addItem(fruitToDrop);
            return true;
        }
        return false;
    }

}
