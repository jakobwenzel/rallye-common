package de.rallye.model.structures;

public class LoginInfo {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pushID == null) ? 0 : pushID.hashCode());
		result = prime * result
				+ ((pushMode == null) ? 0 : pushMode.hashCode());
		result = prime * result
				+ ((uniqueID == null) ? 0 : uniqueID.hashCode());
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
		LoginInfo other = (LoginInfo) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pushID == null) {
			if (other.pushID != null)
				return false;
		} else if (!pushID.equals(other.pushID))
			return false;
		if (pushMode == null) {
			if (other.pushMode != null)
				return false;
		} else if (!pushMode.equals(other.pushMode))
			return false;
		if (uniqueID == null) {
			if (other.uniqueID != null)
				return false;
		} else if (!uniqueID.equals(other.uniqueID))
			return false;
		return true;
	}

	public static final String NAME = "name";
	public static final String UNIQUE_ID = "uniqueID";
	public static final String PUSH_ID = "pushID";
	public static final String PUSH_MODE = "pushMode";

	public String name;
	public String uniqueID;
	public String pushID;
	public String pushMode;
	
	@Override
	public String toString() {
		return name +":"+ uniqueID +" pushMode:"+ pushID +"|"+ pushMode;
	}
}
