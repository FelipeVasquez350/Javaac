package Core.Javaac.Scenarious;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Core.DrawHelpers.Sprite;
import Core.GameInput.KeyBoardListener;
import Core.Javaac.Button;
import Core.Javaac.Scenario;
import Core.Javaac.Window;
import Core.Player.PlayerData;


public class Menu implements Scene{
    
    private Sprite background;
    private ArrayList<Button> buttons = new ArrayList<Button>();
    private ArrayList<Sprite> spriteButtons = new ArrayList<Sprite>();
    private ArrayList<Sprite> spriteButtons2 = new ArrayList<Sprite>();
    
    public Menu() {
       
       initBackground();
       initButtons();
      /* initPlayer();
       initProjectiles();
       */
    }

	@Override
	public void initBackground() {
		try { background = new Sprite("./src/Assets/Menu/emptyscreen.png"); } 
        catch (IOException e) { e.printStackTrace(); }
        Window.setBackground(background);	
	}

	@Override
	public void initButtons() {
        try {
            Sprite bottoniMenu = new Sprite("./src/Assets/Menu/Tabs.png");
            Sprite bottoniMenu2 = new Sprite("./src/Assets/Menu/Tabs2.png");
            for (int i=0; i<5; i++) {
                spriteButtons.add(bottoniMenu.grabFrame(0, i, 180, 36));
                spriteButtons2.add(bottoniMenu2.grabFrame(0, i, 180, 36));
                buttons.add(new Button(410, 420+36*i, 180, 36, bottoniMenu.grabFrame(0, i, 180, 36), bottoniMenu2.grabFrame(0, i, 180, 36), Window.k, true));
                if (i!=0)
                    buttons.get(i).done=false;               
            }
            Window.setButtons(buttons);
        } 
        catch (IOException e) { e.printStackTrace(); }	
	}

    @Override
    public void Update(KeyBoardListener keyboard, PlayerData player) {
        for (Button button : buttons) {
            if (button.x < player.getX() && button.x + button.width > player.getX() && button.y < player.getY() && button.y + button.height > player.getY())
                button.selected = true;
            else
                button.selected = false; 

            if  (button.clicked() && !button.done) {
                Timer t = new Timer();
                t.schedule(new TimerTask() {
                int durata = 2;
                @Override
                public void run() {
                    Window.soon=true;
                    if (durata > 0) {                     
                        durata--;
                    }
                    else {
                        Window.soon=false;
                        t.cancel();
                    }
                }
                }, 0, 1000);   
            }
            else if (button.clicked() && button == buttons.get(0))
                Scenario.setScenario(1);

        } 

    }
}
