import org.newdawn.slick.Input;

import org.newdawn.slick.SlickException;

public class Turtle extends Rideable {
		
		//initializing the turtle's speed
		private static final float SPEED_TURTLE = 0.085f;
		
		//initializing the time for the turtle
		private static float time;
		private float previousX;
		private float previousY;

		/**
		 * 
		 * @param imageSrc
		 * @param x
		 * @param y
		 * @param moveright
		 * @throws SlickException
		 */
		public Turtle(String imageSrc, float x, float y, boolean moveright) throws SlickException {		
		super(imageSrc, x, y, moveright);
		super.setVelocity(SPEED_TURTLE);
		time = 0;
		}
		
		//checking the of the turtle and updating if the turtle is submerged or not
		public void update (Input input, int delta) {
			time = time + (delta * 0.0001f);
			
			if (time <= 7) {
				super.update(input, delta);
				previousX = super.getX();
				previousY = super.getY();
			}
		
			if (time>= 9) {
				time = 0;
				super.setX(previousX);
				super.setY(previousY);
			}
		}
		
		public void render() {
			if(time <= 7) {
				super.render();
			}
		}
		
		public float getTime() {
			return time;
		}
}