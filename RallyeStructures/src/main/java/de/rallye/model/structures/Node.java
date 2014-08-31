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

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * 
 * @author Ramon
 * @version 1.1
 */
public class Node {
	public static final String NODE_ID = "nodeID";
	public static final String NAME = "name";
	public static final String LOCATION = "location";
	public static final String DESCRIPTION = "description";
	
	final public int nodeID;
	final public String name;
	final public LatLng location;
	final public String description;
	
	@JsonIgnore final private ArrayList<Edge> edges = new ArrayList<Edge>();

	@Deprecated
	public Node(int ID, String name, double lat, double lon, String description) {
		this.nodeID = ID;
		this.name = name;
		this.description = description;
		this.location = new LatLng(lat, lon);
	}

	public Node(int ID, String name, LatLng location, String description) {
		this.nodeID = ID;
		this.name = name;
		this.description = description;
		this.location = location;
	}
	
	public void addEdge(Edge edge) {
		edges.add(edge);
	}
	
	public List<Edge> getEdges() {
		return edges;
	}
	
	
	
	@Override
	public String toString() {
		return name +" ( "+ location.latitude+" , "+ location.longitude+" )";
	}
	

	@Override
	public int hashCode() {
		return nodeID;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		return nodeID == other.nodeID;
	}
}
