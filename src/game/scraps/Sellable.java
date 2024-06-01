package game.scraps;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

public interface Sellable {
    String sell(Actor otherActor, GameMap map);
}
