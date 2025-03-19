import java.util.*;

public class implementueueUsingStack
{
    public static void enqueue(int ele,Stack<Integer> enque){
        enque.add(ele);
    }
    
    
    public static void deque(Stack<Integer> enque){
        
        Stack<Integer> reverse = new Stack<>();
        
        while(enque.size() > 1){
            reverse.add(enque.pop());
        }
        
        System.out.print(enque.pop() + " ");
        
        while(reverse.size() > 0){
            enque.add(reverse.pop());
        }
        
    }
	public static void main(String[] args) {
		Stack<Integer> enque = new Stack<>();
		
		System.out.println("Do you want to start this program");
		Scanner scanner = new Scanner(System.in);
		String space = scanner.next();
		
		while(space.equals("true")){
		    System.out.print("\nAdd new Element ");
		    int ele = scanner.nextInt();
		    scanner.nextLine();
		    
		    enqueue(ele, enque);
		    
		    System.out.print("Do you want to continue this program ");
		    space = scanner.nextLine();
		}
		
		System.out.println("Elemets are printing according to FIFO algorithm");
		while(enque.size()> 0){
		    deque(enque);
		    
		}
		
	}
}

// Input:
// Do you want to start this program
// true

// Add new Element 1
// Do you want to continue this program true

// Add new Element 2
// Do you want to continue this program true

// Add new Element 3

// Output:
// Do you want to continue this program false
// Elemets are printing according to FIFO algorithm
// 1 2 3 
