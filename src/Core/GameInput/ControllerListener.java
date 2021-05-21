package Core.GameInput;

import com.github.strikerx3.jxinput.*;
import com.github.strikerx3.jxinput.enums.*;
import com.github.strikerx3.jxinput.exceptions.XInputNotLoadedException;
import com.github.strikerx3.jxinput.listener.SimpleXInputDeviceListener;

import Core.Javaac.Window;
import Core.Player.PlayerData;

public class ControllerListener extends SimpleXInputDeviceListener implements Runnable{

	private Thread controller;
    private MenuCursor cursor;
    private static PlayerData player;
    private XInputDevice14 device0;

    public static boolean LT, RT, LB, RB, START, BACK, A, B, X, Y, LX, LY, RX, RY, DPAD_UP, DPAD_DOWN, DPAD_LEFT, DPAD_RIGHT, LEFT_THUMBSTICK_UP, LEFT_THUMBSTICK_DOWN, LEFT_THUMBSTICK_LEFT, LEFT_THUMBSTICK_RIGHT;


    public ControllerListener(MenuCursor c) {
        cursor=c;

        controller = new Thread(this);
		controller.setPriority(Thread.MAX_PRIORITY);
        controller.start();
    }

    //not very useful rn but why not
    @Override
	public void connected() {
		// Resume the game
	System.out.println("Helo");
	}
					
	@Override
	public void disconnected() {
		// Pause the game and display a message
    }
					
    @Override
    public void buttonChanged(final XInputButton button, final boolean pressed) {
		// The given button was just pressed (if pressed == true) or released (pressed == false)
		System.out.println("Helo");
	}

