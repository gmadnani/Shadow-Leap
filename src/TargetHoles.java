import org.newdawn.slick.SlickException;

import utilities.BoundingBox;

public class TargetHoles {
	public static final float WIDTH = 96;
	public static final float HEIGHT = 48;
	
	public boolean INTERSECT = false;
	
	private BoundingBox bounds;
	/**
	 * 
	 * @param x
	 * @param y
	 * @throws SlickException
	 */
	public TargetHoles(float x, float y)throws SlickException{
		bounds = new BoundingBox (x,y, WIDTH, HEIGHT);
	}
	
	//checking if the tile coordinates meets the frogs coordinates
	public BoundingBox getBounds(float[] coordinates) {
		return bounds;
	}
	
	//updating the hole for next level
	public void updateIntersected() {
		INTERSECT = !INTERSECT;
	}
	
	public BoundingBox getBounds(){
		return bounds;
	}
	
	//checking if the frog has reached the hole
	public boolean status() {
		return INTERSECT;
	}
}
