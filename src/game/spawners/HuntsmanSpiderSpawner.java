package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.spawners.Spawner;
import game.actors.creatures.HuntsmanSpider;

public class HuntsmanSpiderSpawner implements Spawner {

    @Override
    public void spawn(Location location) {
        if (Math.random() <= 0.05) {
            new HuntsmanSpider();
        }
    }
}
