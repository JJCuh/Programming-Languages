
public class Problem2Food {
	
	protected String name;
	
	public Problem2Food(){
		name = "food";
	}

	public Problem2Food(String n){
		name = n;
	}
	
	public void prepare(){
		System.out.println("Prepare the " + name);
	}

}
