package game.scraps.specialscraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ListenAction;

import java.util.ArrayList;
import java.util.List;

public class Astley extends Item implements Purchasable, Monologuer {

    private static final int CREDIT = 50;

    private static final int TICKS_TO_PAY_SUBSCRIPTION = 5;

    private static final int CREDIT_TO_PAY_SUBSCRIPTION = 1;

    private boolean isSubscribed = false;

    private int count = 0;

    public Astley() {
        super("Astley", 'z', true);
    }

//    @Override
//    public void tick(Location currentLocation, Actor actor) {
//        Display display = new Display();
//        count++;
//        if (this.count % TICKS_TO_PAY_SUBSCRIPTION == 0) {
//            if (actor.getBalance() >= CREDIT_TO_PAY_SUBSCRIPTION){
//                actor.deductBalance(CREDIT_TO_PAY_SUBSCRIPTION);
//                display.println("Subscription payment received!");
//            } else {
//                isSubscribed = false;
//                display.println("You don't have enough money to continue using our AI services. Goodbye.");
//            }
//        }
//    }
//
//    @Override
//    public ActionList allowableActions(Actor owner){
//        ActionList actions = new ActionList();
//        if (isSubscribed)
//            actions.add(new ListenAction(this));
//        return actions;
//    }

//    @Override
//    public List<String> allowableMonologues(Actor owner){
//        List<String> monologues = new ArrayList<>();
//        monologues.add("The factory will never gonna give you up, valuable intern!");
//        monologues.add("We promise we never gonna let you down with a range of staff benefits.");
//        monologues.add("We never gonna run around and desert you, dear intern!");
//        if (owner.getItemInventory().size() > 10)
//            monologues.add("We never gonna make you cry with unfair compensation.");
//        if (owner.getBalance() > 50)
//            monologues.add("Trust is essential in this business. We promise we never gonna say goodbye to a valuable intern like you.");
//        if (owner.getAttribute(BaseActorAttributes.HEALTH) < 2)
//            monologues.add("Don't worry, we never gonna tell a lie and hurt you, unlike those hostile creatures.");
//        return monologues;
//    }

    @Override
    public String purchase(Actor actor) {
        isSubscribed = true;
        actor.addItemToInventory(this);
        return String.format("%s successfully purchased %s for %d credits.", actor, this, CREDIT);
    }

    @Override
    public int getActualCredit() {
        return CREDIT;
    }

    @Override
    public String toString(){
        return "Astley, an AI device.";
    }
}