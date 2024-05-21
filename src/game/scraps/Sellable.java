package game.scraps;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

public interface Sellable {
    int getCreditForSale();
    Item soldBy();
}
