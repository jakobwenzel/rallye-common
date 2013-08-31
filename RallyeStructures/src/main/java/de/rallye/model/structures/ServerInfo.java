package de.rallye.model.structures;

import org.codehaus.jackson.annotate.JsonIgnore;

public class ServerInfo {

	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String API = "api";
	public static final String BUILD = "build";
	
	final public String name;
	final public String description;
	final public Api[] api;
	final public String build;

	public static class Api {
		public static final String NAME = "name";
		public static final String VERSION = "version";
		
		final public String name;
		final public int version;
		
		public Api(String name, int version) {
			this.name = name;
			this.version = version;
		}

		@Override
		public String toString() {
			return name +":"+ version;
		}
	}

	@Override
	public String toString() {
		return "name: "+ name +"\n"+ "description: "+ description +"\n"+ getApiAsString() +"\n"+ "Build: "+ build;
	}
	
	public ServerInfo(String name, String description, Api[] api, String build) {
		this.name = name;
		this.description = description;
		this.api = api;
		this.build = build;
	}

	@JsonIgnore
	public String getApiAsString() {
		StringBuilder sb = new StringBuilder();
		for (Api a: api) {
			sb.append(a.toString()).append(':');
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
}
