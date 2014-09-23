/*
 * Copyright (c) 2014 Jakob Wenzel, Ramon Wirsch.
 *
 * This file is part of RallyeSoft.
 *
 * RallyeSoft is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Foobar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with RallyeSoft. If not, see <http://www.gnu.org/licenses/>.
 */

package de.rallye.model.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


public class LatLng implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5107323888940049466L;
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
		if (o == null || this.getClass() != o.getClass()) return false;

		LatLng latLng = (LatLng) o;

		return Double.compare(latLng.latitude, latitude) == 0 && Double.compare(latLng.longitude, longitude) == 0;

	}

    public static LatLng fromString(String location) {
        String[] res = location.replaceAll("^\\(([0-9\\.]+),([0-9\\.]+)\\)$", "$1;$2").split(";");
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
