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


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SimpleChatWithPictureHash extends SimpleChatEntry {
	
	public static final String PICTURE_HASH = "pictureHash";

	public final String pictureHash;

	@JsonCreator
	public SimpleChatWithPictureHash(@JsonProperty("message") String message, @JsonProperty("pictureID") Integer pictureID, @JsonProperty("pictureHash") String pictureHash) {
		super(message, pictureID);
		this.pictureHash = pictureHash;
	}

	public SimpleChatWithPictureHash(String message, String pictureHash) {
		this(message, null, pictureHash);
	}
}
