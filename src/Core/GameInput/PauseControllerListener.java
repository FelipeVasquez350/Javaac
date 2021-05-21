package Core.GameInput;

import Core.Javaac.Scenario;
import Core.Javaac.Window;
import Core.Javaac.Scenarious.PauseMenu;

public class PauseControllerListener implements Runnable{
	private Thread t;
	public PauseControllerListener() {
		t = new Thread(this);
		t.start();
	}
	public void isPressed() {
		if(ControllerListener.START && Scenario.typeScenario != 0) {
			if(PauseMenu.active){
				PauseMenu.active=false;
				Window.enablecursor = false;
			}
			else {
				PauseMenu.active=true;
				Window.enablecursor = true;
			}
		}
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			isPressed();
		}

	}
}
