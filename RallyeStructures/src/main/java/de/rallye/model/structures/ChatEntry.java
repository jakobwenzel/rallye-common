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

/**
 *
 * 
 * @author Ramon
 * @version 1.0
 */
public class ChatEntry extends PostChat {
	
	public final int chatID;
	public final int groupID;
	public final long timestamp;
	public final int userID;

	/**
	 * Complete Entry as it should reside in the database
	 * @param chatID
	 * @param timestamp
	 * @param groupID
	 * @param userID
	 */
	public ChatEntry(int chatID, String message, long timestamp, int groupID, int userID, String pictureHash) {
		super(message, pictureHash);

		this.timestamp = timestamp;
		this.groupID = groupID;
		this.userID = userID;
		this.chatID = chatID;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ChatEntry chatEntry = (ChatEntry) o;

		if (chatID != chatEntry.chatID) return false;
		return timestamp == chatEntry.timestamp;
	}

	@Override
	public String toString() {
		return message +"|"+ pictureHash +" at "+ timestamp +" by "+userID +"@"+ groupID;
	}
}
