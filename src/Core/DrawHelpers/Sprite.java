package Core.DrawHelpers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
 

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
    /**
    * Returns an Image flipped given x and y either +-1. 
    * This method returns the same image given x = 1 and y = 1
    * @param  x int value [-1;1]
    * @param  y int value [-1;1]
    * @return Sprite
    * @see Sprite
    */
    public Sprite flipSprite(int x, int y) {
        // Flip the image vertically
        Sprite flippedSprite;
        AffineTransform tx = AffineTransform.getScaleInstance(x, y);
        int X; if (x==1) X=0; else X=-sprite.getWidth(null);
        int Y; if (y==1) Y=0; else Y=-sprite.getHeight(null);
        tx.translate(X, Y);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        flippedSprite= new Sprite(op.filter(sprite, null));
        return flippedSprite;
    }
    public Sprite rotateSprite(int a) {
        final double rads = Math.toRadians(90*a);
        final double sin = Math.abs(Math.sin(rads));
        final double cos = Math.abs(Math.cos(rads));
        final int w = (int) Math.floor(sprite.getWidth() * cos + sprite.getHeight() * sin);
        final int h = (int) Math.floor(sprite.getHeight() * cos + sprite.getWidth() * sin);
        final Sprite rotatedImage = new Sprite(new BufferedImage(w, h, sprite.getType()));
        final AffineTransform at = new AffineTransform();
        at.translate(w / 2, h / 2);
        at.rotate(rads,0, 0);
        at.translate(-sprite.getWidth() / 2, -sprite.getHeight() / 2);
        final AffineTransformOp rotateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        rotateOp.filter(sprite, rotatedImage.sprite); 

        return rotatedImage;
    }
}
