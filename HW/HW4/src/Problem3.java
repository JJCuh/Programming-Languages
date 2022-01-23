
public class Problem3 {
	
	private int[] sortedList;
	private int size;
	
	public Problem3(){
		size = 0;
		for(int i = 0; i < size; i++)
			sortedList[i] = 0;
	}
	
	public Problem3(int[] arr, int s){
		sortedList = arr;
		size = s;
		quicksort();
	}
	
	public void insert(int a){
		size++;
		int[] arr = new int[size];
		for(int i = 0; i < size - 1; i++)
			arr[i] = sortedList[i];
		arr[size - 1] = a;
		sortedList = arr;
	}
	
	public void quicksort(){
		Problem1.quicksort(sortedList, 0, size - 1);
	}
	
	public int binarysearch(int search){
		int first = 0;    
		int last = size - 1;    
		int middle = (first + last)/2;
		
		while (first <= last){      
			if (sortedList[middle] < search)        
				first = middle + 1;          
			else if (sortedList[middle] == search){        
				System.out.println(search + " found at location " + middle + ".");          
				return middle;      
			}      
			else         
				last = middle - 1;      
			
			middle = (first + last)/2;
		}
		
		//if (first > last)
			System.out.println(search + " is not present in the list.\n");
			return -1;      	  
	}
	
	public void print(){
		for(int i = 0; i < size-1; i++) {
			System.out.print(sortedList[i] + ", ");
		}
		System.out.println(sortedList[size-1]);
	}
//end of class
}
