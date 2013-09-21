package de.rallye.model.structures;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class LatLng implements Serializable {
	
	public static final String LAT = "latitude";
	public static final String LNG = "longitude";

	public final double latitude;
	public final double longitude;

	@JsonCreator
	public LatLng(@JsonProperty("latitude") double lat, @JsonProperty("longitude") double lon) {
		this.latitude = lat;
		this.longitude = lon;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		LatLng latLng = (LatLng) o;

		return Double.compare(latLng.latitude, latitude) == 0 && Double.compare(latLng.longitude, longitude) == 0;

	}

    public static LatLng fromString(String location) {
        String[] res = location.replace("\\(([0-9.])+,([0-9.])\\)+", "//1;//2").split(";");
        return new LatLng(Double.valueOf(res[0]), Double.valueOf(res[1]));

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

	@Override
	public String toString() {
		return "("+ latitude +","+ longitude +")";
	}
}
