
import java.util.ArrayList;
import java.util.Date;

public class Problem1 {
	
	public static ArrayList<Food> getFoodList(ArrayList<Object> arr){
		ArrayList<Food> retArr = new ArrayList<Food>();
		boolean food = false;
		boolean fruit = false;
		boolean apple = false;
		boolean orange = false;
		String name = "";
		Date date;
		for(Object o : arr){
			if(o.getClass() == String.class){
				if(o.equals("Apple")){
					if(food){
						retArr.add(new Food());
						food = false;
					}
					else if(fruit){
						retArr.add(new Fruit());
						fruit = false;
					}
					else if(apple){
						retArr.add(new Apple());
						apple = false;
					}
					else if(orange){
						retArr.add(new Orange());
						orange = false;
					}
					apple = true;
				}
				else if(o.equals("Orange")){
					if(food){
						retArr.add(new Food());
						food = false;
					}
					else if(fruit){
						retArr.add(new Fruit());
						fruit = false;
					}
					else if(apple){
						retArr.add(new Apple());
						apple = false;
					}
					else if(orange){
						retArr.add(new Orange());
						orange = false;
					}
					orange = true;
				}
				else if(o.equals("Fruit")){
					if(food){
						retArr.add(new Food());
						food = false;
					}
					else if(fruit){
						retArr.add(new Fruit());
						fruit = false;
					}
					else if(apple){
						retArr.add(new Apple());
						apple = false;
					}
					else if(orange){
						retArr.add(new Orange());
						orange = false;
					}
					fruit = true;
				}
				else if(o.equals("Food")){	
					if(food){
						retArr.add(new Food());
						food = false;
					}
					else if(fruit){
						retArr.add(new Fruit());
						fruit = false;
					}
					else if(apple){
						retArr.add(new Apple());
						apple = false;
					}
					else if(orange){
						retArr.add(new Orange());
						orange = false;
					}
					food = true;
				}
				else if(o.equals("now")){
					date = new Date();
					if(fruit) {
						retArr.add(new Fruit(name, date));
						fruit = false;
					}
					else if(apple){
						retArr.add(new Apple(date));
						apple = false;
					}
					else if(orange){
						retArr.add(new Orange(date));
						orange = false;
					}
				}
				else {
					name = (String) o;
					if(food){
						retArr.add(new Food(name));
						food = false;
					}
				}
			}
			else if(o.getClass() == Integer.class) {
				date = new Date((Integer) o);
				if(fruit) {
					retArr.add(new Fruit(name, date));
					fruit = false;
				}
				else if(apple){
					retArr.add(new Apple(date));
					apple = false;
				}
				else if(orange){
					retArr.add(new Orange(date));
					orange = false;
				}
			}
		}
		return retArr;
	}
	
}
