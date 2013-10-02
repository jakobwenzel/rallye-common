package de.rallye.model.structures;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Task implements Serializable{

	public static final String TASK_ID = "taskID";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String LOCATION = "location";
	public static final String RADIUS = "radius";
	public static final String MULTIPLE_SUBMITS = "multipleSubmits";
	public static final String SUBMIT_TYPE = "submitType";
	public static final String LOCATION_SPECIFIC = "locationSpecific";
	public static final String POINTS = "maxPoints";
	public static final String SCORE = "score";
	public static final String BONUS = "bonus";
//	public static final String PICTURE_ID = Picture.PICTURE_ID;
	public static final String ADDITIONAL_RESOURCES = "additionalResources";
	
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
//	public final Integer pictureID;
	public final Integer score; //Null if not yet rated
	public final Integer bonus; //Null if not yet rated
	public final List<AdditionalResource> additionalResources;
	
	
	public Task(int taskID, boolean locationSpecific, LatLng location, double radius, String name, String description, boolean multipleSubmits, int submitType, String maxPoints, List<AdditionalResource> additionalResources, Integer score, Integer bonus) {
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
	
	public boolean isRated() {
		return (score!=null) || (bonus!=null);
	}
}