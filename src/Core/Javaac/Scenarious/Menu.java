package Core.Javaac.Scenarious;

import java.io.IOException;
import java.util.ArrayList;

import Core.DrawHelpers.Sprite;
import Core.Javaac.Button;
import Core.Javaac.Window;

public class Menu{
    public Button button;
    ArrayList<Button> buttons = new ArrayList<Button>();

    public Menu() {
        try {
            button = new Button(20, 20, 26, 16, new Sprite("./src/Assets/Menu/Button.png"), Window.k);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    
}
