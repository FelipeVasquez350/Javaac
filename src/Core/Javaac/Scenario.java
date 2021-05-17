package Core.Javaac;

import Core.GameInput.KeyBoardListener;
import Core.Javaac.Scenarious.RoomFloor1;
import Core.Javaac.Scenarious.Menu;
import Core.Javaac.Scenarious.Scene;
import Core.Player.PlayerData;

public class Scenario implements Runnable{
    private Thread scenario;
    private static Scene currentScenario;
    private KeyBoardListener keyboard;
    private PlayerData player;

    public Scenario() {
        currentScenario = new Menu();
        this.keyboard = Window.getKeyBoard();
        this.player = Window.getPlayer();
       
        scenario = new Thread(this);
        scenario.setPriority(Thread.MAX_PRIORITY);
        scenario.start();
    }

    public static void setScenario(int select){
        switch(select){
            case 0 -> currentScenario = new Menu();
            case 1 -> currentScenario = new RoomFloor1();
            default -> System.exit(0);
        }
    }

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
