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

public class PushConfig {

	public static final String MODE_GCM = "gcm";
	
	public static final String PUSH_ID = "pushID";
	public static final String PUSH_MODE = "pushMode";
	
	final public String pushID;
	final public String pushMode;

	@JsonCreator
	public PushConfig(@JsonProperty("pushID") String pushID, @JsonProperty("pushMode") String pushMode) {
		this.pushID = pushID;
		this.pushMode = pushMode;
	}
}
