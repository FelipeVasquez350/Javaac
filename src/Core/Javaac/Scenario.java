package Core.Javaac;

import Core.GameInput.KeyBoardListener;
import Core.Javaac.Scenarious.Menu;
import Core.Javaac.Scenarious.Scene;
import Core.Player.PlayerData;

public class Scenario implements Runnable{
    private Thread scenario;
    private Scene currentScenario;
    private KeyBoardListener keyboard;
    private PlayerData player;

    public Scenario() {
        this.currentScenario = new Menu();
        this.keyboard = Window.getKeyBoard();
        this.player = Window.getPlayer();
       
        scenario = new Thread(this);
        scenario.setPriority(Thread.MAX_PRIORITY);
        scenario.start();
    }

    /*public void setScenario(int select){
        switch(select){
            case 0 -> {Menu}
            default ->{exit}
        }
    }*/

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1);            
                currentScenario.Update(this.keyboard, this.player);
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
