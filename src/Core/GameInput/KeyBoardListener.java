package Core.GameInput;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Core.Javaac.Window;
import Core.Player.PlayerData;

public class KeyBoardListener extends KeyAdapter {
	private PlayerData player;
	private ArrayList<Integer> keys;
	private TimerTask task;
	private Timer timer;
	private MenuCursor cursor;
	public KeyBoardListener(PlayerData p, MenuCursor c) {
		this.player = p;
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

				for(Integer i=0; i<keys.size(); i++){
					try {
						if(keys.get(i) != null)
							if(!Window.enablecursor){
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
					} catch(IndexOutOfBoundsException e) { e.printStackTrace(); }
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

	public boolean enterPressed() {
		for(int i=0; i<keys.size(); i++){
			if(keys.get(i) == KeyEvent.VK_ENTER){
				return true;
			}
		}
		return false;
	}
	public boolean escapePressed() {
		for(int i=0; i<keys.size(); i++){
			if(keys.get(i) == KeyEvent.VK_ESCAPE){
				return true;
			}
		}
		return false;
	}
}
