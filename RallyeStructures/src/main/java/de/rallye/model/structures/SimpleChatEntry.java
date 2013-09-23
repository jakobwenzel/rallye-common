package de.rallye.model.structures;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class SimpleChatEntry {
	
	public static final String MESSAGE = "message";
	public static final String PICTURE_ID = "pictureID";
	
	public final String message;
	public final Integer pictureID;

	@JsonCreator
	public SimpleChatEntry(@JsonProperty("message") String message, @JsonProperty("pictureID") Integer pictureID) {
		this.message = message;
		this.pictureID = pictureID;
	}

	public boolean hasPicture() {
		return pictureID != null && pictureID > 0;
	}
	
	
}
