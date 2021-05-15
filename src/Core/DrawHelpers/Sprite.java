package Core.DrawHelpers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Sprite extends SpriteSheetsHandler{

    private BufferedImage sprite;

    public Sprite(String path) throws IOException {
        super(loadSprite(path));
        this.sprite = loadSprite(path);
    }
    
    public void drawSprite(Graphics graphics, int x, int y) throws IOException {
        graphics.drawImage(sprite, x, y, null);
    }
}
