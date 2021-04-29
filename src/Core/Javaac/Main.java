package Core.Javaac;

import javax.swing.JFrame;
import Core.GameInput.MouseLogic;

public class Main extends JFrame implements Runnable{
    
    public Main() {
        Window window = new Window();
        add(window);
        pack();
        setTitle("Javaac");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(460, 5);
        setResizable(false);

        Thread main = new Thread(this);
        main.setPriority(Thread.MAX_PRIORITY);
        main.start();
    }
    
    public static void main(String[] args) throws Exception {
        JFrame JF = new Main();
        JF.setVisible(true);  
    }

    @Override
    public void run() {
        MouseLogic Mouse = new MouseLogic();
        addMouseMotionListener(Mouse);
        while (true) {
            System.out.println("Mouse X = "+(Mouse.getX()-getLocation().x-8)+", Y = "+(Mouse.getY()-getLocation().y-32));
        }        
    }
}

