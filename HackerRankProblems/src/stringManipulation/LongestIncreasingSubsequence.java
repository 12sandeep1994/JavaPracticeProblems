package stringManipulation;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	 public static void main(String args[]) 
	    { 
	        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 }; 
	            int n = arr.length; 
	            System.out.println("Length of lis is " + lis( arr, n ) + "\n" ); 
	    }

	private static int lis(int[] arr, int n) {
		int res=0;
		int[] a = new int[arr.length];
		Arrays.fill(a, 1);
		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(arr[j]<arr[i]) {
					a[i]=max(a[i],a[j]+1);
				}
			}
		}
		for(int i=0;i<a.length;i++) {
			if(a[i]>res) {
				res=a[i];
			}
		}
		
		return res;
	}

	private static int max(int i, int j) {
		// TODO Auto-generated method stub
		return i>j?i:j;
	} 
}
