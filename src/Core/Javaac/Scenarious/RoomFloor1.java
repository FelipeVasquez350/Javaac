package Core.Javaac.Scenarious;

import java.io.IOException;
import java.util.ArrayList;

import Core.DrawHelpers.Sprite;
import Core.GameInput.KeyBoardListener;
import Core.Javaac.Button;
import Core.Javaac.Room;
import Core.Javaac.Window;
import Core.Player.PlayerData;

public class RoomFloor1 implements Scene{

    public RoomFloor1() {
        try { new Room(new Sprite("./src/Assets/Floor1/Wall.png")); }
        catch (IOException e) { e.printStackTrace(); }
        initBackground();
        initButtons();
    }

    @Override
    public void initBackground() {
        Window.setBackground((Sprite) null);
        Sprite wall;
        try {
            wall = new Sprite("./src/Assets/Floor1/Wall.png");
         //   Window.setBackground(wall.rotateSprite(0));

        } catch (IOException e) { e.printStackTrace(); }
    }

    @Override
    public void initButtons() {
        Window.setButtons((ArrayList<Button>) null);    
    }

    @Override
    public void Update(KeyBoardListener keyboard, PlayerData player) {
        // TODO Auto-generated method stub       
    }
    
}