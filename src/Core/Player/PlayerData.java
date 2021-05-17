package Core.Player;

import java.io.IOException;

import Core.DrawHelpers.Sprite;
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
	public int x,y;
	private float devilPact = 0.00f;
	private float anglePact = 0.00f;
	private boolean piercing = false;
	private boolean spectral = false;
	public Sprite Sprite;

	public PlayerData(String spritePath) {
		try {
			this.Sprite = new Sprite("./src/Assets/Menu/cursor.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public float getDamage() {
		return damage;
	}
	public void setDamage(float damage) {
		this.damage = damage;
	}
	public float getKnockback() {
		return knockback;
	}
	public void setKnockback(float knockback) {
		this.knockback = knockback;
	}
	public float getTears() {
		return tears;
	}
	public void setTears(float tears) {
		this.tears = tears;
	}
	public float getRange() {
		return range;
	}
	public void setRange(float range) {
		this.range = range;
	}
	public float getShootSpeed() {
		return shootSpeed;
	}
	public void setShootSpeed(float shootSpeed) {
		this.shootSpeed = shootSpeed;
	}
	public float getLuck() {
		return luck;
	}
	public void setLuck(float luck) {
		this.luck = luck;
	}
	public float getDevilPact() {
		return devilPact;
	}
	public void setDevilPact(float devilPact) {
		this.devilPact = devilPact;
	}
	public float getAnglePact() {
		return anglePact;
	}
	public void setAnglePact(float anglePact) {
		this.anglePact = anglePact;
	}
	public boolean isPiercing() {
		return piercing;
	}
	public void setPiercing(boolean piercing) {
		this.piercing = piercing;
	}
	public boolean isSpectral() {
		return spectral;
	}
	public void setSpectral(boolean spectral) {
		this.spectral = spectral;
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
	public boolean move(int x, int y){
		setX(getX()+ x);
		setY(getY() + y);
		return true;
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
