package de.rallye.model.structures;

public class ServerInfo {

	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String API = "api";
	
	final public String name;
	final public String description;
	final public Api[] api;
	
	public static class Api {
		public static final String NAME = "name";
		public static final String VERSION = "version";
		
		final public String name;
		final public int version;
		
		public Api(String name, int version) {
			this.name = name;
			this.version = version;
		}
	}
	
	public ServerInfo(String name, String description, Api[] api) {
		this.name = name;
		this.description = description;
		this.api = api;
	}
}
