package Core.Javaac.Scenarious;

import java.util.ArrayList;
import Core.DrawHelpers.Sprite;
import Core.GameInput.KeyBoardListener;
import Core.Javaac.Button;
import Core.Player.PlayerData;
import Core.Projectile.Projectile;

public interface Scene {
    public Sprite background = null;
    public ArrayList<Button> buttons = new ArrayList<Button>();
  /*  public PlayerData player = null;
    public ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
    //public Room room = null; TODO_LATER
    //public ArrayList<NPC> npcs = new ArrayList<NPC>();; TODO_LATER
*/
    public void initBackground();
    public void initButtons();
 /*   public void initPlayer();
    public void initProjectiles()
   */ 

    public void Update(KeyBoardListener keyboard, PlayerData player);
    //-> setButtons(ArrayList<Button> buttons);
 /*   public void setUpPlayer(args); -> setPlayer(PlayerData player);
    public void setUpProjectiles(args); -> setProjectiles(Projectile projectile);
    */
}