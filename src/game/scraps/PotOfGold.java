package game.scraps;

import edu.monash.fit2099.engine.actors.Actor;
import game.consumable.ConsumableItem;

public class PotOfGold extends ConsumableItem {

    private static final int POT_OF_GOLD_BALANCE = 10;
    public PotOfGold() {
        super("Pot of Gold", '$', true);
    }

    @Override
    public String consumedBy(Actor actor) {
        actor.addBalance(POT_OF_GOLD_BALANCE);
        return super.consumedBy(actor) + "\nPot of Gold is placed into wallet for 10 gold.";
    }
}

