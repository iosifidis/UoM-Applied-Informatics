import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		
		Hotel h1 = new Hotel("Bellevue");
		Hotel h2 = new Hotel("Hermes");
		Hotel h3 = new Hotel("CityHotel");
		Hotel h4 = new Hotel("Panorama");
		
		ArrayList<Hotel> hotels = new ArrayList<Hotel>();
		hotels.add(h1);
		hotels.add(h2);
		hotels.add(h3);
		hotels.add(h4);
		
		try {
			FileOutputStream fileOut = new FileOutputStream("hotels.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(hotels);
			out.close();
			fileOut.close();		
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		
		InputFrame inputFrame = new InputFrame();
		
	}

}
