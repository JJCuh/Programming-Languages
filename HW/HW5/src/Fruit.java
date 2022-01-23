
import java.util.Date;

public class Fruit extends Food implements Comparable<Fruit> {
	
	protected Date ripe;
	
	public Fruit(){
		super();
		ripe = new Date();
	}

	public Fruit(String n, Date r){
		super(n);
		ripe = r;
	}
	
	public void ripeTime(){
		System.out.println("You can eat it on " + ripe);
	}
	
	public int compareTo(Fruit f) {
		if(ripe.compareTo(f.ripe) == 0) return 0;
		else if(ripe.compareTo(f.ripe) > 0) return 1;  
		else return -1; 
	}
	
}