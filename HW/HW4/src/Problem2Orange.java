
import java.util.Date;

public class Problem2Orange extends Problem2Fruit {

	public Problem2Orange(){
		super();
		name = "orange";
	}

	public Problem2Orange(Date r){
		super("orange", r);
	}
	
	public void prepare(){
		System.out.println("Peel the " + name);
	}

}
