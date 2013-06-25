package de.rallye.model.structures;

public class LatLng {
	
	public static final String LAT = "latitude";
	public static final String LNG = "longitude";

	public final double latitude;
	public final double longitude;

	public LatLng(double lat, double lon) {
		this.latitude = lat;
		this.longitude = lon;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		LatLng latLng = (LatLng) o;

		if (Double.compare(latLng.latitude, latitude) != 0) return false;
		if (Double.compare(latLng.longitude, longitude) != 0) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
}
