package stringManipulation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SpecialPalindrome {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
    	long b = s.length();
    	for(int i=0;i<s.length();i++) {
    		//System.out.println(b);
    		int k=i;
    		int y=k+2;
    		boolean a=false;
    		while(y<=n && isSame(s.substring(k, y))) {
    			y++;
    			b++;
    			//a=true;
    		}
    		/*if(a) {
    			continue;
    		}*/
    		int m=i;
    		int j=m;
    		boolean con = true;
    		while(con) {
    			m=i;
    			 j=j+2;
    			int l=j;
    			if(j<n) {
    		/*	if(isSame(s.substring(m, l+1))) {
    				con = false;
    				break;
    			}*/
    			while( m!=l) {
    				if(s.charAt(m)==s.charAt(l) && s.charAt(m)==s.charAt(i) &&   s.charAt(l)==s.charAt(j)) {
    					m++;
    					l--;
    					
    				}
    				
    					else {
    				
    					//con=false; m+1!=l-1 &&
    					break;
    				}
    				if(m!=l && m+1!=l-1 && m+2!=l-2 && m+3!=l-3 && m+4!=l-4 &&(s.charAt(m)!=s.charAt(i) || s.charAt(j)!=s.charAt(l))){
     					con=false;
     					break;
     				}
    				
    			}
    			if(m==l ) {
    				if(s.charAt(m)!=s.charAt(i) &&  s.charAt(m)!=s.charAt(j)) {
    					b++;
        			}
    				}
    				
    		}
    			else {
    				//System.out.println(b);
    				con = false;
    			}
    		}
    	}
    	return b;
    }

    private static boolean isSame(String substring) {
    	if(substring.length()>1) {
    	Character c = substring.charAt(0);
    	for(int i=1;i<substring.length();i++) {
    		if(c!=substring.charAt(i)) {
    			return false;
    		}
    	}
    	}
		return true;
	}

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);
        System.out.println(result);
/*
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
*/
        scanner.close();
    }
}
