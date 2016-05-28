package model;

public class Ship {
	private final int mSize; 
	private boolean mDestroyed;
	private final Location mLocation;
	private final Orientation mOrientation;
	private boolean[] mHits;
	
	public Ship(int size, Location location, Orientation orientation) {
		mSize = size;
		mLocation = location;
		mOrientation = orientation;
		mHits = new boolean[size];
	}
	
	public int getSize() {
		return mSize;
	}
	
	public Location getLocation() {
		return mLocation;
	}
	
	public Orientation getOrientation() {
		return mOrientation;
	}
	
	private void updateDestroyed() {
		for (boolean hit : mHits) {
			if (!hit) {
				mDestroyed = false;
			}
		}
		mDestroyed = true;
	}
	
	public boolean destroyed() {
		return mDestroyed;
	}
	
	public boolean hit(Location location) {
		final int deltaX = Math.abs(location.getX() - mLocation.getX());
		final int deltaY = Math.abs(location.getY() - mLocation.getY());
		switch (mOrientation) {
			case ANCHORED_LEFT: {
				if(location.getX() > mLocation.getX() && deltaX < mSize) {
					mHits[deltaX] = true;
					updateDestroyed();
					return true;
				}
				break;
			}
			case ANCHORED_RIGHT: {
				if(location.getX() < mLocation.getX() && deltaX < mSize) {
					mHits[deltaX] = true;
					updateDestroyed();
					return true;
				}				
				break;
			}
			case ANCHORED_TOP: {
				if(location.getY() < mLocation.getY() && deltaY < mSize) {
					mHits[deltaY] = true;
					updateDestroyed();
					return true;
				}				
				break;
			}
			case ANCHORED_BOTTOM: {
				if(location.getY() < mLocation.getY() && deltaY < mSize) {
					mHits[deltaY] = true;
					updateDestroyed();
					return true;
				}				
				break;
			}
		}
		return false;
	}
}
