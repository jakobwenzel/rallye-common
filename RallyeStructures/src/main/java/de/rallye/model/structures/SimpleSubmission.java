package de.rallye.model.structures;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class SimpleSubmission {
	
	public static final String SUBMIT_TYPE = "submitType";
	public static final String INT_SUBMISSION = "intSubmission";
	public static final String TEXT_SUBMISSION = "textSubmission";
	
	final public int submitType;
	final public Integer intSubmission;
	final public String textSubmission;
	
	@JsonCreator
	public SimpleSubmission(@JsonProperty("submitType")int submitType, @JsonProperty("intSubmission")Integer intSubmission, @JsonProperty("textSubmission")String textSubmission) {
		this.submitType = submitType;
		this.intSubmission = intSubmission;
		this.textSubmission = textSubmission;
	}
}
