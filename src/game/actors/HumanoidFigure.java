package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.PurchaseAction;
import game.actions.SellAction;
import game.capabilities.Status;
import game.scraps.Sellable;
import game.scraps.specialscraps.Purchasable;

public class HumanoidFigure extends Actor {
    /**
     * The constructor of the Actor class.
     */
    public HumanoidFigure() {

        super("Humanoid Figure", 'H', 0);
        this.addCapability(Status.BUYER);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }
}
