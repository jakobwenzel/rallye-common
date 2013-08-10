package de.rallye.model.structures;

import java.util.List;

public class TaskSubmissions {
	
	public static final String TASK_ID = "taskID";
	public static final String SUBMISSIONS = "submissions";
	
	final public int taskID;
	final public List<Submission> submissions;

	public TaskSubmissions(int taskID, List<Submission> submissions) {
		this.taskID = taskID;
		this.submissions = submissions;
	}
}
