package Core.Javaac.Scenarious;

import java.io.IOException;
import java.util.ArrayList;

import Core.DrawHelpers.Sprite;
import Core.GameInput.KeyBoardListener;
import Core.GameInput.MenuCursor;
import Core.Javaac.Button;
import Core.Javaac.Room;
import Core.Javaac.Window;
import Core.Player.PlayerData;

public class RoomFloor1 implements Scene{

	public RoomFloor1() {
		try { new Room(new Sprite("./src/Assets/Floor1/Wall.png"), new Sprite("./src/Assets/Floor1/DoorSheet.png"), 4, new Sprite("./src/Assets/Character/Body.png"), new Sprite("./src/Assets/Character/JavaacHead.png")); }
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
	public void Update(KeyBoardListener keyboard, MenuCursor cursor) {
		// TODO Auto-generated method stub       
	}
}
