package de.rallye.model.structures;

public class GroupUser extends User {
	
	public static final String GROUP_ID = "groupID";
	
	public final int groupID;

	public GroupUser(int userID, int groupID, String name) {
		super(userID, name);

		this.groupID = groupID;
	}

}
