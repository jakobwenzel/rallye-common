package de.rallye.model.structures;

public class SimpleSubmission {
	
	public static final String SUBMIT_TYPE = "submitType";
	public static final String INT_SUBMISSION = "intSubmission";
	public static final String TEXT_SUBMISSION = "textSubmission";
	
	final public int submitType;
	final public Integer intSubmission;
	final public String textSubmission;
	
	
	public SimpleSubmission(int submitType, Integer intSubmission, String textSubmission) {
		this.submitType = submitType;
		this.intSubmission = intSubmission;
		this.textSubmission = textSubmission;
	}
}
