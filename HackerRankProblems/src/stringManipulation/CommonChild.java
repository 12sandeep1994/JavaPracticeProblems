package stringManipulation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CommonChild {



    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
    	int m=s1.length();
    	int n=s2.length();
    	int[][] L = new int[m+1][n+1];
    	
    	for(int i=0;i<=m;i++) {
    		for(int j=0;j<=n;j++) {
    			if(i==0 || j==0) {
    				L[i][j] = 0;
    			}
    			else if(s1.charAt(i-1)==s2.charAt(j-1)) {
    				L[i][j] = 1 + L[i-1][j-1];
    			}else {
    				L[i][j] = max(L[i][j-1],L[i-1][j]);
    			}
    		}
    	}
    	for(int i=0;i<=m;i++) {
    		System.out.println();
    		for(int j=0;j<=n;j++) {
    			System.out.print(L[i][j]);
    			
    		}	
    	}
    	
    	return L[m][n];

    }

    static int max(int a, int b) 
    { 
      return (a > b)? a : b; 
    } 
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

      //  bufferedWriter.write(String.valueOf(result));
       // bufferedWriter.newLine();

       // bufferedWriter.close();
        System.out.println(result);
        scanner.close();
    }
}
