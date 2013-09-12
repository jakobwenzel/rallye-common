package de.rallye.model.structures;

import java.util.List;

public class MapConfig {

	public static final String NAME = "name";
	public static final String LOCATION = "location";
	public static final String ZOOM_LEVEL = "zoomLevel";
	public static final String BOUNDS = "bounds";

	final public String name;
	final public LatLng location;
	final public float zoomLevel;
	final public List<LatLng> bounds;
	
	public MapConfig(String name, LatLng location, float zoomLevel, List<LatLng> bounds) {
		this.name = name;
		this.location = location;
		this.zoomLevel = zoomLevel;
		this.bounds = bounds;
	}

	public MapConfig() {
		name = null;
		location = null;
		zoomLevel = 0;
		bounds = null;
	}
	
	@Override
	public String toString() {
		return "Location : "+ name +"\nLocation: "+ location.toString() +"\nZoom: "+ zoomLevel +"\nBounds: "+ bounds.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		MapConfig that = (MapConfig) o;

		if (Float.compare(that.zoomLevel, zoomLevel) != 0) return false;
		if (!location.equals(that.location)) return false;
		if (!name.equals(that.name)) return false;
		if (!bounds.equals(that.bounds)) return false;

		return true;
	}
}
