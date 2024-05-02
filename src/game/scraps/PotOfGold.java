package game.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;
import game.consumable.Consumable;


public class PotOfGold extends Item implements Consumable {

    private static final int POT_OF_GOLD_BALANCE = 10;
    public PotOfGold() {
        super("Pot of Gold", '$', true);
    }

    @Override
    public String consumedBy(Actor actor) {
        actor.removeItemFromInventory(this);
        actor.addBalance(POT_OF_GOLD_BALANCE);
        return String.format("%s is placed into %s's wallet and the amount of gold increases by %d.", this, actor, POT_OF_GOLD_BALANCE);
    }

    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }
}
