package Core.Javaac;

import java.util.ArrayList;

import Core.DrawHelpers.Sprite;

public class Room {
    private ArrayList<Sprite> walls = new ArrayList<Sprite>();
    private ArrayList<Sprite> doors = new ArrayList<Sprite>();
    private ArrayList<Sprite> rocks = new ArrayList<Sprite>();
    private ArrayList<Integer[]> rocksLocations = new ArrayList<Integer[]>();

    private Sprite floor;

    public Room(Sprite wall/*, ArrayList<Sprite> doors, int doorsNumber, ArrayList<Sprite> rocks, int rocksNumber, Sprite floor*/){
        // this.walls
      //  this.doors = doors;
      //  this.rocks = rocks;
        initWalls(wall);
    };

    public void initWalls(Sprite wall) {
        for(int i=0; i<4; i++) {
            switch(i) {
                case 0 -> walls.add(wall.flipSprite(1,1));
                case 1 -> walls.add(wall.flipSprite(1,-1));
                case 2 -> walls.add(wall.flipSprite(-1,1));
                case 3 -> walls.add(wall.flipSprite(-1,-1));
            }
        }
        Window.setWalls(walls);
    }
    public void initDoors(int n) {

    }
    public void initRocks(int n) {

    }


}
