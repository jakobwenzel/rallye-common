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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TaskSubmissions extends SelectableSubmissions {
	
	final public int taskID;
	final public int groupID;
	final public Integer score;
	final public Integer bonus;
	final public boolean scoreOutdated;

	public boolean isRated() {
		return score != null || bonus != null;
	}

	@JsonCreator
	public TaskSubmissions(@JsonProperty("taskID") int taskID, @JsonProperty("groupID") int groupID, @JsonProperty("submissions") List<Submission> submissions, @JsonProperty("score") Integer score, @JsonProperty("bonus") Integer bonus, @JsonProperty("scoreOutdated") boolean scoreOutdated, @JsonProperty("primarySubmission") Integer primarySubmission) {
		super(primarySubmission, submissions);
		this.taskID = taskID;
		this.groupID = groupID;
		this.score = score;
		this.bonus = bonus;
		this.scoreOutdated = scoreOutdated;
	}
}
