package Core.Javaac;

import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Core.DrawHelpers.*;

public class Window extends JPanel implements Runnable{
    
    private Thread win;

    public Window() {
        setBackground(Color.DARK_GRAY);
        setPreferredSize(new Dimension(1000, 1000));
        setVisible(true);
        win = new Thread(this);
        win.setPriority(Thread.MAX_PRIORITY);
        win.start();
    }

    @Override
    public void run() {
       
        while(true) {
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
       
        try {
            File pathToFile = new File("./src/Assets/Menu/emptyscreen.png");
            Image image = ImageIO.read(pathToFile);
            graphics.drawImage(image, 0, 0, null);

            SpriteLoader SPLoader = new SpriteLoader();
            BufferedImage spriteSheet = null;
            spriteSheet = SPLoader.loadSprite("./src/Assets/Menu/Tabs.png");
            SpriteSheetsHandler SP = new SpriteSheetsHandler(spriteSheet);
            
            BufferedImage[] menu = new BufferedImage[5];
            for (int i=0; i<5; i++) {
                menu[i] = SP.grabFrame(0, i, 180, 36);
            }
           
            for (int i=0; i<5; i++) {
                graphics.drawImage(menu[i], 410, 410 + 37*i, null);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
}