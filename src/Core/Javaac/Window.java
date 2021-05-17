package Core.Javaac;

import java.io.*;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.JPanel;

import Core.DrawHelpers.*;
import Core.GameInput.KeyBoardListener;
import Core.Player.PlayerData;
import Core.Projectile.Projectile;

public class Window extends JPanel implements Runnable{
    
    private Thread win;
    private Scenario scene; 
////
    private static Sprite background;
    private static ArrayList<Button> buttons =  new ArrayList<Button>();
    private static PlayerData player = new PlayerData("./src/Assets/Menu/selector.png");
    private static ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
////    
    public static KeyBoardListener k;
    public static boolean soon = false; //Temporaney

    public Window() {
        setBackground(Color.DARK_GRAY);
        setPreferredSize(new Dimension(1000, 1000));
        setVisible(true);
        win = new Thread(this);
        win.setPriority(Thread.MAX_PRIORITY);
        win.start();

        k = new KeyBoardListener(player);
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(k);
        initWindow();
    }

    public static void setBackground(Sprite sprite) {
        background = sprite;
    }
    //public void removeBackground(Sprite background){}

    public static void setButtons(ArrayList<Button> buttonList) {
        buttons = buttonList;
    }
    //public void removeButtons(ArrayList<Button> buttons){}

    //public void setPlayer(PlayerData player){}
    //public void removePlayer(PlayerData player){}

    public static void setProjectile(Projectile projectile) {
        projectiles.add(projectile);
    }
    public static void removeProjectile(Projectile projectile) {
        projectiles.remove(projectile);
    }
   
    public static PlayerData getPlayer() {
        return player;
    }
    public static KeyBoardListener getKeyBoard() {
        return k;
    }

    @Override
    public void run() {
        while(true) {
			try {
				Thread.sleep(1);
				repaint();
                if (k.escapePressed()) {
                    System.exit(0);
                }
			} catch (InterruptedException e) {		
				e.printStackTrace();		
			}
        }
    }

    public void initWindow() {
        scene = new Scenario();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        try {       
            //#region BACKGROUND  
            if(background != null)   
                background.drawSprite(graphics, 0, 0);
            //#endregion
            
            //#region PLAYER
            if(player != null)
                player.Sprite.drawSprite(graphics, player.x, player.y);
            //#endregion

            //#region PROJECTILES
            for (int i=0; i<projectiles.size(); i++) {
                projectiles.get(i).sprite.drawSprite(graphics, 300,  300);
            }
            /* for (Projectile projectile : projectiles) { 
				projectile.sprite.drawSprite(graphics, 300,  300);
			} THIS IS BUGGED DON'T ASK ME WHY*/
            //#endregion
    
            //#region UI
            Sprite soonTM = new Sprite("./src/Assets/Menu/SoonTM.png");
            if(soon)
                soonTM.drawSprite(graphics, 400, 650);
               
            for (int i=0; i<buttons.size(); i++) {
                if (buttons.get(i).selected)
                    buttons.get(i).highlitedSprite.drawSprite(graphics, buttons.get(i).x, buttons.get(i).y);
                else
                    buttons.get(i).sprite.drawSprite(graphics, buttons.get(i).x, buttons.get(i).y);
            }
            //#endregion
		} catch (IOException e) { e.printStackTrace(); }        
    }
}