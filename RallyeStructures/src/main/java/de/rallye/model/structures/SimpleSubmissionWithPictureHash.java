package de.rallye.model.structures;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by Ramon on 08.10.13
 */
public class SimpleSubmissionWithPictureHash extends SimpleSubmission {

	public static final String PICTURE_HASH = "pictureHash";

	public final String pictureHash;

	public SimpleSubmissionWithPictureHash(@JsonProperty("submitType") int submitType, @JsonProperty("textSubmission") String textSubmission, @JsonProperty("pictureHash") String pictureHash) {
		super(submitType, null, textSubmission);

		this.pictureHash = pictureHash;
	}
}
