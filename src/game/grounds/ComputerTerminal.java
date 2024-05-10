package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.PurchaseAction;
import game.scraps.specialscraps.DragonSlayerReplica;
import game.scraps.specialscraps.EnergyDrink;
import game.scraps.specialscraps.ToiletPaperRoll;
import game.scraps.specialscraps.Purchasable;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the computer terminal.
 *
 */
public class ComputerTerminal extends Ground {

    /**
     * Constructor of the ComputerTerminal class.
     *
     */
    public ComputerTerminal() {
        super('=');
    }

    /**
     * Add all purchasable items available in the computer terminal into a list
     * @return a list containing all purchasable items found in the computer terminal
     */
    public List<Purchasable> allowablePurchasedItems(){
        List<Purchasable> purchasedItems = new ArrayList<>();
        purchasedItems.add(new EnergyDrink());
        purchasedItems.add(new DragonSlayerReplica());
        purchasedItems.add(new ToiletPaperRoll());
        return purchasedItems;
    }

    /**
     * Allow actor to perform a purchase action.
     *
     * @param actor the actor who going to purchase item in the computer terminal
     * @param location the current Location
     * @param direction the direction of the computer terminal from the actor
     * @return a list of actions that can be performed by the actor
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        for (Purchasable purchasedItem: this.allowablePurchasedItems()){
            actions.add(new PurchaseAction(purchasedItem));
        }
        return actions;
    }

}
