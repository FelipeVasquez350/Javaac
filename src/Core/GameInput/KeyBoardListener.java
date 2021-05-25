package Core.GameInput;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import Core.Javaac.Window;
import Core.Javaac.Scenarious.PauseMenu;
import Core.Player.PlayerData;


public class KeyBoardListener extends KeyAdapter {
	private static PlayerData player;
	public static ArrayList<Integer> keys;
	private TimerTask task;
	private Timer timer;
	private MenuCursor cursor;

	public KeyBoardListener(MenuCursor c) {
		keys=new ArrayList<Integer>();
		cursor=c;
	}


	public void keyPressed(KeyEvent e){
		int key= e.getKeyCode();
		if(!keys.contains(key)){
			keys.add(key);
		}
		if(timer!=null)
			return;
		task = new TimerTask(){
			@Override
			public void run() {
				try { Thread.sleep(3); }
				catch (InterruptedException e1) { e1.printStackTrace(); }
				if(keys!=null)
					for(Integer i=0; i<keys.size(); i++){
						if(keys.get(i) != null)
							if(!Window.enablecursor && player != null){
								if(!PauseMenu.active) {
									switch(keys.get(i)) {
									case KeyEvent.VK_D -> player.move(1, 0);
									case KeyEvent.VK_A -> player.move(-1, 0);
									case KeyEvent.VK_S -> player.move(0, 1);
									case KeyEvent.VK_W -> player.move(0, -1);
									case KeyEvent.VK_RIGHT -> player.shot("Right");
									case KeyEvent.VK_UP -> player.shot("UP");
									case KeyEvent.VK_DOWN -> player.shot("Down");
									case KeyEvent.VK_LEFT -> player.shot("Left");
									}
									/*

									if(keys.get(i) == KeyEvent.VK_D){
										player.move(1, 0);
									}
									if(keys.get(i) == KeyEvent.VK_A){
										player.move(-1, 0);
									}
									if(keys.get(i) == KeyEvent.VK_S){
										player.move(0, 1);
									}
									if(keys.get(i) == KeyEvent.VK_W){
										player.move(0, -1);
									}
									if(keys.get(i) == KeyEvent.VK_RIGHT){
										player.shot("Right");
									}
									if(keys.get(i) == KeyEvent.VK_UP){
										player.shot("UP");
									}
									if(keys.get(i) == KeyEvent.VK_DOWN){
										player.shot("Down");
									}
									if(keys.get(i) == KeyEvent.VK_LEFT){
										player.shot("Left");
									}*/
								}
							}
							else {
								if(keys.get(i) == KeyEvent.VK_D){
									cursor.move(1, 0);
								}
								if(keys.get(i) == KeyEvent.VK_A){
									cursor.move(-1, 0);
								}
								if(keys.get(i) == KeyEvent.VK_S){
									cursor.move(0, 1);
								}
								if(keys.get(i) == KeyEvent.VK_W){
									cursor.move(0, -1);
								}
							}
					}

				if(player!=null && keys.size()<=0) {
					try { Thread.sleep(10); }
					catch (InterruptedException e1) { e1.printStackTrace(); }
					player.move(0,0);
				}
			}
		};
		timer = new Timer(true);
		timer.scheduleAtFixedRate(task, 0, 2);
	}

	public void keyReleased(KeyEvent e){
		Integer key = e.getKeyCode();
		if(timer!=null && keys.size()<=0){
			timer.cancel();
			timer = null;
		}

		if(keys.contains(key)) {
			keys.remove(key);
		}
	}

	public static boolean enterPressed() {
		for(int i=0; i<keys.size(); i++){
			if(keys.get(i) == KeyEvent.VK_ENTER){
				return true;
			}
		}
		return false;
	}

	public static boolean escapePressed() {
		for(int i=0; i<keys.size(); i++){
			if(keys.get(i) == KeyEvent.VK_ESCAPE){
				return true;
			}
		}
		return false;
	}

	public static void addPlayer(PlayerData playerData) {
		player = playerData;
	}
}
