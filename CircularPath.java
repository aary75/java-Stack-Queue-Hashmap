// Creating the class circularPath to find the starting point to start
import java.util.*;

class CircularPath {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in); // scanner class to get user's input
       
       System.out.print("Number of petrol pumps we have ");
       int petrolPump = scanner.nextInt();
       scanner.nextLine();
       
       int[][] p = new int[petrolPump][2];
       
       // first number show the petrol present at that petrol pump
       // second number show the distance between next petrol pump
       for(int i= 0;i<petrolPump;i++){
           p[i][0] = scanner.nextInt();
           p[i][1] = scanner.nextInt();
       }
       
       int start = 0;
       int requiredFuel = 0;
       int extraFuel = 0;
       
       for(int i = 0;i<petrolPump;i++){
           extraFuel += (p[i][0] - p[i][1]);
           if(extraFuel < 0){
               start = i + 1;
               requiredFuel += extraFuel;
               extraFuel = 0;
           }
         }
         if (requiredFuel + extraFuel >= 0) System.out.print(start);
         else System.out.print(-1);
    }
}

// Input
// Number of petrol pumps we have 5
// 11 9
// 7 7
// 6 5
// 7 6
// 8 7

// Output
// 0
