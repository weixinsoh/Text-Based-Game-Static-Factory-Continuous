package game.scraps.specialscraps;

import edu.monash.fit2099.engine.actors.Actor;

import java.util.List;

/**
 * Interface representing monologuer.
 *
 */
public interface Monologuer {

    /**
     * Returning a list of monologue options that can be performed when met certain conditions.
     *
     * @param owner The actor who listen to the monologuer.
     * @return a list of string containing available monologue options.
     */
    List<String> allowableMonologues(Actor owner);
}
