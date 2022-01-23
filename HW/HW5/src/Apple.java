
import java.util.Date;

public class Apple extends Fruit {

	public Apple(){
		super();
		name = "apple";
	}

	public Apple(Date r){
		super("apple", r);
	}
	
	public void prepare(){
		System.out.println("Core the " + name);
	}

}
