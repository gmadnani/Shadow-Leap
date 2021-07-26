import org.newdawn.slick.Input;

import org.newdawn.slick.SlickException;

public class Movable extends Sprite {
	
	public static final float SCREEN_WIDTH = 1024;
	public static final float TILE_SIZE = 48;
	private int direction;
	private float velocity;
	
	/**
	 * 
	 * @param Path
	 * @param x
	 * @param y
	 * @param moveRight
	 * @throws SlickException
	 */
	public Movable(String Path, float x, float y, boolean moveRight) throws SlickException {
		
		super (Path ,x ,y);
		
		//giving direction to the moving object
		if (moveRight) {
			direction = 1;
		}
		
		else {
			direction = -1;
		}
	}
	
	@Override
	//updating the moving object by implementing its speed and direction
	public void update(Input input, int delta) {
		
		if (getBounds().getLeft() >= SCREEN_WIDTH && (direction == 1)){
			super.setX((-1 * getBounds(). getWidth()/2));
		}
	
		else if (getBounds().getRight() <= 0 && (direction == (-1))) {
			super.setX(SCREEN_WIDTH + getBounds().getWidth()/2);
		}
		
		super.setX(super.getX() + velocity * delta * direction);
	}
	
	public void render() {
		super.render();
	}
	
	/**
	 * 
	 * @return
	 */
	//getting the velocity of the moving object
	public float getVelocity() {
		return velocity;
	}
	
	/**
	 * 
	 * @param velocity
	 */
	//setting the velocity of the moving object
	public void setVelocity(float velocity) {
		this.velocity = velocity;
	}
	
	/**
	 * 
	 * @return
	 */
	//getting the direction of the moving object
	public int getDirection(){
		return direction;
	}
}
