
import java.util.Date;

public class Problem2Apple extends Problem2Fruit {

	public Problem2Apple(){
		super();
		name = "apple";
	}

	public Problem2Apple(Date r){
		super("apple", r);
	}
	
	public void prepare(){
		System.out.println("Core the " + name);
	}

}
