package game.plantactions;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.Utility;
import game.scraps.specialscraps.fruits.FruitFactory;

import java.util.List;

public class DropFruitAction implements PlantAction{

    private FruitFactory fruitFactory;

    public DropFruitAction(FruitFactory fruitFactory){
        this.fruitFactory = fruitFactory;
    }

    @Override
    public boolean executeAction(Location location){
        List<Exit> exits = location.getExits();
        Location destination = exits.get(Utility.generateRandomInt(0, exits.size())).getDestination();
        return fruitFactory.drop(destination);
    }

}
