package game.scraps.purchasedItems;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;

public class DragonSlayerReplica extends WeaponItem implements TradeCapable {

    private static final int CREDIT = 100;

    private static final double SPECIAL_CASE_CHANCE = 0.5;

    /**
     * Constructor.
     *
     */
    public DragonSlayerReplica() {
        super("Dragon Slayer Replica", 'x', 50, "whacks", 75);
    }

    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = new ActionList();
        actions.add(new AttackAction(otherActor, location.toString(), this));
        return actions;
    }

    @Override
    public String trade(Actor actor) {
        String ret = "";

        if (Payment.makePayment(actor, CREDIT)) {
            if (Math.random() <= SPECIAL_CASE_CHANCE){
                actor.addItemToInventory(this);
                ret += String.format("%s successfully purchased %s for %d credits.", actor, this, CREDIT);
            } else {
                ret += String.format("%d credits are taken from %s, but %s doesn't receive anything in the return!", CREDIT, actor, actor);
            }
        } else {
            ret += String.format("Balance is not sufficient to make the payment (%d < %d). Purchase failed!", actor.getBalance(), CREDIT);
        }
        return ret;
    }
}

