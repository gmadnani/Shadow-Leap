import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Lives {
	public static String LIFE= "assets/lives.png";
	
	//initializing total number of lives
	public static int TOTAL_LIVES= 3;
	
	public static float INITIAL_X= 24f;
	public static float INITIAL_Y= 744f;
	public static float DIFFERENCE= 32f;
	
	private Image obj;
	
	//initializing current number of lives
	private static int NUMBER_OF_LIVES;
	
	/**
	 * 
	 * @throws SlickException
	 */
	public Lives() throws SlickException{
		NUMBER_OF_LIVES = TOTAL_LIVES;
		obj = new Image(LIFE);
	}
	
	//function to increase life if extra life is caught
	public void addLives() {
		NUMBER_OF_LIVES++;
	}
	
	
	//function to reduce a live when life is lost
	public void reduceLives() {
		NUMBER_OF_LIVES--;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getLives() {
		return NUMBER_OF_LIVES;
	}
	
	public void render() {
		float x = INITIAL_X;
		float y = INITIAL_Y;
		for(int i=0; i < getLives(); i++) {
			obj.drawCentered(x, y);
			x+=DIFFERENCE;
		}
		
		//checking if there are no lives left then the game will end
		if (getLives()<=0)
			System.exit(0);
	}
}
