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
 * Foobar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.rallye.model.structures;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class LoginInfo {

	public static final String NAME = "name";
	public static final String UNIQUE_ID = "uniqueID";
	public static final String PUSH_ID = "pushID";
	public static final String PUSH_MODE = "pushMode";

	public final String name;
	public final String uniqueID;
	public final String pushID;
	public final String pushMode;

	@JsonCreator
	public LoginInfo(@JsonProperty("name") String name, @JsonProperty("uniqueID") String uniqueID, @JsonProperty("pushID") String pushID, @JsonProperty("pushMode") String pushMode) {
		this.name = name;
		this.uniqueID = uniqueID;
		this.pushID = pushID;
		this.pushMode = pushMode;
	}
	
	@Override
	public String toString() {
		return name +":"+ uniqueID +" pushMode:"+ pushID +"|"+ pushMode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pushID == null) ? 0 : pushID.hashCode());
		result = prime * result
				+ ((pushMode == null) ? 0 : pushMode.hashCode());
		result = prime * result
				+ ((uniqueID == null) ? 0 : uniqueID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginInfo other = (LoginInfo) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pushID == null) {
			if (other.pushID != null)
				return false;
		} else if (!pushID.equals(other.pushID))
			return false;
		if (pushMode == null) {
			if (other.pushMode != null)
				return false;
		} else if (!pushMode.equals(other.pushMode))
			return false;
		if (uniqueID == null) {
			if (other.uniqueID != null)
				return false;
		} else if (!uniqueID.equals(other.uniqueID))
			return false;
		return true;
	}
}
