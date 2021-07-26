import org.newdawn.slick.SlickException;

public class Log extends Rideable {
		
		//initializing the log's speed
		private static final float SPEED_LOG = 0.1f;
		
		/**
		 * 
		 * @param imageSrc
		 * @param x
		 * @param y
		 * @param moveright
		 * @throws SlickException
		 */
		public Log(String imageSrc, float x, float y, boolean moveright) throws SlickException {		
		super(imageSrc, x, y, moveright);
		super.setVelocity(SPEED_LOG);
	}
}
