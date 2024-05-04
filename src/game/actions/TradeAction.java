package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.scraps.purchasedItems.TradeCapable;

public class TradeAction extends Action {

    public TradeCapable tradeCapable;

    public TradeAction(TradeCapable tradeCapable){
        this.tradeCapable = tradeCapable;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return tradeCapable.trade(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return  actor + " purchases " + tradeCapable;
    }
}
