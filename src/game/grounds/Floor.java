package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.capabilities.Ability;

/**
 * A class that represents the floor inside a building.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class Floor extends Ground {

    /**
     * Constructor of the Floor class.
     */
    public Floor() {
        super('_');
    }

    /**
     * Return true if the actor is allowed to enter the spaceship.
     *
     * Overrides Ground.canActorEnter(Actor actor)
     *
     * @see Ground#canActorEnter(Actor)
     * @param actor The actor to be checked his capability to enter the spaceship.
     * @return a boolean indicating the actor can enter the spaceship.
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Ability.ENTER_SPACESHIP);
    }
}
