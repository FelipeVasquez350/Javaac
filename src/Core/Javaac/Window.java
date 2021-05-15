package Core.Javaac;

import java.io.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Core.DrawHelpers.*;
import Core.GameInput.KeyBoardListener;
import Core.Player.PlayerData;
import Core.Projectile.Projectile;

public class Window extends JPanel implements Runnable{

	private Thread win;
	private PlayerData player = new PlayerData(this, "./src/Assets/Menu/selector.png");
	private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	//private ArrayList<Sprite> backgrounds = new ArrayList<Sprite>();
	private Dimension d;

	public Window() {
		setBackground(Color.DARK_GRAY);
		d=new Dimension(1000,1000);
		setPreferredSize(d);
		setVisible(true);
		win = new Thread(this);
		win.setPriority(Thread.MAX_PRIORITY);
		win.start();
		KeyBoardListener k = new KeyBoardListener(this, player);
		setFocusable(true);
		requestFocusInWindow();
		addKeyListener(k);
	}

	public void addProjectile(Projectile projectile) {
		this.projectiles.add(projectile);
	}

	public void delProjectile(Projectile projectile) {
		this.projectiles.remove(projectile);
	}

	@Override
	public void run(){
		while(true) {
			try {
				Thread.sleep(1);
				repaint();
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}

		}
	}

	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		try {
			for (Projectile projectile : projectiles) { 
				if (projectile != null) 
					projectile.sprite.drawSprite(graphics, 300,300);
			} 
			player.Sprite.drawSprite(graphics, player.x, player.y);
		}catch (IOException e) {
			e.printStackTrace();

		}

	}
}