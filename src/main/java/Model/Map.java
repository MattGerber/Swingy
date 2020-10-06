package Model;

import Controller.GameController;
import Model.Hero.Hero;
import View.ConsoleGui;

import java.util.Arrays;
import java.util.Random;

public class Map {
    private Random random = new Random();
    private char[][] map = new char[1][1];
    public Map(int heroLevel, Hero player){
        if (heroLevel != 0) {
            int size = (heroLevel - 1) * 5 + 10 - (heroLevel % 2);
            map = new char[size][size];
            this.populateMap(player);
//            System.out.println(this.toString());
        }
    }

    public void populateMap(Hero player) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++)
                map[i][j] = (random.nextInt(3) == 2) ? '2' : '0';
        }
        map[(map.length/2)][(map.length/2)] = '1';
        player.getCoordinates().setX(map.length/2);
        player.getCoordinates().setY(map.length/2);
    }

    public void printMap(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public void updateMap(Hero player, ConsoleGui console, GameController gameController){
        int y = player.getCoordinates().getY();
        int x = player.getCoordinates().getX();
        int lasty = y;
        int lastx = x;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++)
                if (map[i][j] == '1') {
                    map[i][j] = 'x';
                    lastx = j;
                    lasty = i;
                    break;
                }
        }
        if (map[y][x] == '2'){
            String e = "0";
            while (!e.equals("1") && !e.equals("2")) {
                e = console.encounter();
                if (e.equals("1")) {
                    gameController.fight();
                } else if (e.equals("2")) {
                    if (random.nextInt(10) <= 4) {
                        System.out.println("You fail to run Away. You have to fight!");
                        gameController.fight();
                    } else {
                        System.out.println("You successfully retreat!");
                        player.getCoordinates().setY(lasty);
                        player.getCoordinates().setX(lastx);
                        x = lastx;
                        y = lasty;
                    }
                }
            }
        }
        map[y][x] = '1';
    }

    public char[][] getMap() {
        return map;
    }

    @Override
    public String toString() {
        String ms = "";
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                ms += (map[i][j]);
                ms += ("  ");
            }
            ms += ("\n");
        }
        return  ms;
    }
}
