package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.scraps.Sellable;

public class SellAction extends Action {

    private Sellable sellableItem;

    public SellAction(Sellable sellableItem){
        this.sellableItem = sellableItem;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        int saleCredits = sellableItem.getCreditForSale();
        actor.addBalance(saleCredits);
        actor.removeItemFromInventory(sellableItem.soldBy());
        return actor.toString() +  " successfully sold " + sellableItem + " for " + saleCredits + " credits.";
    }

    @Override
    public String menuDescription(Actor actor){
        return  actor + " sells " + sellableItem;
    }
}
