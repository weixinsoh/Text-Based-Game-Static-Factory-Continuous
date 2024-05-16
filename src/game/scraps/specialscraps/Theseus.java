package game.scraps.specialscraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.Utility;
import game.actions.TravelAction;
import jdk.jshell.execution.Util;

public class Theseus extends Item implements Purchasable{
    private static final int CREDIT = 100;

    /***
     * Constructor.
     */
    public Theseus() {
        super("THESEUS", '^', true);
    }

    @Override
    public String purchase(Actor actor) {
        actor.addItemToInventory(this);
        return String.format("%s successfully purchased %s for %d credits.", actor, this, CREDIT);
    }

    @Override
    public int getActualCredit() {
        return CREDIT;
    }

    @Override
    public ActionList allowableActions(Location location){
        ActionList actions = new ActionList();
        int x = Utility.generateRandomInt(location.map().getXRange().min(), location.map().getYRange().min());
        int y = Utility.generateRandomInt(location.map().getYRange().min(), location.map().getYRange().max());
        actions.add(new TravelAction(location.map().at(x, y), "current map"));
        return actions;
    }
}
