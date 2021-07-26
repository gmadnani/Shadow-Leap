import java.io.BufferedReader;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.newdawn.slick.SlickException;

/**
 * The Class Loader.
 */
public class LoadingLevel {
	
	/**
	 * 
	 * @param filename
	 * @return
	 * @throws NumberFormatException
	 * @throws SlickException
	 */
	public static ArrayList<Sprite> loadSprites(String filename) throws NumberFormatException, SlickException{
		ArrayList<Sprite> list = new ArrayList<>();
		
		// Open the file
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line;
			
			while ((line = reader.readLine()) != null) {
				
				//splitting the csv lines by commas
				String[] parts = line.split(",");
				
				//checking cases for the sprites and the adding to the array list
				switch (parts[0]) {
				case "bike":
					list.add(new Bike ("assets/" + parts[0] + ".png", Float.parseFloat(parts[1]), Float.parseFloat(parts[2]), Boolean.parseBoolean(parts[3])));
					break;
				case "bulldozer":
					list.add(new Bulldozer ("assets/" + parts[0] + ".png", Float.parseFloat(parts[1]), Float.parseFloat(parts[2]), Boolean.parseBoolean(parts[3])));
					break;
				case "bus":
					list.add(new Bus ("assets/" + parts[0] + ".png", Float.parseFloat(parts[1]), Float.parseFloat(parts[2]), Boolean.parseBoolean(parts[3])));
					break;
				case "grass":
					list.add(new Grass ("assets/" + parts[0] + ".png", Float.parseFloat(parts[1]), Float.parseFloat(parts[2])));
					break;
				case "log":
					list.add(new Log ("assets/" + parts[0] + ".png", Float.parseFloat(parts[1]), Float.parseFloat(parts[2]), Boolean.parseBoolean(parts[3])));
					break;
				case "longLog":
					list.add(new Longlog ("assets/" + parts[0] + ".png", Float.parseFloat(parts[1]), Float.parseFloat(parts[2]), Boolean.parseBoolean(parts[3])));
					break;
				case "racecar":
					list.add(new Racecar ("assets/" + parts[0] + ".png", Float.parseFloat(parts[1]), Float.parseFloat(parts[2]), Boolean.parseBoolean(parts[3])));
					break;
				case "tree":
					list.add(new Tree ("assets/" + parts[0] + ".png", Float.parseFloat(parts[1]), Float.parseFloat(parts[2])));
					break;
				case "turtle":
					list.add(new Turtle ("assets/" + parts[0] + "s.png", Float.parseFloat(parts[1]), Float.parseFloat(parts[2]), Boolean.parseBoolean(parts[3])));
					break;
				case "water":
					list.add(new Water ("assets/" + parts[0] + ".png", Float.parseFloat(parts[1]), Float.parseFloat(parts[2])));
					break;
			}
		}
	}	catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}