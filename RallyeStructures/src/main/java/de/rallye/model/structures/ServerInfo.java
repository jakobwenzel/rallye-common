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

    public static ServerInfo fromSet(String name, String description, String apiString, String build) {
        String[] strArr = apiString.split(":");
        Api[] api = new Api[strArr.length/2];

        for (int i=0; i<strArr.length; i++) {
            api[i/2] = new Api(strArr[i], Integer.parseInt(strArr[++i]));
        }

        return new ServerInfo(name, description, api, build);
    }
}
