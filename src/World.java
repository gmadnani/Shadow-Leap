import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class World {
	
	//initializing the initial player positions
	public static final float PLAYER_POSITION_Y = 720;
	public static final float PLAYER_POSITION_X= 512;
	
	//initializing the size of tile
	public static final float TILE_SIZE=48; 
	
	public static final String FROG = "assets/frog.png";
	
	//initializing the levels of the program
	public static final String LVL_1 = "assets/levels/0.lvl";
	public static final String LVL_2 = "assets/levels/1.lvl";
	
	//initializing the total number of holes
	public static final int NUMBER_OF_HOLES = 5;
	public static final int HOLE = 24;
	public static final int MIDDLE_HOLES = 96;
	
	//initializing sprites to a list
	private ArrayList<Sprite> list;
	
	//initializing holes to a list
	private ArrayList<TargetHoles> holes;
	
	private Frog player;
	
	private Lives life;
	
	//initializing level count
	private int counting_level=0;
	
	/**
	 * 
	 * @throws NumberFormatException
	 * @throws SlickException
	 */
	@SuppressWarnings("static-access")
	public World() throws NumberFormatException, SlickException {
		list = new ArrayList<Sprite>();
		
		//loading levels
		LoadingLevel level = new LoadingLevel();
		
		//loading level 1 sprites
		list = level.loadSprites(LVL_1);
		
		//creating frog in the initial location
		player = new Frog(FROG, PLAYER_POSITION_X, PLAYER_POSITION_Y);
		life = new Lives();
		holes = new ArrayList<TargetHoles>();
	
		for (int i = 1; i<NUMBER_OF_HOLES * 2; i = i+2) {
			holes.add(new TargetHoles((MIDDLE_HOLES * i), HOLE));
		}
	}
	
	/**
	 * 
	 * @param g
	 * @throws SlickException
	 */
	//printing out the player and sprites
	public void render(Graphics g) throws SlickException{
	
		for (Sprite sprite : list) {
			sprite.render();
		}
		player.render();
		life.render();
		
		for(TargetHoles sprite: holes) {
		
			if(sprite.status()) {
				Image frog = new Image (FROG);
				frog.draw(sprite.getBounds().getX(),HOLE);
			}
		}
	}
	
	/**
	 * 
	 * @param input
	 * @param delta
	 * @throws NumberFormatException
	 * @throws SlickException
	 */
	@SuppressWarnings("static-access")
	//updating the levels and holes
	public void update(Input input, int delta) throws NumberFormatException, SlickException{
		player.update(input, delta);
		
		for (Sprite sprite : list) {
			sprite.update(input, delta);
		}
		int filledHoles = 0;
		
		for(TargetHoles sprite : holes) {
			
			//checking if sprite is in hole
			if (sprite.status())
				filledHoles++;
		}
		
		//checking if all holes are filled
		if (filledHoles == NUMBER_OF_HOLES) {
		
			//checking if last level
			if(counting_level == 1) {
				System.exit(0);
			}
			
			//moving on to next level
			counting_level++;
			LoadingLevel level = new LoadingLevel();
			
			//loading level 2 sprites
			list = (level.loadSprites(LVL_2));
			
			//Emptying holes for next level
			filledHoles=0;
			
			for(TargetHoles sprite:holes) {
				sprite.updateIntersected();
				
			}
		}
		
		//checking if player has meet eith the given coordinates
		player.checkIntersection(list, delta, input, holes);
	}
}
