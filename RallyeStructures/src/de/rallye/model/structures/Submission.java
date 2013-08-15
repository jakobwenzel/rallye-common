package de.rallye.model.structures;

public class Submission extends SimpleSubmission {

	public static final String SUBMISSION_ID = "submissionID";
	public static final String SCORE = "score";
	
	final public int submissionID;
	final public String score;
	
	public Submission(int submissionID, int submitType, Integer intSubmission, String textSubmission, String score) {
		super(submitType, intSubmission, textSubmission);
		
		this.submissionID = submissionID;
		this.score = score;
	}
	
	public Submission(int submissionID, SimpleSubmission parent) {
		this(submissionID, parent.submitType, parent.intSubmission, parent.textSubmission, null);
	}

	@Override
	public String toString() {
		return submissionID +": ("+ intSubmission +"|"+ textSubmission +") = "+ score;
	}
}
