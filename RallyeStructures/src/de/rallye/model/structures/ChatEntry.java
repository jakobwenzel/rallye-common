package de.rallye.model.structures;

/**
 * 
 * @author Ramon
 * @version 1.0
 */
public class ChatEntry {
	
	public static final String CHAT_ID = "chatID";
	public static final String TIMESTAMP = "timestamp";
	public static final String GROUP_ID = "groupID";
	public static final String USER_ID = "userID";
	public static final String MESSAGE = "message";
	public static final String PICTURE_ID = "pictureID";
	
	public final int chatID;
	public final int groupID;
	public final long timestamp;
	public final int userID;
	public final String message;
	public final Integer pictureID;

	/**
	 * Complete Entry as it should reside in the database
	 * @param chatID
	 * @param timestamp
	 * @param groupID
	 * @param userID
	 */
	public ChatEntry(int chatID, String message, long timestamp, int groupID, int userID, Integer pictureID) {
		this.timestamp = timestamp;
		this.groupID = groupID;
		this.userID = userID;
		this.chatID = chatID;
		this.message = message;
		this.pictureID = pictureID;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ChatEntry chatEntry = (ChatEntry) o;

		if (chatID != chatEntry.chatID) return false;
		if (timestamp != chatEntry.timestamp) return false;

		return true;
	}

	@Override
	public String toString() {
		return message +"|"+timestamp+"|"+userID+"@"+groupID+"|"+pictureID;
	}
}
