package de.rallye.model.structures;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class SimpleChatWithPictureHash extends SimpleChatEntry {
	
	public static final String PICTURE_HASH = "pictureHash";

	public final String pictureHash;

	@JsonCreator
	public SimpleChatWithPictureHash(@JsonProperty("message") String message, @JsonProperty("pictureID") Integer pictureID, @JsonProperty("pictureHash") String pictureHash) {
		super(message, pictureID);
		this.pictureHash = pictureHash;
	}
}
