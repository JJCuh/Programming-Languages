
import java.util.*;
import java.util.Date;

public class MainClass {

	public static void main(String[] args) {
		//Problem 1:
		ArrayList<Object> arr = new ArrayList<Object>();
		arr.add("Food");
		arr.add("Orange");
		arr.add("Fruit");
		arr.add("Papaya");
		arr.add(3932728);
		arr.add("Apple");
		arr.add("now");
		arr.add("Food");
		arr.add("sandwich");
		ArrayList<Food> foodArr = Problem1.getFoodList(arr);
		for(Food f : foodArr) {
			f.prepare();
		}
		System.out.println();
		
		//Problem 2:
		ArrayList<Fruit> fruitArr = new ArrayList<Fruit>();
		Date d1 = new Date(1900000000);
		Date d2 = new Date(2000000000);
		Date d3 = new Date(2100000000);
		fruitArr.add(new Fruit());
		fruitArr.add(new Fruit("fruit1",d3));
		fruitArr.add(new Fruit("fruit2",d1));
		fruitArr.add(new Fruit("fruit3",d2));
		for(Fruit f : fruitArr) {
			f.prepare();
			f.ripeTime();
		}	
		System.out.println();
		
		Collections.sort(fruitArr);
		for(Fruit f : fruitArr) {
			f.prepare();
			f.ripeTime();
		}
	}

}
