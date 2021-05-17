package Core.Javaac;

import Core.DrawHelpers.Sprite;
import Core.GameInput.KeyBoardListener;

public class Button {
	public Sprite sprite;
	public Sprite highlitedSprite;
	public KeyBoardListener keyboard;
	public int x,y;
	public int width,height;
	public boolean selected;
	public boolean done;


	public Button(int x, int y, int width, int height, Sprite highlitedSprite, Sprite sprite, KeyBoardListener keyboard, boolean done) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;        
		this.highlitedSprite = highlitedSprite;
		this.sprite = sprite;
		this.keyboard = keyboard;
		this.selected = true;
		this.done = done;
	}

	public boolean clicked() {
		if(this.selected && this.keyboard.enterPressed())
			return true;
		return false;
	}
}
