package de.rallye.model.structures;

import java.util.List;

public class TaskSubmissions {
	
	public static final String TASK_ID = "taskID";
	public static final String SUBMISSIONS = "submissions";
	public static final String SCORE = "score";
	public static final String BONUS = "bonus";
	public static final String SCORE_OUTDATED = "scoreOutdated";
	
	final public int taskID;
	final public List<Submission> submissions;
	final public Integer score;
	final public Integer bonus;
	final public boolean scoreOutdated;
	
	public boolean isRated() {
		return score != null || bonus != null;
	}

	public TaskSubmissions(int taskID, List<Submission> submissions, Integer score, Integer bonus, boolean scoreOutdated) {
		this.taskID = taskID;
		this.submissions = submissions;
		this.score = score;
		this.bonus = bonus;
		this.scoreOutdated = scoreOutdated;
	}
}
