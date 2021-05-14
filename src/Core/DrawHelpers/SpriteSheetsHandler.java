package Core.DrawHelpers;

import java.awt.image.BufferedImage;

public class SpriteSheetsHandler extends SpriteLoader{
    private BufferedImage sprite;

    public SpriteSheetsHandler(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public BufferedImage grabFrame(int column, int row, int width, int height) {
        BufferedImage spr = sprite.getSubimage((column*width), (row*height), width, height);
        return spr;
    }
}