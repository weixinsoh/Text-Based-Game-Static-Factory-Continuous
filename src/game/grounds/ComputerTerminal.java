package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.TradeAction;
import game.scraps.purchasedItems.DragonSlayerReplica;
import game.scraps.purchasedItems.EnergyDrink;
import game.scraps.purchasedItems.ToiletPaperRoll;
import game.scraps.purchasedItems.TradeCapable;

import java.util.ArrayList;
import java.util.List;

public class ComputerTerminal extends Ground {

    public ComputerTerminal() {
        super('=');
    }

    public List<TradeCapable> allowableTradeCapables(){
        List<TradeCapable> tradeCapables = new ArrayList<>();
        tradeCapables.add(new EnergyDrink());
        tradeCapables.add(new DragonSlayerReplica());
        tradeCapables.add(new ToiletPaperRoll());
        return tradeCapables;
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        for (TradeCapable tradeCapable: this.allowableTradeCapables()){
            actions.add(new TradeAction(tradeCapable));
        }
        return actions;
    }

}
