package game.scraps.purchasedItems;

import edu.monash.fit2099.engine.actors.Actor;
import game.consumable.ConsumableItem;

public class EnergyDrink extends ConsumableItem implements TradeCapable {

    private static final int CREDIT = 10;

    private static final int HIT_POINTS = 1;

    private static final double SPECIAL_CASE_CHANCE = 0.2;

    /**
     * Constructor of the ConsumableItem class.
     */
    public EnergyDrink() {
        super("Energy Drink", '*', true);
    }

    @Override
    public String consumedBy(Actor actor){
        actor.heal(HIT_POINTS);
        return String.format("%s drinks Energy Drink. %s feels energised.", actor, actor);
    }

    @Override
    public String trade(Actor actor){
        String ret = "";

        int newCredit = CREDIT;

        if (Math.random() <= SPECIAL_CASE_CHANCE)
            newCredit = CREDIT * 2;

        if (Payment.makePayment(actor,newCredit)){
            actor.addItemToInventory(this);
            ret += String.format("%s successfully purchased %s for %d credits.", actor, this, newCredit);
        } else {
            ret += String.format("Balance is not sufficient to make the payment (%d < %d). Purchase failed!", actor.getBalance(), CREDIT);
        }
        return ret;
    }


}