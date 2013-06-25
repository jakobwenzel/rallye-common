package de.rallye.model.structures;

import org.codehaus.jackson.map.annotate.JsonSerialize;

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

	public enum Type { Foot, Bike, Bus, Tram };
	

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
