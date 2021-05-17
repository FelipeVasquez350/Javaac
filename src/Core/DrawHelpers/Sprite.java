package Core.DrawHelpers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Sprite{
    private BufferedImage sprite;

    public Sprite(String path) throws IOException {
        this.sprite = ImageIO.read(new File(path));
    }
    public Sprite(BufferedImage sprite)  {
        this.sprite = sprite;
    }
    
    public void drawSprite(Graphics graphics, int x, int y) throws IOException {
        graphics.drawImage(this.sprite, x, y, null);
    }
    public Sprite grabFrame(int column, int row, int width, int height) {
        Sprite frame = new Sprite(this.sprite.getSubimage((column*width), (row*height), width, height));
        return frame;
    }
}
