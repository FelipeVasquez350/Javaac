package Core.Javaac;

import java.io.IOException;
import java.util.ArrayList;

import Core.DrawHelpers.Sprite;

public class Room {
    private ArrayList<Sprite> walls = new ArrayList<Sprite>();
    private ArrayList<ArrayList<Sprite>> doors = new ArrayList<ArrayList<Sprite>>();
    private ArrayList<Sprite> rocks = new ArrayList<Sprite>();
    private ArrayList<Integer[]> rocksLocations = new ArrayList<Integer[]>();

    private Sprite floor;

    public Room(Sprite wall, Sprite door, int doorsNumber/*, ArrayList<Sprite> rocks, int rocksNumber, Sprite floor*/){
        // this.walls
      //  this.doors = doors;
      //  this.rocks = rocks;
        initWalls(wall);
        initDoors(door, doorsNumber);
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
    public void initDoors(Sprite door, int n) {
        for (int i=0; i<n; i++) {
            ArrayList<Sprite> ae = new ArrayList<Sprite>();
            for(int j=0; j<5; j++) {
                try { ae.add(new Sprite("./src/Assets/Floor1/DoorSheet.png").grabFrame(0, j, 98, 76));  } 
                catch (IOException e) { e.printStackTrace(); }}
            doors.add(ae);
        }
        Window.setDoors(doors);
    }
    public void initRocks(int n) {

    }


}
