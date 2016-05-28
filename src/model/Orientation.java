package model;

public enum Orientation {
	ANCHORED_TOP("top"),
	ANCHORED_BOTTOM("bottom"),
	ANCHORED_LEFT("left"),
	ANCHORED_RIGHT("right");
	
	private String mValue;
	
	private Orientation(String value) {
		mValue = value;
	}
	
	String getValue() {
		return mValue;
	}
	
	public static Orientation fromString(String value) {
		switch (value) {
			case "top": {
				return Orientation.ANCHORED_TOP;
			}
			case "bottom": {
				return Orientation.ANCHORED_BOTTOM;
			}
			case "left": {
				return Orientation.ANCHORED_LEFT;
			}
			case "right": {
				return Orientation.ANCHORED_RIGHT;
			}	
		}
		return null;
	}
}
