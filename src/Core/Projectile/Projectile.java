package Core.Projectile;

import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Core.DrawHelpers.Sprite;
import Core.Javaac.Window;
public class Projectile{
    private int x,y;
    private Thread t;
    private Window w;

    public Projectile(int x, int y, Window w) {
        Sprite sprite;
        try {
            sprite = new Sprite("./src/Assets/Menu/selector.png");
            w.addSprite(sprite);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public boolean Move(int x, int y){
        setX(getX()+ x);
        setY(getY() + y);
        return true;
    }
}
