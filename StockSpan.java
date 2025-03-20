// Creating the stock span class for spanning the stock prices
import java.util.*;

class StockSpan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[7]; // Creating a array to get input
        
       // Enter the elements
        System.out.println("Enter elements in array ");
        for(int i= 0; i<arr.length;i++){
            arr[i] = scanner.nextInt();
        }
        
        // Creating the stack
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[7];
        result[0] = 1;
        stack.push(0);
        
        // Checking the price is smaller or not than the current element
        for(int i = 1;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()]<= arr[i]){
                    stack.pop();
            }
             
             // getting the days
            if(stack.isEmpty()) result[i] = i + 1;
            else result[i] = i - stack.peek();
            
            stack.push(i);
        }
        
        System.out.print("\nFinal Result:");
      for(int i = 0; i< result.length;i++){
          System.out.print(result[i] + " ");
      }
    }
}


// Input:
// Enter elements in array 
// 100
// 80
// 60
// 70
// 60
// 75
// 85

// Output:
// Final Result:1 1 1 2 1 4 6 
