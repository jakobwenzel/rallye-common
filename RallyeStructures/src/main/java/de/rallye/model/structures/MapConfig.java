package de.rallye.model.structures;

public class MapConfig {

	public static final String NAME = "name";
	public static final String LOCATION = "location";
	public static final String ZOOM_LEVEL = "zoomLevel";

	final public String name;
	final public LatLng location;
	final public float zoomLevel;
	
	public MapConfig(String name, double lat, double lon, float zoomLevel) {
		this.name = name;
		this.location = new LatLng(lat, lon);
		this.zoomLevel = zoomLevel;
	}
	
	@Override
	public String toString() {
		return "Location : "+ name +"\nCoordinates: "+ location.toString() +"\nZoom: "+ zoomLevel;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		MapConfig that = (MapConfig) o;

		if (Float.compare(that.zoomLevel, zoomLevel) != 0) return false;
		if (!location.equals(that.location)) return false;
		if (!name.equals(that.name)) return false;

		return true;
	}
}
