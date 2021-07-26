import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Bike extends Movable {
	
	//initializing bike's speed
	private static final float SPEED_BIKE = 0.2f;
	
	/**
	 * 
	 * @param imageSrc
	 * @param x
	 * @param y
	 * @param moveright
	 * @throws SlickException
	 */
	public Bike(String imageSrc, float x, float y, boolean moveright) throws SlickException {		
		super(imageSrc, x, y, moveright);
		
		//setting the velocity of the bike
		setVelocity(SPEED_BIKE);
	}
	
	//updating the function of the bike
	public void update(Input input, int delta){
		super.update(input, delta);
		
		//setting the bike's movement between 24 to 1000
		if(super.getX() <= 24) {
			super.setVelocity((-1)*SPEED_BIKE);
		}
		if (super.getX() >= 1000) {
			super.setVelocity((1)* SPEED_BIKE);
		}
	}

}
