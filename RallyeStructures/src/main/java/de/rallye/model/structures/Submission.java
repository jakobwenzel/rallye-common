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

public class Submission extends SimpleSubmission {
	final public int submissionID;

	@JsonCreator
	public Submission(@JsonProperty("submissionID") int submissionID, @JsonProperty("submitType") int submitType, @JsonProperty("intSubmission") Integer intSubmission, @JsonProperty("textSubmission") String textSubmission) {
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
