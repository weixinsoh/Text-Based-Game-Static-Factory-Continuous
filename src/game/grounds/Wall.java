package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * Class representing the wall of the building.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class Wall extends Ground {

    /**
     * Constructor of the Wall class.
     */
    public Wall() {
        super('#');
    }

    /**
     * Return false indicating the actor are not allowed to enter it.
     *
     * Overrides Ground.canActorEnter(Actor)
     *
     * @see Ground#canActorEnter(Actor)
     * @param actor the Actor to check
     * @return false
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }
}
