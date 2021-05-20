package Core.GameInput;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import Core.Javaac.Window;
import Core.Player.PlayerData;

import com.github.strikerx3.jxinput.*;
import com.github.strikerx3.jxinput.enums.XInputAxis;
import com.github.strikerx3.jxinput.exceptions.XInputNotLoadedException;

public class KeyBoardListener extends KeyAdapter {
	private static PlayerData player;
	private ArrayList<Integer> keys;
	private TimerTask task;
	private Timer timer;
	private MenuCursor cursor;

	//////ROBAH WIP PER XINPUT
// Get some joystick inputs (XB360, ...) as sticks:

// Threshold for moving and rotating objects
	static final double MIN_THRESHOLD_STICK_MOVING = 0.2;
	static final double THRESHOLD_STICK_ROTATION = 0.2;
	static final double THRESHOLD_TRIGGER_ARMT_LANCT = 0.5;

	// Low-pass filter for X and Y
	final static int NB_SAMPLES_ACQ_ROTATION = 3;
	final static int FILTERING_WEIGHT_ROTATION = NB_SAMPLES_ACQ_ROTATION * (NB_SAMPLES_ACQ_ROTATION+1) / 2;
	final static int WEIGHTS_SUM = NB_SAMPLES_ACQ_ROTATION * (NB_SAMPLES_ACQ_ROTATION+1) / 2;

	// The rotation with the previous values saved on X and Y axes
	static LinkedList<Double> sampleAcqRotationX = new LinkedList<Double>();
	static LinkedList<Double> sampleAcqRotationY = new LinkedList<Double>();
	static double averageRotationOnX = 0;
	static double averageRotationOnY = 0;


	XInputDevice device0;
	boolean bJoystickOKandConnectedToThisPlatform;
	//choixDuModeUtilisationDuJeu = IHMpossibles.JOYSTICK;
	XInputButtons boutons;
	XInputButtonsDelta boutonsDelta;
	XInputComponents components;
	XInputComponentsDelta componentsDelta;
	XInputAxes axes;
	XInputAxesDelta axesDelta;


    public KeyBoardListener(MenuCursor c) {
		keys=new ArrayList<Integer>();
		cursor=c;

		if(XInputDevice14.isAvailable()) {
			try { 
				 // 1st device of the Joystick
				device0 = XInputDevice.getDeviceFor(0);
				if (device0.isConnected()) {
					
					System.out.println("I'm online");
					bJoystickOKandConnectedToThisPlatform = true;
				//	choixDuModeUtilisationDuJeu = IHMpossibles.JOYSTICK;
					components = device0.getComponents();
					boutons = components.getButtons();
					componentsDelta = device0.getDelta();
					boutonsDelta = componentsDelta.getButtons();
					axesDelta = componentsDelta.getAxes();
					axes = components.getAxes();

					for (int i=0; i< NB_SAMPLES_ACQ_ROTATION; i++){
						sampleAcqRotationX.add(0.0);
						sampleAcqRotationY.add(0.0);
					}
				}
			} 
			catch (XInputNotLoadedException e) { e.printStackTrace(); }
		}
	}

	public void keyPressed(KeyEvent e){
		int key= e.getKeyCode();
		if(!keys.contains(key)){
			keys.add(key);
		}
		if(timer!=null)
			return;
		task = new TimerTask(){
			@Override
			public void run() {
				try { Thread.sleep(3); }
				catch (InterruptedException e1) { e1.printStackTrace(); }
				for(Integer i=0; i<keys.size(); i++){
					try {
						if(keys.get(i) != null)
							if(!Window.enablecursor && player != null){
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
							else {
								if(keys.get(i) == KeyEvent.VK_D){
									cursor.move(1, 0);
								}
								if(keys.get(i) == KeyEvent.VK_A){
									cursor.move(-1, 0);
								}
								if(keys.get(i) == KeyEvent.VK_S){
									cursor.move(0, 1);
								}
								if(keys.get(i) == KeyEvent.VK_W){
									cursor.move(0, -1);
								}
							}
					} catch(IndexOutOfBoundsException e) { e.printStackTrace(); }
				}
				
				//////XINPUT
				
				if (device0.poll()) {

					// Right stick events: raw values
					double posRX = axes.get(XInputAxis.RIGHT_THUMBSTICK_X);
					double posRY = axes.get(XInputAxis.RIGHT_THUMBSTICK_Y);
					boolean bStickRightActif = false;
					if ((Math.abs(posRX) > THRESHOLD_STICK_ROTATION) || (Math.abs(posRY) > THRESHOLD_STICK_ROTATION)) {
						bStickRightActif = true;
					}
		  
					// Left stick events: raw values
					double posLX = axes.get(XInputAxis.LEFT_THUMBSTICK_X);
					double posLY = axes.get(XInputAxis.LEFT_THUMBSTICK_Y);
					boolean bStickLeftActif = false;
					if ((Math.abs(posLX) > MIN_THRESHOLD_STICK_MOVING) || (Math.abs(posLY) > MIN_THRESHOLD_STICK_MOVING)) {
						bStickLeftActif = true;
					 }
		  
		  		// here your code of other events of your Joystick:
		  
		  
		  
		  		// _______________________________________
		  
					if (bStickLeftActif) { // moving case
							double[] deplactXY = {0.0,0.0};
							deplactXY[0] =  1000* posLX; 
							deplactXY[1] =  - 1000 * posLY; 
						// and now, your code for moving your object is here
					
					}
					else { // rotation case
						// remove the oldest value and add the new one (for X and Y)
						sampleAcqRotationX.removeFirst();
						sampleAcqRotationY.removeFirst();
						sampleAcqRotationX.add(posRX);
						sampleAcqRotationY.add(posRY);
			
						double sumX = 0;
						double sumY = 0;
						double sampleWeight=0;
					
				  	// The filtering by calculating the weighted values (the highest weight for the more recent value, the lowest weight for the oldest value)
					// and, then, computing the average values 
						int sizeSampleList = sampleAcqRotationX.size();
						for (int i=0; i < sizeSampleList; i++) {
							sampleWeight++; // from 1 to NB_SAMPLES_ACQ_ROTATION, necessarily
							sumX += sampleWeight * sampleAcqRotationX.get(i);
							sumY += sampleWeight * sampleAcqRotationY.get(i);
						}
		  
						averageRotationOnX = sumX / WEIGHTS_SUM;
						averageRotationOnY = sumY / WEIGHTS_SUM;
		  
		  
					 // and now, your code for rotating your object is here
					}
			  	} // end poll
				
				  ///////
				if(player!=null && keys.size()<=0) {
					try { Thread.sleep(10); }
					catch (InterruptedException e1) { e1.printStackTrace(); }
					player.move(0,0);
				}
			}
		};
		timer = new Timer(true);
		timer.scheduleAtFixedRate(task, 0, 2);
	}

	public void keyReleased(KeyEvent e){
		Integer key = e.getKeyCode();
		if(timer!=null && keys.size()<=0){
			timer.cancel();
			timer = null;
		}

		if(keys.contains(key)) {
			keys.remove(key);
		}
	}

	public boolean enterPressed() {
		for(int i=0; i<keys.size(); i++){
			if(keys.get(i) == KeyEvent.VK_ENTER){
				return true;
			}
		}
		return false;
	}
	public boolean escapePressed() {
		for(int i=0; i<keys.size(); i++){
			if(keys.get(i) == KeyEvent.VK_ESCAPE){
				return true;
			}
		}
		return false;
	}
	public static void addPlayer(PlayerData playerData) {
		player = playerData;
	}
}
