package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.*;
import game.actions.PurchaseAction;
import game.GameMapFactory;
import game.actions.TravelAction;
import game.scraps.specialscraps.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the computer terminal that sells items.
 */
public class ComputerTerminal extends Ground {

    private List<GameMapFactory> travelMapFactories = new ArrayList<>();

    /**
     * Constructor of the ComputerTerminal class.
     */
    public ComputerTerminal() {
        super('=');
    }

    /**
     * Add all purchasable items available in the computer terminal into a list
     *
     * @return a list containing all purchasable items found in the computer terminal
     */
    public List<Purchasable> allowablePurchasedItems() {
        List<Purchasable> purchasedItems = new ArrayList<>();
        purchasedItems.add(new EnergyDrink());
        purchasedItems.add(new DragonSlayerReplica());
        purchasedItems.add(new ToiletPaperRoll());
        purchasedItems.add(new Theseus());
        purchasedItems.add(new Astley());
        return purchasedItems;
    }

    /**
     * Add the travelable map factory to list stored in the computer terminal.
     *
     * @param mapFactory a GameMapFactory that can be travel to.
     */
    public void addTravelMap(GameMapFactory mapFactory) {
        travelMapFactories.add(mapFactory);
    }

    /**
     * Allow actor to perform actions when interacts with the computer terminal.
     *
     * @param actor     the actor who going to purchase item in the computer terminal
     * @param location  the current Location
     * @param direction the direction of the computer terminal from the actor
     * @return a list of actions that can be performed by the actor
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        for (Purchasable purchasedItem : this.allowablePurchasedItems()) {
            actions.add(new PurchaseAction(purchasedItem));
        }

        for (GameMapFactory mapFactory : travelMapFactories) {
            if (location.map() != mapFactory.getMap()){
                Location newLocation = mapFactory.getMap().at(mapFactory.getTravelXLocation(), mapFactory.getTravelYLocation());
                actions.add(new TravelAction(newLocation, "to " + mapFactory.getMapName()));
            }
        }
        return actions;
    }

}
