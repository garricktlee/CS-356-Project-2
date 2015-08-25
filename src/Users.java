import java.util.ArrayList;
import java.util.List;


public class Users implements Subject, Visitable{

	private static int totalUsers = 0;
	private static int totalMessages = 0;
	
	private List<Observer> observers;
	private String userID;
	private List<String> followers = new ArrayList<String>();
	private List<String> followings = new ArrayList<String>();
	private List<String> newsFeed = new ArrayList<String>();
		
	public Users(){
		setTotalUsers(getTotalUsers() + 1);
	}
	
	public void tweet(String tweet){
		setTotalMessages(getTotalMessages() + 1);
		newsFeed.add(tweet);		
	}
	
	public String returnFollowers(){
		String d = "";
		for(String str : followers){
			d += str;
			d += "\n";
		}
		return d;
	}
	
	public String returnTweets(){
		String tweets = "";
		for(String news : newsFeed){
			tweets += news;
			tweets += "\n";
		}
		return tweets;
		
	}
	
	public void printTweets(){
		for(String news:newsFeed){
			System.out.println(news);			
		}
	}
		
	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public void addFollower(String follower){
		followers.add(follower);
	}
	
	
	@Override
	public void acceptVisitor(Visitor visitor){
		visitor.visit(this);
	}

	@Override
	public void attach(Observer obj) {
		observers.add(obj);
		
	}

	@Override
	public void detach(Observer obj) {
		observers.remove(obj);
	}

	@Override
	public void notifyObservers() {
		List<Observer> observersLocal = new ArrayList<>(this.observers);
		
		for(Observer obj: observersLocal){
			obj.Update();
		}
		
	}

	@Override
	public List<String> getUpdate(Observer obj) {
		return this.newsFeed;		
	}

	public static int getTotalUsers() {
		return totalUsers;
	}

	public static void setTotalUsers(int totalUsers) {
		Users.totalUsers = totalUsers;
	}

	public static int getTotalMessages() {
		return totalMessages;
	}

	public static void setTotalMessages(int totalMessages) {
		Users.totalMessages = totalMessages;
	}

}
