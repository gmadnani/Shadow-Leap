import org.newdawn.slick.SlickException;

public class Bulldozer extends Movable {
	
	//initializing bulldozer's speed
	private static final float SPEED_BULLDOZER = 0.05f;
	
	/**
	 * 
	 * @param imageSrc
	 * @param x
	 * @param y
	 * @param moveright
	 * @throws SlickException
	 */
	public Bulldozer(String imageSrc, float x, float y, boolean moveright) throws SlickException {		
		super(imageSrc, x, y, moveright);
		
		//setting the velocity of the bulldozer
		setVelocity(SPEED_BULLDOZER);
	}
}