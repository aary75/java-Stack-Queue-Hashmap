// Creating the class ConsecutiveSubserquence to find the longest subsequence of integers
import java.util.*;

public class ConsecutiveSubsequence{
    public static void main(String[] args){
 
        Scanner scanner = new Scanner(System.in); // scanner class to get user's input
 
        System.out.print("Enter the size: ");
        int size = scanner.nextInt();  // declare the size of hashset
        
         HashSet<Integer> hs = new HashSet<>();  // Creating the hashset
        

        System.out.println("Enter elements in hashset ");
        for(int i= 0; i<size;i++){
            hs.add(scanner.nextInt());
        }
        
        System.out.print("The size of longest consecutive subsequence: ");
        System.out.print(hs.size());
    }
}

// Input:
// Enter the size: 6
// Enter elements in hashset
// 1
// 2
// 2
// 3
// 4
// 5

// Output:
// The size of longest consecutive subsequence: 5
