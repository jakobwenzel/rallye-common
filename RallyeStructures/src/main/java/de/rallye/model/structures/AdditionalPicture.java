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

import java.io.Serializable;

public class AdditionalPicture extends AdditionalResource implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2136443711937831293L;

	public static final String PICTURE_ID = "pictureID";

	final public int pictureID;
	
	public AdditionalPicture(int pictureID) {
		this.pictureID = pictureID;
	}
	
	@Override
	public String toString() {
		return "picID:"+ pictureID;
	}
	
	public static AdditionalPicture fromString(String s) {
		String pic = s.replaceAll("^picID:(\\d+)$", "$1");
		return new AdditionalPicture(Integer.parseInt(pic));
	}
}
