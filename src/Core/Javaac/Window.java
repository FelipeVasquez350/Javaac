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
    private PlayerData player = new PlayerData(this, "./src/Assets/Menu/selector.png");
    private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
    private Sprite background;
    public static KeyBoardListener k;
    private Scene scene; 

    public Window() {
        setBackground(Color.DARK_GRAY);
        setPreferredSize(new Dimension(1000, 1000));
        setVisible(true);
        win = new Thread(this);
        win.setPriority(Thread.MAX_PRIORITY);
        win.start();

        k = new KeyBoardListener(this, player);
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(k);
        initWindow();
    }

    public KeyBoardListener getKeyBoard() {
        return k;
    }

    public void addProjectile(Projectile projectile) {
        this.projectiles.add(projectile);
    }

    public void delProjectile(Projectile projectile) {
        this.projectiles.remove(projectile);
    }

    @Override
    public void run() {
        while(true) {
			try {
				Thread.sleep(1);
				repaint();		
			} catch (InterruptedException e) {		
				e.printStackTrace();		
			}
        }
    }

    public void initWindow() {
        try {
            background = new Sprite("./src/Assets/Menu/emptyscreen.png");
            scene = new Scene();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        try {       
            //#region BACKGROUND     
            background.drawSprite(graphics, 0, 0);
            //#endregion
            
            //#region PLAYER
            player.Sprite.drawSprite(graphics, player.x, player.y);
            //#endregion

            //#region PROJECTILES
            for (int i=0; i<projectiles.size(); i++) {
                projectiles.get(i).sprite.drawSprite(graphics, 300,  300);
            }
         /*  for (Projectile projectile : projectiles) { 
                if (projectile != null) 
				    projectile.sprite.drawSprite(graphics, 300,  300);
			} */
            //#endregion
            
            //#region UI
          /*  scene.menu.button.sprite.drawSprite(graphics, scene.menu.button.x, scene.menu.button.y);
            if(scene.menu.button.clicked())
                System.out.println("Hey");*/
            Sprite soonTM = new Sprite("./src/Assets/Menu/SoonTM.png");
            for (int j = 0; j<scene.menu.buttons.size(); j++) {
                if(scene.menu.buttons.get(j).x < player.x && scene.menu.buttons.get(j).x + scene.menu.buttons.get(j).width > player.x && scene.menu.buttons.get(j).y < player.y && scene.menu.buttons.get(j).y + scene.menu.buttons.get(j).height > player.y) {
                    scene.menu.spriteBottoni.get(j).drawSprite(graphics, scene.menu.buttons.get(j).x,  scene.menu.buttons.get(j).y);
                    if(scene.menu.buttons.get(j).clicked() && j!=0);
                        soonTM.drawSprite(graphics, 500, 500);
                }

                else
                    scene.menu.spriteBottoni2.get(j).drawSprite(graphics, scene.menu.buttons.get(j).x,  scene.menu.buttons.get(j).y);
            
                // if(!scene.menu.buttons.get(j).selected)
                //     scene.menu.spriteBottoni2.get(j).drawSprite(graphics, scene.menu.buttons.get(j).x,  scene.menu.buttons.get(j).y);

                // else
                //     scene.menu.spriteBottoni.get(j).drawSprite(graphics, scene.menu.buttons.get(j).x,  scene.menu.buttons.get(j).y);
            
               
            }
            for (int j = 0; j<scene.menu.buttons.size(); j++) {
                if(scene.menu.buttons.get(j).x < player.x && scene.menu.buttons.get(j).x + scene.menu.buttons.get(j).width > player.x && scene.menu.buttons.get(j).y < player.y && scene.menu.buttons.get(j).y + scene.menu.buttons.get(j).height > player.y) {
                    
                }
            }
            //#endregion

		}catch (IOException e) {
            e.printStackTrace();

        }        
    }
}