package Core.GameInput;

import java.io.IOException;

import Core.DrawHelpers.Sprite;

public class MenuCursor {
	public int x = 500, y = 350;
	public Sprite Sprite;
	public MenuCursor() {

		try {
			this.Sprite = new Sprite("./src/Assets/Menu/cursor.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public boolean move(int x, int y){
		this.x+=x;
		this.y+=y;
		return true;
	}
}
