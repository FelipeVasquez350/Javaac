package Core.Projectile;

import java.io.*;

import Core.DrawHelpers.Sprite;
import Core.Javaac.Window;
public class Projectile{

    public int x,y;
    public Sprite sprite;

    public Projectile(int x, int y) {
        try {
            sprite = new Sprite("./src/Assets/Menu/selector.png");
            Window.setProjectile(this);
        } catch (IOException e) {
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

    public void remove() {
        Window.removeProjectile(this);
    }
    public boolean Move(int x, int y){
        setX(getX()+ x);
        setY(getY() + y);
        return true;
    }
}
