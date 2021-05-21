package Core.Javaac.Scenarious;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Core.DrawHelpers.Sprite;
import Core.GameInput.ControllerListener;
import Core.GameInput.KeyBoardListener;
import Core.GameInput.MenuCursor;
import Core.Javaac.Button;
import Core.Javaac.Scenario;
import Core.Javaac.Window;
import Core.Player.PlayerData;


public class Options implements Scene{ 
	private Button button1;
    public Options() {
        try { 
            button1 = new Button(450, 820, 180, 36, new Sprite("./src/Assets/Options/FumoMode.png"), new Sprite("./src/Assets/Options/FumoModeHighlight.png"), true); 
            initButtons();
            Window.Offsety=-200;
            Window.getButtons().get(4).selected=false;
        }
        catch (IOException e) { e.printStackTrace(); }
    }

    @Override
    public void initBackground() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void initButtons() {
        //TODO Auto-generated method stub
        ArrayList<Button> a = (ArrayList)Window.getButtons().clone();
        a.add(button1);
        Window.setButtons(a);

    }

    @Override
    public void Update(KeyBoardListener keyboard, MenuCursor cursor) {
        if(ControllerListener.B) {
            Window.Offsety=0;
            Scenario.setScenario(0);
        }
        for (Button button : Window.getButtons()) {
            if(Window.getButtons().size()>5) {
                if (button == Window.getButtons().get(5) && button.x < cursor.x && button.x + button.width > cursor.x && button.y < cursor.y-Window.Offsety && button.y + button.height > cursor.y-Window.Offsety) {
                    button.selected = true;
                }
                else
                    button.selected = false; 
                if (button.clicked() && button == Window.getButtons().get(5)) 
                    Window.FUMOMODE=!Window.FUMOMODE;
            }

        }
        
    }

}
