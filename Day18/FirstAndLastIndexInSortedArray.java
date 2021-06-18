package Day18;

import java.util.Arrays;
import java.util.Scanner;

public class FirstAndLastIndexInSortedArray {

/*
  
	Given a sorted array with possibly duplicate elements, the task is to find indexes of first and last occurrences of an element x in the given array. Note:- If the x is not found in the array, print -1 -1

	Input Format
	The first line contains two integers n and x. The second line contains n spaced integers.

	Constraints
	1<n <10^8

	-1< arr[i]<10^9

	Output Format
	Print index of the first and last occurrences of the number x with a space in between.

	Sample Input
	9 7
	1 3 5 5 5 5 7 123 125
	Sample Output
	6 6
	
*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new  int[n];
		for(int i=0;i<n;i++) {
			arr[i]= sc.nextInt();
		}
		int val = sc.nextInt();
		
		int valOccur = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == val ) {
				valOccur++;
			}
		}
		System.out.println(valOccur);
		
		
		int[] Output = new int[2];
		Arrays.fill(Output,-1);
		
		int count = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == val) {
				count++;
				if(count == 1) {
					Output[0] = i;
					System.out.println(i);
				}else if( count == valOccur) {
					Output[1] = i;
					System.out.println(i);
				}

			}
		}
		
	}

	

}
