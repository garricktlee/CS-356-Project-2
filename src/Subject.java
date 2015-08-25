import java.util.List;


public interface Subject {
	
	
	public void attach(Observer obj);
	
	public void detach(Observer obj);
	
	public void notifyObservers();
	
	public List<String> getUpdate(Observer obj);
}
