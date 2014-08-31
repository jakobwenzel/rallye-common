/*
 * Copyright (c) 2014 Jakob Wenzel, Ramon Wirsch.
 *
 * This file is part of RallySoft.
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
 * along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */

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
