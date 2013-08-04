package de.rallye.model.structures;

public class Task {
	
	public static final int LOCATION = 1;
	public static final int PICTURE = 2;
	public static final int TEXT = 4;
	public static final int NUMBER = 8;
	public static final int BARCODE = 16;
	
	public final int taskID;
	public final boolean locationSpecific;
	public final LatLng position;
	public final String name;
	public final String description;
	public final boolean multipleSubmits;
	public final int submitType;
	
	
	public Task(int taskID, boolean locationSpecific, LatLng position, String name, String description, boolean multipleSubmits, int submitType) {
		this.taskID = taskID;
		this.locationSpecific = locationSpecific;
		this.position = position;
		this.name = name;
		this.description = description;
		this.multipleSubmits = multipleSubmits;
		this.submitType = submitType;
	}
}