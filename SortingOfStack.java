import java.util.*;

public class SortingOfStack
{
    // stack to hold the sorted elements
    static Stack<Integer> sort = new Stack<>();
    
    // stack to hold the greater elements temporily
    static Stack<Integer> greaterThan = new Stack<>();
    
    public static Stack<Integer> sorting(Stack<Integer> stack){
        
        // is stack is empty, return the stack
        if(stack.size() == 0) return sort;
        
        // getting the element from stack
        int ele = stack.pop();
        
        // if the sorted stack is empty, add the element directly
        if(sort.size() == 0){
            sort.add(ele);
            
        }
        else{
           //  move the greater than teh current element to the greaterThan stack
            while(sort.size() > 0 && sort.peek() > ele){
                greaterThan.add(sort.pop());
            }
         
            // add the current element to its correct position
            sort.add(ele);
            
            // psuh back the elements from greaterThan stack to sort stack
            while(greaterThan.size() > 0) sort.add(greaterThan.pop());
        }
        
        // recursively call sorting with the remaining elements
        sorting(stack);
        return sort;
        
    }
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Do you want to start the program ");
		String space = scanner.nextLine();
		
		// stack to hold the user input elements
		Stack<Integer>stack = new Stack<>();
		
		// loop to continuously add elements unitl the user choose to stop
		while(space.equals("true")){
		    
		   System.out.print("Enter new element ");
		   int ele = scanner.nextInt();
		   scanner.nextLine();

           // add the element to the stack		   
		   stack.add(ele);
		   
		   System.out.print("Do you want to continue this program ");
		   space = scanner.nextLine();
		}
		
		System.out.println("\nStack without sorting");
		System.out.print(stack);
		
		System.out.println("\nStack after sorting");
		Stack<Integer> result = sorting(stack);
        System.out.print(result);
	} 
}

// Input:
// Do you want to start the program true
// Enter new element 1
// Do you want to continue this program true
// Enter new element 3 
// Do you want to continue this program true
// Enter new element 2
// Do you want to continue this program true
// Enter new element 5
// Do you want to continue this program true
// Enter new element 4
// Do you want to continue this program false

// Output:
// Stack without sorting
// [1, 3, 2, 5, 4]
// Stack after sorting
// [1, 2, 3, 4, 5]
