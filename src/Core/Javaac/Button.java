package Core.Javaac;

import Core.DrawHelpers.Sprite;
import Core.GameInput.KeyBoardListener;

public class Button {
    public Sprite sprite;
    public KeyBoardListener keyboard;
    public int x,y;
    public int width,height;
    public boolean selected;


    public Button(int x, int y, int width, int height, Sprite sprite, KeyBoardListener keyboard) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.sprite = sprite;
        this.keyboard = keyboard;
        this.selected = true;
    }

    public boolean clicked() {
        if(this.selected && this.keyboard.enterPressed())
            return true;
        return false;
    }
}
