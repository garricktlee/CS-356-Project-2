import java.util.List;


public class VisitorDriver {
	private List<Visitable> items;
	
	public int showUserTotal(){
		ShowTotalVisitor visitor = new ShowTotalVisitor();
		
		for(Visitable item: items){
			item.acceptVisitor(visitor);
		}
		return visitor.getTotalUsers();
		
	}
	
	public int showGroupTotal(){
		ShowTotalVisitor visitor = new ShowTotalVisitor();
		
		for(Visitable item: items){
			item.acceptVisitor(visitor);
		}
		return visitor.getTotalGroups();
	}
	
	public int showMessageTotal(){
		ShowTotalVisitor visitor = new ShowTotalVisitor();
		
		for(Visitable item: items){
			item.acceptVisitor(visitor);
		}
		return visitor.getTotalMessages();
	}
}
