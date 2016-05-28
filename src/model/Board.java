package model;

import java.util.ArrayList;

public class Board {
	private final ArrayList<Ship> mShips = new ArrayList<>();
	private final int mSize;
	
	public Board(int size) {
		mSize = size;
	}
	
	public boolean addShip(int size, Location location, Orientation orientation) {
		if (location.getX() < 0 || location.getX() >= mSize || 
				location.getY() < 0 || location.getY() >= mSize) {
			return false;
		}
		mShips.add(new Ship(size, location, orientation));
		return true;
	}
	
	public boolean playMove(Location location) {
		hit(location);
		return allShipsDestroyed();
	}
	
	public boolean allShipsDestroyed() {
		for (Ship ship : mShips) {
			if (!ship.destroyed()) {
				return false;
			}
		}
		return true;
	}
	
	public void hit(Location location) {
		for (Ship ship : mShips) {
			ship.hit(location);
		}
	}
	
}
