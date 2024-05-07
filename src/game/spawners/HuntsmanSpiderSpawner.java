package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.creatures.HuntsmanSpider;


public class HuntsmanSpiderSpawner implements Spawner {
    public HuntsmanSpiderSpawner(){}
    @Override
    public void spawn(Location location) {
        if (Math.random() <= 0.05) {                //5% chance of spawning
            HuntsmanSpider hunstmanSpider = new HuntsmanSpider();
            location.addActor(hunstmanSpider);
        }

    }
}
