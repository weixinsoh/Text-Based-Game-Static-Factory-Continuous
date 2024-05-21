package game.scraps.specialscraps;

import edu.monash.fit2099.engine.actors.Actor;

import java.util.List;

public interface Monologuer {

    List<String> allowableMonologues(Actor owner);
}
