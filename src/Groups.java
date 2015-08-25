import java.util.ArrayList;
import java.util.List;


public class Groups implements Visitable{
	
	private static int totalGroups = 0;
	
	private String groupID;
	private List<Groups> group = new ArrayList<Groups>();
	
	public Groups(){
		setTotalGroups(getTotalGroups() + 1);
	}

	@Override
	public void acceptVisitor(Visitor visitor){
		visitor.visit(this);
	}	
	
	public String getGroupID() {
		return groupID;
	}

	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}

	public static int getTotalGroups() {
		return totalGroups;
	}

	public static void setTotalGroups(int totalGroups) {
		Groups.totalGroups = totalGroups;
	}

}
