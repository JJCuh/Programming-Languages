
import java.util.Date;

public class Orange extends Fruit {

	public Orange(){
		super();
		name = "orange";
	}

	public Orange(Date r){
		super("orange", r);
	}
	
	public void prepare(){
		System.out.println("Peel the " + name);
	}

}
