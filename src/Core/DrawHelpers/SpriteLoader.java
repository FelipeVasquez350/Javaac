package Core.DrawHelpers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteLoader {
    private BufferedImage sprite;

    public BufferedImage loadSprite(String path) throws IOException {
        sprite = ImageIO.read(new File(path));
        return sprite;
    }
}
