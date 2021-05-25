package Core.Projectile;

import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Core.DrawHelpers.Sprite;
import Core.Javaac.Window;
import Core.Player.PlayerData;

public abstract class Projectile implements Runnable{

    private Thread thread;
    private Window w;
    private int x = 0, y = 0;
    private float height;
    private float speed;
    public Sprite sprite;
    private PlayerData player;

    public Projectile(Sprite sprite) {
        thread = new Thread(this);
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        this.player = Window.getPlayer();
        this.x = player.x;
        this.y = player.y;
        this.height = player.getTearHeight();
        this.speed = player.getSpeed();
        this.sprite = sprite;
    }

    public void AI() {
        height-=0.01f;

        this.x += 1;
        if(height > 0)
            this.AI();
    }

    @Override
    public void run() {
        AI();        
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
