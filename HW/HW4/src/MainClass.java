
import java.util.Date;
import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args) {
		// Problem 1
		int[] input = {500, 700, 800, 100, 300, 200, 900, 400, 1000, 600};
		System.out.print("Input: ");
	    Problem1.print(input);
	    Problem1.quicksort(input, 0, 9);
	    System.out.print("Output: ");
	    Problem1.print(input);
	    
	    // Problem 2
	    Date d = new Date(2000000000);

        Problem2Food gum = new Problem2Food("gum");
        Problem2Food las = new Problem2Food("lasagna");
        Problem2Fruit pom  = new Problem2Fruit("pomegranate", d);
        Problem2Fruit app = new Problem2Apple(d);
        Problem2Orange o = new Problem2Orange(d);
        Problem2Shrimp sh = new Problem2Shrimp();       
        Problem2Seafood p = new Problem2Prawn();
        Problem2Seafood l = new Problem2Seafood("lobster");

        sh.prepare();
        app.prepare();
        pom.prepare();
        o.prepare();
        gum.prepare();
        p.prepare();
        l.prepare();
        las.prepare();

        las = app;
        las.prepare();       

        o.ripeTime();
        pom.ripeTime();
        
        // Problem 3
        int c, n, i, s, arr[];
        
        Scanner in = new Scanner(System.in);    
        System.out.println("Enter number of elements");    
        n = in.nextInt();     
        arr = new int[n];
        
        System.out.println("Enter " + n + " integers.");
        for (c = 0; c < n; c++)      
        	arr[c] = in.nextInt();
        
        Problem3 sArr = new Problem3(arr, n);
        sArr.print();
        
        System.out.println("Insert a value into the list");    
        i = in.nextInt();
        sArr.insert(i);
        sArr.print();
        
        System.out.println("Enter value to find");    
        s = in.nextInt();    
        sArr.binarysearch(s);
        
        in.close();       
	}
}
