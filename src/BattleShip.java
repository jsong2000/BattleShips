
import java.util.Scanner;

import model.Board;
import model.Location;
import model.Orientation;
public class BattleShip {
	private static final int[] SHIP_SIZES = {2, 3, 3, 4, 5};
	
	public static void main(String [] args){
		final Board board = new Board(10);
		final Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Battleship!");
		for (int shipSize : SHIP_SIZES) {
			System.out.printf("Ship size %d\n", shipSize);
			System.out.println("Please enter the enter coordinates");
			final String locationString = scanner.nextLine();
			final Location location = Location.getLocationFromString(locationString);
			System.out.println("Please enter the orientation");
			final String orientationString = scanner.nextLine();
			final Orientation orientation = Orientation.fromString(orientationString);
			board.addShip(shipSize, location, orientation);
		}
		scanner.close();
	}
}
