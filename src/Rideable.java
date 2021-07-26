import org.newdawn.slick.SlickException;

public class Rideable extends Movable{
	/**
	 * 
	 * @param imageSrc
	 * @param x
	 * @param y
	 * @param moveright
	 * @throws SlickException
	 */
	public Rideable(String imageSrc, float x, float y, boolean moveright) throws SlickException {		
		super(imageSrc, x, y, moveright);
	}
}