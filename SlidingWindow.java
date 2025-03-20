// Creating the slidingWIndow to finding the maximum in every sliding window
import java.util.*;

class SlidingWindow {
    public static void main(String[] args) {
        
        // Creating the scanner class to get user's input
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[7];  // Creating the array
        

        System.out.println("Enter elements in array ");
        for(int i= 0; i<arr.length;i++){
            arr[i] = scanner.nextInt();
        }
       
        // Getting the window size
        int windowSize = scanner.nextInt();
        
        // Checking the maximum element in every window
 
        System.out.print("\nFinal result is:");
        for(int i =0;i <arr.length - windowSize+1;i++){
        int maxEle = Integer.MIN_VALUE;
           for(int j = i; j < windowSize + i; j++){
               if(arr[j] >= maxEle) maxEle = arr[j];
           }    
           System.out.print(maxEle + " ");
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
// Final result is:
// 100 80 70 70 75 85