    //listener part
    @Override
    public void run() { 
        try {
            device0 = XInputDevice14.getDeviceFor(0);
            if (device0.isConnected()) {
                
                XInputBatteryInformation gamepadBattInfo = device0.getBatteryInformation(XInputBatteryDeviceType.GAMEPAD);
                System.out.println("I'm online "+gamepadBattInfo.getLevel());
               
                while(true){
                    try { Thread.sleep(3); }
                    catch (InterruptedException e1) { e1.printStackTrace(); }
                   
                    if (device0.poll()) {
        
                        XInputComponentsDelta delta = device0.getDelta();
                        XInputButtonsDelta buttons = delta.getButtons();
                        XInputAxesDelta axes = delta.getAxes();
                        XInputAxes axes2 = device0.getComponents().getAxes();;


                        if (buttons.isPressed(XInputButton.LEFT_THUMBSTICK)) {
                            System.out.println("LB");
                            LT = true;
                        }
                        else if(buttons.isReleased(XInputButton.LEFT_THUMBSTICK))
                            LT = false;
                                    
                        if (buttons.isPressed(XInputButton.RIGHT_THUMBSTICK)) {
                            System.out.println("RB");
                            RT = true;
                        }
                        else if(buttons.isReleased(XInputButton.RIGHT_THUMBSTICK))
                            RT = false;


                        ////////////////////////////////////////////////////////////


                        if (buttons.isPressed(XInputButton.LEFT_SHOULDER)) {
                            System.out.println("LB");
                            LB = true;
                        }
                        else if(buttons.isReleased(XInputButton.LEFT_SHOULDER))
                            LB = false;
                         
                        if (buttons.isPressed(XInputButton.RIGHT_SHOULDER)) {
                            System.out.println("RB");
                            RB = true;
                        }
                        else if(buttons.isReleased(XInputButton.RIGHT_SHOULDER))
                            RB = false;


                        ////////////////////////////////////////////////////////////


                        if (buttons.isPressed(XInputButton.START)) {
                            System.out.println("START");
                            START = true;
                        }
                        else if(buttons.isReleased(XInputButton.START))
                            START = false;
                         
                        if (buttons.isPressed(XInputButton.BACK)) {
                            System.out.println("BACK");
                            BACK = true;
                        }
                        else if(buttons.isReleased(XInputButton.BACK))
                            BACK = false;


                        ////////////////////////////////////////////////////////////


                        if (buttons.isPressed(XInputButton.DPAD_UP)) {
                            DPAD_UP=true;
                            System.out.println("D-UP");
                        }
                        else if (buttons.isReleased(XInputButton.DPAD_UP)) 
                            DPAD_UP=false;
 

                        if (buttons.isPressed(XInputButton.DPAD_DOWN)) {
                            DPAD_DOWN=true;
                            System.out.println("D-DOWN");
                        }
                        else if (buttons.isReleased(XInputButton.DPAD_DOWN)) 
                            DPAD_DOWN=false;
            

                        if (buttons.isPressed(XInputButton.DPAD_LEFT)) {
                            DPAD_LEFT=true;
                            System.out.println("D-LEFT");
                        }
                        else if (buttons.isReleased(XInputButton.DPAD_LEFT)) 
                            DPAD_LEFT=false;
                       

                        if (buttons.isPressed(XInputButton.DPAD_RIGHT)) {
                            DPAD_RIGHT=true;
                            System.out.println("D-RIGHT");
                        }
                        else if (buttons.isReleased(XInputButton.DPAD_RIGHT)) 
                            DPAD_RIGHT=false;
                      

                        ////////////////////////////////////////////////////////////


                        if (buttons.isPressed(XInputButton.A)) {
                            System.out.println("A");
                            A = true;
                        }    
                        else if (buttons.isReleased(XInputButton.A))
                            A = false;


                        if (buttons.isPressed(XInputButton.B)) {
                            System.out.println("B");
                            B = true;
                        }    
                        else if (buttons.isReleased(XInputButton.B))
                        B = false;


                        if (buttons.isPressed(XInputButton.X)) {
                            System.out.println("X");
                            X = true;
                        }    
                        else if (buttons.isReleased(XInputButton.X))
                            X = false;
                           
                            
                        if (buttons.isPressed(XInputButton.Y)) {
                            System.out.println("Y");
                            Y = true;
                        }    
                        else if (buttons.isReleased(XInputButton.Y))
                            Y = false;
                                            
                            
                        ////////////////////////////////////////////////////////////
                        ////////////////////////////////////////////////////////////


                        if(axes2.get(XInputAxis.LEFT_THUMBSTICK_Y) > 0.6)
                            LEFT_THUMBSTICK_UP = true;
                        else 
                            LEFT_THUMBSTICK_UP = false;

                        if(axes2.get(XInputAxis.LEFT_THUMBSTICK_Y) < -0.6)
                            LEFT_THUMBSTICK_DOWN = true;
                        else 
                            LEFT_THUMBSTICK_DOWN = false;   

                        if(axes2.get(XInputAxis.LEFT_THUMBSTICK_X) < -0.6)
                            LEFT_THUMBSTICK_LEFT = true;
                        else 
                            LEFT_THUMBSTICK_LEFT = false;   
                       
                        if(axes2.get(XInputAxis.LEFT_THUMBSTICK_X) > 0.6)
                            LEFT_THUMBSTICK_RIGHT = true;
                        else 
                            LEFT_THUMBSTICK_RIGHT = false;


                        if(!Window.enablecursor && player != null) {
                        
                            if(DPAD_UP)
                                player.move(0, -1);
                            else if(LEFT_THUMBSTICK_UP)  
                                player.move(0, -1);

                            if(DPAD_DOWN)
                                player.move(0, 1);
                            else if(LEFT_THUMBSTICK_DOWN)
                                player.move(0, 1);

                            if(DPAD_LEFT)
                                player.move(-1, 0);
                            else if(LEFT_THUMBSTICK_LEFT)
                                player.move(-1, 0);

                            if(DPAD_RIGHT)                            
                                player.move(1, 0);
                            else if(LEFT_THUMBSTICK_RIGHT)                            
                                player.move(1, 0);

                            if(!DPAD_UP && !DPAD_DOWN && !DPAD_LEFT && !DPAD_RIGHT && !LEFT_THUMBSTICK_UP && !LEFT_THUMBSTICK_DOWN && !LEFT_THUMBSTICK_LEFT && !LEFT_THUMBSTICK_RIGHT)
                                player.move(0, 0);
                        }

                        else {
                           if(DPAD_UP)
                                cursor.move(0, -1);
                            else if(LEFT_THUMBSTICK_UP)  
                                cursor.move(0, -1);

                            if(DPAD_DOWN)
                                cursor.move(0, 1);
                            else if(LEFT_THUMBSTICK_DOWN)
                                cursor.move(0, 1);

                            if(DPAD_LEFT)
                                cursor.move(-1, 0);
                            else if(LEFT_THUMBSTICK_LEFT)
                                cursor.move(-1, 0);

                            if(DPAD_RIGHT)                            
                                cursor.move(1, 0);
                            else if(LEFT_THUMBSTICK_RIGHT)                            
                                cursor.move(1, 0);
                        } 
                    }
                }
            }
        } catch (XInputNotLoadedException e) { e.printStackTrace(); }
    }

    public static void addPlayer(PlayerData playerData) {
		player = playerData;
	}

    public static boolean APressed() {
		if(A)
            return true;
		return false;
	}
}
