import org.newdawn.slick.SlickException;

public class Longlog extends Rideable {
	
		//initializing the longlog's speed
		private static final float SPEED_LONGLOG = 0.07f;
		
		/**
		 * 
		 * @param imageSrc
		 * @param x
		 * @param y
		 * @param moveright
		 * @throws SlickException
		 */
		public Longlog(String imageSrc, float x, float y, boolean moveright) throws SlickException {		
		super(imageSrc, x, y, moveright);
		super.setVelocity(SPEED_LONGLOG);
	}
}