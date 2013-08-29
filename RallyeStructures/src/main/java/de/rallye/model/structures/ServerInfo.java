package de.rallye.model.structures;

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

//		public static Api fromString(String s) {
//			String[] s2 = s.split(":");
//
//			return new Api(s2[0], Integer.parseInt(s2[1]));
//		}
	}
	
	public ServerInfo(String name, String description, Api[] api, String build) {
		this.name = name;
		this.description = description;
		this.api = api;
		this.build = build;
	}
//ist:0:sc:3:server:4
	public String getApiAsString() {
		StringBuilder sb = new StringBuilder();
		for (Api a: api) {
			sb.append(a.toString()).append(':');
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

	public static ServerInfo fromSet(String name, String description, String apiString, String build) {
		String[] strArr = apiString.split(":");
		Api[] api = new Api[strArr.length/2];

		for (int i=0; i<strArr.length; i++) {
			api[i/2] = new Api(strArr[i], Integer.parseInt(strArr[++i]));
		}

		return new ServerInfo(name, description, api, build);
	}
}
