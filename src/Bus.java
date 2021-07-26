import org.newdawn.slick.SlickException;

public class Bus extends Movable {
	
	//initializing the bus's speed
	private static final float SPEED_BUS = 0.15f;
	
	/**
	 * 
	 * @param imageSrc
	 * @param x
	 * @param y
	 * @param moveright
	 * @throws SlickException
	 */
	public Bus(String imageSrc, float x, float y, boolean moveright) throws SlickException {		
		super(imageSrc, x, y, moveright);
		
		//setting the velocity of the bus
		setVelocity(SPEED_BUS);
	}
}
