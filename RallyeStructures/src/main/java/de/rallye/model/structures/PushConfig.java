package de.rallye.model.structures;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class PushConfig {
	
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
