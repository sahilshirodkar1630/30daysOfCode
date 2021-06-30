package Day27;
import java.util.Scanner;

public class Loot_Houses {
	/*
	 * A thief wants to loot houses. He knows the amount of money in each house. 
	 * He cannot loot two consecutive houses. 
	 * Find the maximum amount of money he can loot.
	 * 
	 * Input format :
		The first line of input contains an integer value of 'n'.
		It is the total number of houses.
		The second line of input contains 'n' integer values separated by a 
		single space denoting the amount of money each house has.
		Output format :
			Print the the maximum money that can be looted.
		Constraints :
		`	0 <= n <= 10 ^ 4
		
		Time Limit: 1 sec
	 * Sample Input 1 :
			6
			5 5 10 100 10 5
		Sample Output 1 :
			110
		
		Sample Input 2 :
			6
			10 2 30 20 3 50
		Sample Output 2 :
			90
		Explanation of Sample Output 2 :
		Looting first, third, and the last houses([10 + 30 + 50]) will result in the maximum loot,
		 and all the other possible combinations would result in less than 90.
	 */

	public static int maxMoneyLooted(int[] houses) {
		//Your code goes here
        if(houses.length==0){
            return 0;
        }
        int[] dp = new int[houses.length];
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0],houses[1]);
        System.out.println(dp[0]+" "+dp[1]);
        for(int i=2;i<dp.length;i++){
            dp[i] = Math.max(dp[i-2]+houses[i],dp[i-1]);   
            System.out.println(dp[i] + " "+i);
        }
        return dp[houses.length-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(maxMoneyLooted(arr));
		
	}

}
