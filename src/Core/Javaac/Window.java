package Core.Javaac;

import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Core.DrawHelpers.*;
import Core.GameInput.KeyBoardListener;
import Core.Player.PlayerData;

public class Window extends JPanel implements Runnable{
    
    private Thread win;
    private PlayerData player = new PlayerData(this);
    public Sprite[] sprite= new Sprite[20]; 

    public Window() {
        setBackground(Color.DARK_GRAY);
        setPreferredSize(new Dimension(1000, 1000));
        setVisible(true);
        win = new Thread(this);
        win.setPriority(Thread.MAX_PRIORITY);
        win.start();

        KeyBoardListener k = new KeyBoardListener(this, player);
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(k);
    }

    public void addSprite(Sprite sprite) {
        this.sprite[0] = sprite;
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

            BufferedImage spriteSheet = null;
            spriteSheet = SpriteLoader.loadSprite("./src/Assets/Menu/Tabs.png");
            SpriteSheetsHandler SP = new SpriteSheetsHandler(spriteSheet);
            
            BufferedImage[] menu = new BufferedImage[5];
            for (int i=0; i<5; i++) {
                menu[i] = SP.grabFrame(0, i, 180, 36);
            }
           
            for (int i=0; i<5; i++) {
               graphics.drawImage(menu[i], 410, 410 + 37*i, null);
            }
            
            Sprite sprite = new Sprite("./src/Assets/Menu/selector.png");
            sprite.drawSprite(graphics, (int)player.getX(), (int)player.getY());
            if (this.sprite[0] != null) {
                this.sprite[0].drawSprite(graphics, 300, 300);
            }


        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
}