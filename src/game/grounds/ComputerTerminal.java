package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.TradeAction;
import game.scraps.specialscraps.DragonSlayerReplica;
import game.scraps.specialscraps.EnergyDrink;
import game.scraps.specialscraps.ToiletPaperRoll;
import game.scraps.specialscraps.TradeCapable;

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
     * Add all trade-capable items available in the computer terminal into a list
     * @return a list containing all trade-capable items found in the computer terminal
     */
    public List<TradeCapable> allowableTradeCapables(){
        List<TradeCapable> tradeCapables = new ArrayList<>();
        tradeCapables.add(new EnergyDrink());
        tradeCapables.add(new DragonSlayerReplica());
        tradeCapables.add(new ToiletPaperRoll());
        return tradeCapables;
    }

    /**
     * Allow actor to perform a trade action.
     *
     * @param actor the actor who going to purchase item in the computer terminal
     * @param location the current Location
     * @param direction the direction of the computer terminal from the actor
     * @return a list of actions that can be performed by the actor
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        for (TradeCapable tradeCapable: this.allowableTradeCapables()){
            actions.add(new TradeAction(tradeCapable));
        }
        return actions;
    }

}
