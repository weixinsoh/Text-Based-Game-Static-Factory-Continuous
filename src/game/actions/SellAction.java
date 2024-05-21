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
    public String execute(Actor actor, GameMap map) {return null;}

    @Override
    public String menuDescription(Actor actor){
        return  actor + " sells " + sellableItem;
    }
}
