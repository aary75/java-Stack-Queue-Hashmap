// Creating sumArrayParir class to find the pair whose sum is equal to targetSum
import java.util.*;

public class SumArrayPair
{
	public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in); // Creating the scanner class
        
        System.out.print("Enter the size: ");
        int size = scanner.nextInt();
        
        int[] arr = new int[size];  // Creating the array
        
        // Filling variables in array
        System.out.println("Enter elements in array ");
        for(int i= 0; i<arr.length;i++){
            arr[i] = scanner.nextInt();
        }
        
        // sum we have to find
        System.out.print("\nTaget sum: ");
        int targetSum = scanner.nextInt();
        
        // Creating the hashmap
        HashMap<Integer,Integer> mp = new HashMap<>();
        
        // Find the pairs the sum is equal to targetSum or not
        System.out.print("Resulted pairs: \n");
        for(int i = 0; i<arr.length; i++){
            if(mp.containsKey(targetSum - arr[i])){
                System.out.println(arr[i] + " " + (targetSum - arr[i]));
            }
            else{
                mp.put(arr[i], 0);
            }
        }
       
	}
}


// Enter the size: 6
// Enter elements in array 
// 1 2 3 4 5 6

// Taget sum: 6
// Resulted pairs: 
// 4 2
// 5 1
