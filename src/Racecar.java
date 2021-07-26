import org.newdawn.slick.SlickException;

public class Racecar extends Movable {
	
	//initialing the racecar's speed
	private static final float SPEED_RACECAR = 0.5f;
	/**
	 * 
	 * @param imageSrc
	 * @param x
	 * @param y
	 * @param moveright
	 * @throws SlickException
	 */
	public Racecar(String imageSrc, float x, float y, boolean moveright) throws SlickException {		
		super(imageSrc, x, y, moveright);
		
		//setting the speed of the racecar
		setVelocity(SPEED_RACECAR);
	}
}
