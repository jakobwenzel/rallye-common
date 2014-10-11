/*
 * Copyright (c) 2014 Jakob Wenzel, Ramon Wirsch.
 *
 * This file is part of RallySoft.
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
 * along with Rallyesoft.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.rallye.model.structures;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Ramon on 18.09.2014.
 */
public class LatLngAlt extends LatLng {

	public final int altitude;

	public LatLngAlt(@JsonProperty("latitude") double lat, @JsonProperty("longitude") double lon, @JsonProperty("altitude") int altitude) {
		super(lat, lon);
		this.altitude = altitude;
	}
}
