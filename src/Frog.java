import org.newdawn.slick.Input;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;

import utilities.BoundingBox;

public class Frog extends Sprite {
	
	public static final int TILE_SIZE = 48;
	public static final int INITIAL_PLAYER_Y = 720;
	public static final int INITIAL_PLAYER_X= 512;
	public static final int WATER_Y= 336;
	public static final int SCREEN_WIDTH= 1024;
	public static final int SCREEN_HEIGHT= 768;
	
	private static Image frog;
	
	private static BoundingBox bound_frog;
	
	//initializing the killable and rideable objects
	private static String [] KILLABLE = {"assets/bus.png","assets/bike.png","assets/racecar.png"};
	private static String [] RIDEABLE = {"assets/log.png","assets/longLog.png","assets/turtles.png"};
	
	//initializing previous coordinates
	private float previousY;
	private float previousX;
	
	private int direction;
	
	private float velocity;
	
	Lives life;
	
	/**
	 * 
	 * @param Path
	 * @param x
	 * @param y
	 * @throws SlickException
	 */
	public Frog(String Path, float x, float y) throws SlickException{
		super(Path, x, y);
		frog= new Image(Path);
		velocity=0.0f;
		direction=1;
		life=new Lives();
	}
	
	@Override
	//updating player movement
	public void update(Input input, int delta) {

		if (input.isKeyPressed(Input.KEY_LEFT)) {
			previousY = getY();
			previousX = getX();
			setX(getX() - TILE_SIZE);
			velocity=0;
		}
		
		if (input.isKeyPressed(Input.KEY_RIGHT)) {
			previousY = getY();
			previousX = getX();
			setX(getX() + TILE_SIZE);
			velocity=0;
		}
		
		if (input.isKeyPressed(Input.KEY_DOWN)) {
			previousY = getY();
			previousX = getX();
			setY(getY() + TILE_SIZE);
			velocity=0;
		}
		
		if (input.isKeyPressed(Input.KEY_UP)) {
			previousY = getY();
			previousX = getX();
			setY (getY() - TILE_SIZE);
			velocity=0;
		}
		
		if(getX() <= 0) {
			setX(TILE_SIZE/2);
		}
		
		if(getY() < 0) {
			setY(0);
		}
		
		if(getX() >= SCREEN_WIDTH) {
			setX(SCREEN_WIDTH-TILE_SIZE);
		}
		
		if(getY() >= SCREEN_HEIGHT) {
			setY(SCREEN_HEIGHT-TILE_SIZE);
		}
		setX(getX()+velocity*delta*direction);
		bound_frog = new BoundingBox(frog, getX(), getY());
		
	}
	
	public void render() {
		frog.drawCentered(getX(),getY());
	}
	
	/**
	 * 
	 * @return
	 */
	public BoundingBox getfrg() {
		return bound_frog;
	}
	
	/**
	 * 
	 * @param list
	 * @param delta
	 * @param input
	 * @param holes
	 */
	//checking intersection with sprites
	public void checkIntersection(ArrayList<Sprite> list, int delta, Input input, ArrayList<TargetHoles> holes) {
		
		boolean rideableStatus = false;
		boolean waterStatus = false;
		
		for (Sprite sprite : list) {
		
			for(int i = 0; i < 3; i++) {
				
				//checking intersection with killable sprites
				if (sprite.type.equals(KILLABLE[i])) {
				
					if (bound_frog.intersects(sprite.getBounds())) {
						
						//reducing player lives
						life.reduceLives();
						
						//reseting player
						resetPlayer();
					}
				}
			}
			
			//pushing the player against the bulldozer
			if (sprite.type.equals("assets/bulldozer.png") && bound_frog.intersects(sprite.getBounds())) {
				velocity = ((Movable)sprite).getVelocity();
				setX(sprite.getX() + (TILE_SIZE));
				
				//losing life when off the screen
				if (getX() >=SCREEN_WIDTH - (TILE_SIZE)) {
					life.reduceLives();
					resetPlayer();
				}
			}
			
			//checking if frog touched the water	
			if (sprite.type.equals("assets/water.png") && bound_frog.intersects(sprite.getBounds())) {
				waterStatus = true;
			}
			
		for(int i=0; i<3; i++) {
			
			//checking intersection with rideable objects
			if (sprite.type.equals(RIDEABLE[i]) && bound_frog.intersects(sprite.getBounds())) {
				
				if((i==2) && ((Turtle)sprite).getTime() <= 7){
						velocity = ((Movable)sprite).getVelocity();
						direction = ((Movable)sprite).getDirection();
						rideableStatus = true;
					}
				
					else if (i != 2) {
						velocity = ((Movable)sprite).getVelocity();
						direction = ((Movable)sprite).getDirection();
						rideableStatus = true;
					}
				}
			}
			
			//checking intersection with trees
			if (sprite.type.equals("assets/tree.png") && bound_frog.intersects(sprite.getBounds())) {
				
				//solid tile; not able to walk on it
				setX(previousX);
				setY(previousY);
			}
		}
		
		if(waterStatus) {
			
			if(!rideableStatus) {
				
				//reducing life if in contact with water
				life.reduceLives();
				
				//reseting the player to starting position
				resetPlayer();
			}
		}
		
		for(TargetHoles sprite : holes) {
			
			//checking if the tries filling the hole
			if(bound_frog.intersects(sprite.getBounds())) {
				if(!sprite.status()) {
					sprite.updateIntersected();
					
					//reseting the player to starting position
					resetPlayer();
				}
				
				//checking if the tries filling the hole again
				else {
					
					//reducing life if in contact with water
					life.reduceLives();
					//reseting player to starting position
					resetPlayer();
				}
			}
		}
	}
	
	//function to reset player to starting position 
	public void resetPlayer() {
		setX(INITIAL_PLAYER_X);
		setY(INITIAL_PLAYER_Y);
		velocity=0;
	}
}
