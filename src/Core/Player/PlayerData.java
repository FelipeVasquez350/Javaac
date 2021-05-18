package Core.Player;

import java.io.IOException;
import java.util.ArrayList;

import Core.DrawHelpers.Sprite;
import Core.Javaac.Window;
import Core.Projectile.Projectile;

public class PlayerData{
	private int health = 6;
	private float speed = 1.00f;
	private float damage = 3.50f;
	private float knockback = 1.00f;
	private float tears = 2.73f;
	private float range = 6.50f;
	private float shootSpeed = 1.00f;
	private float luck = 1.00f;
	public int x = 500, y = 500;
	private int dx = 1, dy = -1; 
	private float devilPact = 0.00f;
	private float anglePact = 0.00f;
	private boolean piercing = false;
	private boolean spectral = false;
	public ArrayList<Sprite> Sprite;
	private int frame;
	private int currentFrame = 0;
	public Sprite head;
	public Sprite body;


	public PlayerData(Sprite head, Sprite body) {
		this.head = head;
		this.body = body;
		UpdatePlayerSprite();
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getdx() {
		return dx;
	}
	public void setdx(int dx) {
		this.dx = dx;
	}
	public int getdy() {
		return dy;
	}
	public void setdy(int dy) {
		this.dy = dy;
	}
	public boolean move(int x, int y){
		setX(getX()+ x);
		setY(getY() + y);
		
		dx= 1*(int)Math.signum(x);
		dy= 1*(int)Math.signum(y);
		return true;
	}
	public void UpdatePlayerSprite() {
		frame+=6;
		if(frame>5) {
			frame = 0;
			Sprite = new ArrayList<Sprite>();
			if (dx>0) {
				Sprite.add(head.grabFrame(0, currentFrame, 32, 32));
				Sprite.add(body.grabFrame(0, currentFrame, 32, 30));
			}
			else {
				Sprite.add(head.grabFrame(0, currentFrame, 32, 32));
				Sprite.add(body.grabFrame(0, currentFrame, 32, 30));
			}
			if (dy>0) {
				Sprite.add(head.grabFrame(0, currentFrame, 32, 32));
				Sprite.add(body.grabFrame(0, currentFrame, 32, 30));
			}
			else {
				Sprite.add(head.grabFrame(0, currentFrame, 32, 32));
				Sprite.add(body.grabFrame(0, currentFrame, 32, 30));
			}
		}
	}
	public void shot(String direction){
		if(direction.equalsIgnoreCase("Right")){
			new Projectile((int)getX(), (int)getY());
		}
		else if(direction.equalsIgnoreCase("Up")){
		}
		else if(direction.equalsIgnoreCase("Down")){
		}
		else if(direction.equalsIgnoreCase("Left")){
		}
	}

}
