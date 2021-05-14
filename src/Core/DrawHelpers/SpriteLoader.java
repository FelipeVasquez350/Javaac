package Core.DrawHelpers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteLoader {

    public static BufferedImage loadSprite(String path) throws IOException {
        BufferedImage sprite = ImageIO.read(new File(path));
        return sprite;
    }
}
