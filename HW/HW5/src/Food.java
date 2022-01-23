
public class Food {
	
	protected String name;
	
	public Food(){
		name = "food";
	}

	public Food(String n){
		name = n;
	}
	
	public void prepare(){
		System.out.println("Prepare the " + name);
	}

}
