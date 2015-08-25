
public class ShowTotalVisitor implements Visitor {
	
	private int totalUsers;
	private int totalMessages;
	private int totalGroups;
	
	
	@Override
	public void visit(Users users) {
		setTotalUsers(users.getTotalUsers());
		setTotalMessages(users.getTotalMessages());
	}

	@Override
	public void visit(Groups groups) {
		setTotalGroups(groups.getTotalGroups());
		
	}

	public int getTotalUsers() {
		return totalUsers;
	}

	public void setTotalUsers(int totalUsers) {
		this.totalUsers = totalUsers;
	}

	public int getTotalMessages() {
		return totalMessages;
	}

	public void setTotalMessages(int totalMessages) {
		this.totalMessages = totalMessages;
	}

	public int getTotalGroups() {
		return totalGroups;
	}

	public void setTotalGroups(int totalGroups) {
		this.totalGroups = totalGroups;
	}
	

}
