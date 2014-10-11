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
 * RallyeSoft is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Rallyesoft.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.rallye.model.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class Task implements Serializable{

	private static final long serialVersionUID = 6255817074458231135L;
	
	public static final int TYPE_LOCATION = 1;
	public static final int TYPE_PICTURE = 2;
	public static final int TYPE_TEXT = 4;
	public static final int TYPE_NUMBER = 8;
	public static final int TYPE_BARCODE = 16;

	public final int taskID;
	public final boolean locationSpecific;
	public final LatLng location;
	public final double radius;
	public final String name;
	public final String description;
	public final boolean multipleSubmits;
	public final int submitType;
	public final String maxPoints;
//	public final Integer pictureHash;
	public final Integer score; //Null if not yet rated
	public final Integer bonus; //Null if not yet rated
	public final List<AdditionalResource> additionalResources;
	
	@JsonCreator
	public Task(@JsonProperty("taskID") int taskID, @JsonProperty("locationSpecific") boolean locationSpecific, @JsonProperty("location") LatLng location, @JsonProperty("radius") double radius, @JsonProperty("name") String name, @JsonProperty("description") String description, @JsonProperty("multipleSubmits") boolean multipleSubmits, @JsonProperty("submitType") int submitType, @JsonProperty("maxPoints") String maxPoints, @JsonProperty("additionalResources") List<AdditionalResource> additionalResources, @JsonProperty("score") Integer score, @JsonProperty("bonus") Integer bonus) {
		this.taskID = taskID;
		this.locationSpecific = locationSpecific;
		this.location = location;
		this.radius = radius;
		this.name = name;
		this.description = description;
		this.multipleSubmits = multipleSubmits;
		this.submitType = submitType;
		this.maxPoints = maxPoints;
		this.additionalResources = additionalResources;
		this.score = score;
		this.bonus = bonus;
	}
	
	public Task(int taskID, boolean locationSpecific, LatLng location, double radius, String name, String description, boolean multipleSubmits, int submitType, String maxPoints, List<AdditionalResource> additionalResources) {
		this(taskID,locationSpecific,location,radius,name,description,multipleSubmits,submitType,maxPoints,additionalResources,null,null);
	}
	
	public Task(int taskID, String name, String description, boolean multipleSubmits, int submitType, String points, List<AdditionalResource> additionalResources) {
		this(taskID, false, null, 0, name, description, multipleSubmits, submitType, points, additionalResources);
	}

	public boolean hasLocation() {
		return location != null;
	}
	
	@Override
	public String toString() {
		return taskID +":"+ name +" "+ location +"";
	}

	@JsonIgnore
	public boolean isRated() {
		return (score!=null) || (bonus!=null);
	}
}