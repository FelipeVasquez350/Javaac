package Core.Javaac.Scenarious;

import java.io.IOException;
import java.util.ArrayList;

import Core.DrawHelpers.Sprite;
import Core.Javaac.Button;
import Core.Javaac.Window;

public class Menu {
    public Button button;
    public ArrayList<Button> buttons = new ArrayList<Button>();
    public ArrayList<Sprite> spriteBottoni = new ArrayList<Sprite>();
    public ArrayList<Sprite> spriteBottoni2 = new ArrayList<Sprite>();

    public Menu() {
        try {
            Sprite bottoniMenu = new Sprite("./src/Assets/Menu/Tabs.png");
            Sprite bottoniMenu2 = new Sprite("./src/Assets/Menu/Tabs2.png");

            for (int i=0; i<5; i++) {
                spriteBottoni.add(bottoniMenu.grabFrame(0, i, 180, 36));
                spriteBottoni2.add(bottoniMenu2.grabFrame(0, i, 180, 36));

                buttons.add(new Button(60, 40*i, 180, 36, bottoniMenu.grabFrame(0, i, 180, 36), bottoniMenu2.grabFrame(0, i, 180, 36), Window.k));
               // if (i!=0)
                    //buttons.get(i).selected=false; 
            }
          //  button = new Button(20, 20, 26, 16, new Sprite("./src/Assets/Menu/Button.png"), Window.k);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
