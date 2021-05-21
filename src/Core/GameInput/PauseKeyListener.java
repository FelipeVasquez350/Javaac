package Core.GameInput;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Core.Javaac.Scenario;
import Core.Javaac.Window;
import Core.Javaac.Scenarious.PauseMenu;

public class PauseKeyListener extends KeyAdapter {
	public void keyPressed(KeyEvent e){
		int key=e.getKeyCode();
		if(Scenario.typeScenario != 0) {
			if(key == KeyEvent.VK_ESCAPE) {
				if(PauseMenu.active) {
					Window.enablecursor = false;
					PauseMenu.active=false;
				}
				else {
					PauseMenu.active=true;
					Window.enablecursor = true;
				}
			}
		}
	}
}
