package Core.GameInput;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import Core.Javaac.Window;
import Core.Player.PlayerData;

public class KeyBoardListener extends KeyAdapter  {

    public Window window;

    public KeyBoardListener(Window window) {
        this.window = window;
    }
    public void keyPressed(KeyEvent e, PlayerData p){
        int key= e.getKeyCode();
        if(key == KeyEvent.VK_D){
           p.move(0.1f, 0f);
        }
        if(key == KeyEvent.VK_A){
            p.move(-0.1f, 0f);
        }
        if(key == KeyEvent.VK_S){
            p.move(0f, -0.1f);
        }
        if(key == KeyEvent.VK_W){
            p.move(0f, 0.1f);
        }
        if(key == KeyEvent.VK_RIGHT){
            p.shot("Right");
        }
        if(key == KeyEvent.VK_UP){
            p.shot("UP");
        }
        if(key == KeyEvent.VK_DOWN){
            p.shot("Down");
        }
        if(key == KeyEvent.VK_LEFT){
            p.shot("Left");
        }
    }
}
