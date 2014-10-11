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
 * RallyeSoft is distributed in the hope that it will be useful,
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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MapConfig {
	final public String name;
	final public LatLng location;
	final public float zoomLevel;
	final public List<LatLng> bounds;

	@JsonCreator
	public MapConfig(@JsonProperty("name") String name, @JsonProperty("location") LatLng location, @JsonProperty("zoomLevel") float zoomLevel, @JsonProperty("bounds") List<LatLng> bounds) {
		this.name = name;
		this.location = location;
		this.zoomLevel = zoomLevel;
		this.bounds = bounds;
	}

    public static List<LatLng> getBounds(Set<String> bounds) {
        List<LatLng> res = new ArrayList<LatLng>();
        for (String s: bounds) {
            res.add(LatLng.fromString(s));
        }
        return res;
    }

    public Set<String> getBoundsAsSet() {
        Set<String> res = new HashSet<String>();

        for(LatLng loc: bounds) {
            res.add(loc.toString());
        }
        return res;
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
		return bounds.equals(that.bounds);
	}
}
