
import java.util.*;

public class findZeroSumSubarrays {

    // Method to find all subarrays with sum zero
    public static void findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();  // To store cumulative sum and its indices
        List<String> result = new ArrayList<>();             // To store the result

        int cumulativeSum = 0;

        // Add the initial sum (0) at index -1 for cases where subarray starts from index 0
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];

            // Check if the cumulative sum was seen before
            if (map.containsKey(cumulativeSum)) {
                List<Integer> indices = map.get(cumulativeSum);
                
                // Add all subarrays from previous occurrences to current index
                for (int startIdx : indices) {
                    result.add("Subarray from index " + (startIdx + 1) + " to " + i);
                }
            }

            // Add current index to the list of occurrences of the current sum
            map.putIfAbsent(cumulativeSum, new ArrayList<>());
            map.get(cumulativeSum).add(i);
        }

        // Display the result
        if (result.isEmpty()) {
            System.out.println("No zero-sum subarrays found.");
        } else {
            System.out.println("Zero-sum subarrays:");
            for (String subarray : result) {
                System.out.println(subarray);
            }
        }
    }

    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {4, 2, -3, 1, 6};
        int[] arr2 = {1, 2, -3, 3, 1, -4, 2};
        int[] arr3 = {1, 2, 3, -6, 4, -4, 2, -2};

        System.out.println("Test Case 1:");
        findZeroSumSubarrays(arr1);

        System.out.println("\nTest Case 2:");
        findZeroSumSubarrays(arr2);

        System.out.println("\nTest Case 3:");
        findZeroSumSubarrays(arr3);
    }
}
