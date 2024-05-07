package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.creatures.AlienBug;

public class AlienBugSpawner implements Spawner{
    public AlienBugSpawner(){}
    @Override
    public void spawn(Location location) {
        if (Math.random() <= 0.10) {            //10% chance of spawning
            AlienBug alienBug = new AlienBug();
            location.addActor(alienBug);
        }

        }
    }
