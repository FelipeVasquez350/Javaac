package Core.GameInput;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Core.Javaac.Window;
import Core.Player.PlayerData;

public class KeyBoardListener extends KeyAdapter  {

    private Window window;
    private PlayerData player;
    private ArrayList<Integer> keys = new ArrayList<Integer>();
    TimerTask task;
    Timer timer;
    public KeyBoardListener(Window window, PlayerData p) {
        this.window = window;
        this.player = p;
    }
    public void keyPressed(KeyEvent e){
        int key= e.getKeyCode();
        


        if(!keys.contains((Integer) key)){
            keys.add((Integer) key);
        }

      
        if(timer!=null)
            return;
        
        
        task = new TimerTask(){
            @Override
            public void run() {
                for(int i=0; i<keys.size(); i++){
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
            }
            
        };
        
        timer = new Timer(true);
        timer.scheduleAtFixedRate(task, 0, 2);
        

    }
    
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        
        if(keys.contains((Integer) key))
            keys.remove((Integer) key);
        
        if(timer!=null && keys.size()<=0){
            timer.cancel();
            timer = null;
        }
            
    }
}
