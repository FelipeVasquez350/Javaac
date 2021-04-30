



public class PlayerData{
    private int health = 6;
    private float speed = 1.00f;
    private float damage = 3.50f;
    private float knockback = 1.00f;
    private float tears = 2.73f;
    private float range = 6.50f;
    private float shootSpeed = 1.00f;
    private float luck = 1.00f;
    private float x,y;
    private float devilPact = 0.00f;
    private float anglePact = 0.00f;

    private boolean piercing = false;
    private boolean spectral = false;



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
    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }
    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }
    public boolean move(float x, float y){
        setX(getX()+ x);
        setY(getY() + y);
        return true;
    }
    public void shot(String position){
        if(position.equalsIgnoreCase("Right")){

        }
        else if(position.equalsIgnoreCase("Up")){
 
        }
        else if(position.equalsIgnoreCase("Down")){
 
        }
        else if(position.equalsIgnoreCase("Left")){

        }
   }
    
}
