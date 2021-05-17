package Core.Javaac;

import java.io.*;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.JPanel;

import Core.DrawHelpers.*;
import Core.GameInput.KeyBoardListener;
import Core.GameInput.MenuCursor;
import Core.Player.PlayerData;
import Core.Projectile.Projectile;

public class Window extends JPanel implements Runnable{

	private Thread win;
	private Scenario scene; 
	////
	private static Sprite background;
	private static ArrayList<Button> buttons =  new ArrayList<Button>();
	private static ArrayList<Sprite> walls = new ArrayList<Sprite>();
	private static ArrayList<ArrayList<Sprite>> doors = new ArrayList<ArrayList<Sprite>>();
    private static Sprite floor;
	private static PlayerData player = new PlayerData("./src/Assets/Menu/selector.png");
	private static ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	//// 
	public MenuCursor cursor;
	public static KeyBoardListener k;
	public static boolean soon = false; //Temporaney
	public static boolean enablecursor = true;

	public Window() {

		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(1000, 1000));
		setVisible(true);
		win = new Thread(this);
		win.setPriority(Thread.MAX_PRIORITY);
		win.start();


		cursor=new MenuCursor();
		k = new KeyBoardListener(player, cursor);

		setFocusable(true);
		requestFocusInWindow();
		addKeyListener(k);
		initWindow();
	}

	public static void setBackground(Sprite sprite) {
		background = sprite;
	}
	//public void removeBackground(Sprite sprite){}

	public static void setFloor(Sprite sprite) {
		floor = sprite;
	}
	//public void removeFloor(Sprite sprite){}

	public static void setButtons(ArrayList<Button> buttonList) {
		buttons = buttonList;
	}
	//public void removeButtons(ArrayList<Button> buttons){}

	//public void setPlayer(PlayerData player){}
	//public void removePlayer(PlayerData player){}

	public static void setWalls(ArrayList<Sprite> sprites) {
		walls = sprites;
	}
	public static void removeWalls() {
		walls = null;
	}
 
    public static void setDoors(ArrayList<ArrayList<Sprite>> sprites) {
        doors = sprites;
    }
    public static void removeDoors() {
        doors = null;
    }

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


	public void setCursor(MenuCursor cursor) {
		this.cursor = cursor;
	}

	public void initWindow() {
		scene = new Scenario(cursor);
	}

	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		try {       
			//#region BACKGROUND  
			if(background != null)   
				background.drawSprite(graphics, 0, 0);
			//#endregion

			//#region PROJECTILES
			if(projectiles != null) {
				for (int i=0; i<projectiles.size(); i++) {
					projectiles.get(i).sprite.drawSprite(graphics, 300,  300);
				}
			}
			/* for (Projectile projectile : projectiles) { 
				projectile.sprite.drawSprite(graphics, 300,  300);
			} THIS IS BUGGED DON'T ASK ME WHY*/
            //#endregion
    
            //#region UI
            Sprite soonTM = new Sprite("./src/Assets/Menu/SoonTM.png");
            if(soon)
                soonTM.drawSprite(graphics, 400, 650);
            if(buttons != null) {   
                for (int i=0; i<buttons.size(); i++) {
                    if (buttons.get(i).selected)
                        buttons.get(i).highlitedSprite.drawSprite(graphics, buttons.get(i).x, buttons.get(i).y);
                    else
                        buttons.get(i).sprite.drawSprite(graphics, buttons.get(i).x, buttons.get(i).y);
                }
            }
            //#endregion

            //#region Room
            if(walls!=null) {
                for(int i=0; i<walls.size(); i++) {
                    switch(i) {
                        case 0 -> walls.get(i).drawSprite(graphics, 32, 188);
                        case 1 -> walls.get(i).drawSprite(graphics, 32, 500); 
                        case 2 -> walls.get(i).drawSprite(graphics, 498, 188);
                        case 3 -> walls.get(i).drawSprite(graphics, 498, 500);
                    }
                }
            }
            if(doors!=null) {
                for(int i=0; i<doors.size(); i++) {
                    switch(i) {
                        case 0 -> doors.get(i).get(0).drawSprite(graphics, 451, 220);
                        case 1 -> doors.get(i).get(0).rotateSprite(2).drawSprite(graphics, 451, 704); 
                        case 2 -> doors.get(i).get(0).rotateSprite(3).drawSprite(graphics, 64, 451);
                        case 3 -> doors.get(i).get(0).rotateSprite(1).drawSprite(graphics, 858, 451);
                    }
                }
            }
            //#endregion

            //#region PLAYER
			if(!enablecursor)
                if(player != null)
                    player.Sprite.drawSprite(graphics, player.x, player.y);
            if(enablecursor)
                if(cursor!=null) 
                    cursor.Sprite.drawSprite(graphics, cursor.x, cursor.y); 

           /* if(player != null)
                player.Sprite.drawSprite(graphics, player.x, player.y);
            *///#endregion

		} catch (IOException e) { e.printStackTrace(); }        
	}
}