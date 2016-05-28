package model;

import java.util.List;

public class Location {
	private final int mX;
	private final int mY;
	
	public static Location getLocationFromString(String string) {
		String[] components = string.split(",");
		if (components.length != 2) {
			return null;
		}
		final String x = components[0];
		final String y = components[1];
		try {
			return new Location(Integer.parseInt(x), Integer.parseInt(y));
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
	public Location(int x, int y){
		mX = x;
		mY = y;
	}
	
	public int getX() {
		return mX;
	}

	public int getY() {
		return mY;
	}
}
