package Core.Javaac.Scenarious;

import Core.DrawHelpers.Sprite;

public class PauseMenu {
	public static boolean active;
	public Sprite image;
	public PauseMenu(Sprite image) {
		PauseMenu.active=false;
		this.image=image;
		
	}
	public void resume() {
		active=false;
	}
	public void paused() {
		active=true;
	}
	public int close() {
		System.exit(0);
		return -1;
	}
}
