import utilities.BoundingBox;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Sprite {
	
	public String type;
	
	private float coordinateY;
	private Image objects;
	private BoundingBox bounds;
	private float coordinateX;
	
	/**
	 * 
	 * @param Path
	 * @param x
	 * @param y
	 * @throws SlickException
	 */
	public Sprite(String Path, float x, float y) throws SlickException {
		type = Path;
		
		objects = new Image(Path);

		this.coordinateY = y;
		this.coordinateX = x;
		
		//coordinates of the sprites
		bounds = new BoundingBox(objects, (int)x , (int)y);
	}
	
	/**
	 * 
	 * @return
	 */
	public float getX() {
		return coordinateX;
	}
	
	/**
	 * 
	 * @param coordinateX
	 */
	public void setX(float coordinateX) {
		this.coordinateX = coordinateX;
		bounds.setX((int)coordinateX);

	}
	
	/**
	 * 
	 * @return
	 */
	public float getY() {
		return coordinateY;
	}
	
	/**
	 * 
	 * @param coordinateY
	 */
	public void setY(float coordinateY) {
		this.coordinateY = coordinateY;
		bounds.setY((int)coordinateY);
	}
	
	/**
	 * 
	 * @return
	 */
	public BoundingBox getBounds() {
		return bounds;
	}

	public void update(Input input, int delta) {};

	public void render() {
		 objects.drawCentered(coordinateX, coordinateY);
	}
}