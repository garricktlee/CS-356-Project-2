
public class ConcreteSubject implements Observer {
	
	private String name;
	private Subject topic;
	
	public ConcreteSubject(String name){
		setName(name);
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSubject(Subject sub) {
		this.topic = sub;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}		
}


