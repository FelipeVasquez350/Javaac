package Core.Javaac;

import java.util.ArrayList;

import Core.GameInput.KeyBoardListener;
import Core.GameInput.MenuCursor;
import Core.Javaac.Scenarious.RoomFloor1;
import Core.Javaac.Scenarious.Menu;
import Core.Javaac.Scenarious.Options;
import Core.Javaac.Scenarious.Scene;
import Core.Player.PlayerData;

public class Scenario implements Runnable{
	private Thread scenario;
	private static Scene currentScenario;
	public static int typeScenario;
	private KeyBoardListener keyboard;
	private PlayerData player;
	private MenuCursor cursor;

	public Scenario(MenuCursor cursor) {
		currentScenario = new Menu();
		this.keyboard = Window.getKeyBoard();
		this.player = Window.getPlayer();
		this.cursor= cursor;
		scenario = new Thread(this);
		scenario.setPriority(Thread.MAX_PRIORITY);
		scenario.start();
	}

	public static void setScenario(int select){
		typeScenario = select;
		switch(select){
		case 0 -> currentScenario = new Menu();
		case 1 -> currentScenario = new RoomFloor1();
		case 2 -> {/*currentScenario=null;*/currentScenario = new Options();}
		default -> System.exit(0);
		}
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1);      
				     
				currentScenario.Update(this.keyboard, this.cursor);
			} catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
}
