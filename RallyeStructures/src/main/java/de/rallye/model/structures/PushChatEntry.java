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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Ramon on 23.09.2014.
 *
 * Wrapper for ChatEntry that names the room it stems from
 *
 * Generic to allow the client to directly deserialize to a sub-class
 */
public class PushChatEntry<EntryType extends ChatEntry> {

	public final int roomID;
	public final EntryType entry;

	public PushChatEntry(@JsonProperty("entry") EntryType entry, @JsonProperty("roomID") int roomID) {
		this.entry = entry;
		this.roomID = roomID;
	}
}
