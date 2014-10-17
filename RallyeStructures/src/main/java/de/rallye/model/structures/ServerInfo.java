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
import com.fasterxml.jackson.annotation.JsonProperty;

public class ServerInfo {
	
	final public String name;
	final public String description;
	final public Api[] api;
	final public Object build;

	@Override
	public String toString() {
		return "name: "+ name +"\n"+ "description: "+ description +"\n"+ Api.getApisAsString(api) +"\n"+ "Build: "+ build;
	}

	@JsonCreator
	public ServerInfo(@JsonProperty("name") String name, @JsonProperty("description") String description, @JsonProperty("api") Api[] api, @JsonProperty("build") Object build) {
		this.name = name;
		this.description = description;
		this.api = api;
		this.build = build;
	}

	public static class Api {

		final public String name;
		final public int version;

		@JsonCreator
		public Api(@JsonProperty("name") String name, @JsonProperty("version") int version) {
			this.name = name;
			this.version = version;
		}

		@Override
		public String toString() {
			return name +":"+ version;
		}

		public static String getApisAsString(Api[] apis) {
			StringBuilder sb = new StringBuilder();
			for (Api a: apis) {
				sb.append(a.toString()).append(':');
			}
			sb.deleteCharAt(sb.length()-1);
			return sb.toString();
		}
	}
}
