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

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.rallye.model.mapper.EdgeNodeSerializer;


/**
 * 
 * @author Ramon
 * @version 1.0
 */
public class Edge {
	public static final String NODE_A = "nodeA";
	public static final String NODE_B = "nodeB";
	public static final String TYPE = "type";

	@JsonSerialize(using=EdgeNodeSerializer.class)
	final public Node nodeA;
	@JsonSerialize(using=EdgeNodeSerializer.class)
	final public Node nodeB;

	public enum Type { Foot, Bike, Bus, Tram }
	

	protected static Type getType(String type) {
		for (Type t: Type.values()) {
			if (t.toString().equalsIgnoreCase(type))
				return t;
		}
		return null;
	}
	

	final public Type type;

	public Edge(Node a, Node b, Type type) {
		
		this.type = type;
		this.nodeA = a;
		this.nodeB = b;
		
		a.addEdge(this);
		b.addEdge(this);
	}
	
	public Edge(Node a, Node b, String type) {
		this(a,b, getType(type));
	}
	
	@Override
	public String toString() {
		return nodeA +" - "+ nodeB +" : "+ type;
	}

	public Node getOtherNode(Node node) {
		return (nodeA==node)? nodeB : nodeA;
	}
}
