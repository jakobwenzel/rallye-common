package de.rallye.model.structures;

public class ServerInfo {

	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String API_NAME = "apiName";
	public static final String API_VERSION = "apiVersion";
	
	final public String name;
	final public String description;
	final public String[] apiName;
	final public int[] apiVersion;
	
	public ServerInfo(String name, String description, String[] apiName, int[] apiVersion) {
		this.name = name;
		this.description = description;
		this.apiName = apiName;
		this.apiVersion = apiVersion;
	}
}
