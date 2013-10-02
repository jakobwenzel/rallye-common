package de.rallye.model.structures;

public class Submission extends SimpleSubmission {

	public static final String SUBMISSION_ID = "submissionID";
	public static final String SCORE = "score";
	
	final public int submissionID;
	
	public Submission(int submissionID, int submitType, Integer intSubmission, String textSubmission) {
		super(submitType, intSubmission, textSubmission);
		
		this.submissionID = submissionID;
	}
	
	public Submission(int submissionID, SimpleSubmission parent) {
		this(submissionID, parent.submitType, parent.intSubmission, parent.textSubmission);
	}

	@Override
	public String toString() {
		return submissionID +": ("+ intSubmission +"|"+ textSubmission +")";
	}
}
