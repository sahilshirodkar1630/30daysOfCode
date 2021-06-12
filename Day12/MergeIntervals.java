package Day12;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
		and return an array of the non-overlapping intervals that cover all the intervals in the input.
				
			Example 1:
				Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
				Output: [[1,6],[8,10],[15,18]]
				Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
				
			Example 2:
				Input: intervals = [[1,4],[4,5]]
				Output: [[1,5]]
				Explanation: Intervals [1,4] and [4,5] are considered overlapping.
	
*/
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int array2D[][] = new int[r][c];
		
		for(int j=0;j<r;j++) {
			for(int i=0;i<c;i++) {
				array2D[j][i] = sc.nextInt();
			}
		}
		
	}
	public int[][] merge(int[][] intervals) {
        
        ArrayList<int[]> res = new ArrayList<int[]>();
        if(intervals.length==0){
            return res.toArray(new int[0][]);
        }
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for(int[] i : intervals){
            if(i[0]<=end){
                end = Math.max(end,i[1]);
            }else{
                res.add(new int[]{start,end});
                start = i[0];
                end = i[1];
            }
        }
        res.add(new int[]{start,end});
        
        return res.toArray(new int[0][]);
        
        
    }

}
