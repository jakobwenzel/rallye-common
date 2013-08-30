package de.rallye.model.structures;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class Group {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + groupID;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (groupID != other.groupID)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public static final String GROUP_ID = "groupID";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";

	public final int groupID;
	public final String name;
	public final String description;

	@JsonCreator
	public Group(@JsonProperty("groupID") int groupID,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {
		this.groupID = groupID;
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		return groupID + ":" + name;
	}
}
