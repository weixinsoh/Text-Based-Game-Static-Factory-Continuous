package game.scraps.purchasedItems;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

public class ToiletPaperRoll extends Item implements TradeCapable{

    private static final int CREDIT = 5;

    private static final int SPECIAL_CASE_CREDIT = 1;

    private static final double SPECIAL_CASE_CHANCE = 0.75;

    public ToiletPaperRoll() {
        super("Toilet Paper Roll", 's', true);
    }

    @Override
    public String trade(Actor actor) {
        String ret = "";
        int newCredit = CREDIT;

        if (Math.random() <= SPECIAL_CASE_CHANCE)
            newCredit = SPECIAL_CASE_CREDIT;

        if (Payment.makePayment(actor,newCredit)){
            actor.addItemToInventory(this);
            ret += String.format("%s successfully purchased %s for %d credits.", actor, this, newCredit);
        } else {
            ret += String.format("Balance is not sufficient to make the payment (%d < %d). Purchase failed!", actor.getBalance(), CREDIT);
        }
        return ret;
    }
}
