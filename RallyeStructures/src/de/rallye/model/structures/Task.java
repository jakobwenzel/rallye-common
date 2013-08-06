package de.rallye.model.structures;

import java.io.Serializable;

public class Task implements Serializable{

	public static final String TASK_ID = "taskID";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String LOCATION = "location";
	public static final String MULTIPLE_SUBMITS = "multipleSubmits";
	public static final String SUBMIT_TYPE = "submitType";
	public static final String LOCATION_SPECIFIC = "locationSpecific";
	
	public static final int TYPE_LOCATION = 1;
	public static final int TYPE_PICTURE = 2;
	public static final int TYPE_TEXT = 4;
	public static final int TYPE_NUMBER = 8;
	public static final int TYPE_BARCODE = 16;
	
	public final int taskID;
	public final boolean locationSpecific;
	public final LatLng location;
	public final String name;
	public final String description;
	public final boolean multipleSubmits;
	public final int submitType;
	
	
	public Task(int taskID, boolean locationSpecific, LatLng location, String name, String description, boolean multipleSubmits, int submitType) {
		this.taskID = taskID;
		this.locationSpecific = locationSpecific;
		this.location = location;
		this.name = name;
		this.description = description;
		this.multipleSubmits = multipleSubmits;
		this.submitType = submitType;
	}

	public boolean hasLocation() {
		return location != null;
	}
}