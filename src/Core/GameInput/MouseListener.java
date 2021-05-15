package Core.GameInput;

import java.awt.*;
import java.awt.event.*; 

public class MouseLogic implements MouseMotionListener{
    
    

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println(e.getX());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
    }    

    public int getX() {       
        return MouseInfo.getPointerInfo().getLocation().x;
    }

    public int getY() {
        return MouseInfo.getPointerInfo().getLocation().y;
    }
}
