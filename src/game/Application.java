package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.Player;
import game.grounds.*;
import game.grounds.trees.Sapling;
import game.scraps.LargeBolt;
import game.scraps.specialscraps.JarOfPickles;
import game.scraps.specialscraps.MetalPipe;
import game.scraps.MetalSheet;
import game.scraps.specialscraps.PotOfGold;
import game.spawners.AlienBugSpawner;
import game.spawners.HuntsmanSpiderSpawner;
import game.spawners.SuspiciousAstronautSpawner;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Application {

    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle(), new Sapling());

        // Polymorphia
        List<String> polymorphia = Arrays.asList(
                        "...~~~~.........~~~...........",
                        "...~~~~.......................",
                        "...~~~........................",
                        "..............................",
                        ".............#####............",
                        ".............#___#...........~",
                        "........t....#___#..........~~",
                        ".............##_##.........~~~",
                        ".................~~........~~~",
                        "................~~~~.......~~~",
                        ".............~~~~~~~........~~",
                        "......~.....~~~~~~~~.........~",
                        ".....~~~...~~~~~~~~~..........",
                        ".....~~~~~~~~~~~~~~~~........~",
                        ".....~~~~~~~~~~~~~~~~~~~....~~");

        // Factory's spaceship parking lot
        List<String> parkingLot = Arrays.asList(
                        ".......",
                        ".#####.",
                        ".#___#.",
                        ".#___#.",
                        ".##_##.",
                        ".......",
                        ".......",
                        ".......",
                        ".......",
                        ".......");

        // New moon
        List<String> moon = Arrays.asList(
                        "..........................~~~~",
                        "..........................~~~~",
                        "..........................~~~~",
                        "~..........................~..",
                        "~~...........#####............",
                        "~~~..........#___#............",
                        "~~~..........#___#............",
                        "~~~..........##_##............",
                        "~~~..................~~.......",
                        "~~~~................~~~~......",
                        "~~~~...............~~~~~......",
                        "..~................~~~~.......",
                        "....................~~........",
                        ".............~~...............",
                        "............~~~~..............");

        GameMap polymorphiaMap = new GameMap(groundFactory, polymorphia);
        GameMap parkingLotMap = new GameMap(groundFactory, parkingLot);
        GameMap moonMap = new GameMap(groundFactory, moon);

        List<GameMap> maps = new ArrayList<>();
        maps.add(polymorphiaMap);
        maps.add(parkingLotMap);
        maps.add(moonMap);

        for (GameMap map: maps){
            world.addGameMap(map);
            ComputerTerminal computerTerminal = new ComputerTerminal();
            map.at(15, 5).setGround(computerTerminal);

            for (GameMap otherMap: maps){
                if (!otherMap.equals(map)){
                    computerTerminal.addTravelMap(otherMap);
                }
            }
        }

        LargeBolt largeBolt = new LargeBolt();
        polymorphiaMap.at(8, 2).addItem(largeBolt);

        MetalSheet metalSheet = new MetalSheet();
        polymorphiaMap.at(6, 2).addItem(metalSheet);

        MetalPipe metalPipe = new MetalPipe();
        polymorphiaMap.at(10, 10).addItem(metalPipe);

        JarOfPickles jarOfPickles = new JarOfPickles();
        polymorphiaMap.at(8,8).addItem(jarOfPickles);

        PotOfGold potOfGold = new PotOfGold();
        polymorphiaMap.at(8,9).addItem(potOfGold);

        Crater hunstmanSpiderCrater = new Crater(new HuntsmanSpiderSpawner());
        polymorphiaMap.at(9, 10).setGround(hunstmanSpiderCrater);

        Crater alienBugCrater = new Crater(new AlienBugSpawner());
        polymorphiaMap.at(12, 12).setGround(alienBugCrater);

        Crater suspiciousAstronautCrater = new Crater(new SuspiciousAstronautSpawner());
        polymorphiaMap.at(16, 12).setGround(suspiciousAstronautCrater);

        Player player = new Player("Intern", '@', 4);
        world.addPlayer(player, polymorphiaMap.at(15, 6));

        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        world.run();
    }
}
