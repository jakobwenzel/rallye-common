/*
 * Copyright (c) 2014 Jakob Wenzel, Ramon Wirsch.
 *
 * This file is part of RallyeSoft.
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
 * along with RallyeSoft. If not, see <http://www.gnu.org/licenses/>.
 */

package de.rallye.model.structures;

import java.util.ArrayList;
import java.util.List;

public abstract class AdditionalResource {

	public static String additionalResourcesToString(List<AdditionalResource> res) {
		StringBuilder sb = new StringBuilder();

		if (res == null || res.size() == 0)
			return null;

		for (AdditionalResource r: res) {
			sb.append(r.toString()).append(',');
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

	public static List<AdditionalResource> additionalResourcesFromString(String in) {//TODO obsolete on the client, but the server uses it for the db. -> come up with a way to do it with jackson but fallback to this?
		List<AdditionalResource> res = new ArrayList<AdditionalResource>();

		if (in == null || in.length() == 0)
			return res;

		for (String s: in.split(",")) {
			res.add(AdditionalPicture.fromString(s));
		}

		return res;
	}
}
