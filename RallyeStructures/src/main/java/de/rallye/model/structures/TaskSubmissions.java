/*
 * Copyright (c) 2014 Jakob Wenzel, Ramon Wirsch.
 *
 * This file is part of RallyeSoft.
 *
 * RallyeSoft is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Foobar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with RallyeSoft. If not, see <http://www.gnu.org/licenses/>.
 */

package de.rallye.model.structures;

import java.util.List;

public class TaskSubmissions {
	
	public static final String TASK_ID = "taskID";
	public static final String GROUP_ID = "groupID";
	public static final String SUBMISSIONS = "submissions";
	public static final String SCORE = "score";
	public static final String BONUS = "bonus";
	public static final String SCORE_OUTDATED = "scoreOutdated";
	
	final public int taskID;
	final public int groupID;
	final public List<Submission> submissions;
	final public Integer score;
	final public Integer bonus;
	final public boolean scoreOutdated;
	
	public boolean isRated() {
		return score != null || bonus != null;
	}

	public TaskSubmissions(int taskID, int groupID, List<Submission> submissions, Integer score, Integer bonus, boolean scoreOutdated) {
		this.taskID = taskID;
		this.groupID = groupID;
		this.submissions = submissions;
		this.score = score;
		this.bonus = bonus;
		this.scoreOutdated = scoreOutdated;
	}
}
