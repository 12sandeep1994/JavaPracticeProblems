package stringManipulation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Sherloack {

    // Complete the isValid function below.
    static String isValid(String s) {
    	String res = "YES";
    	int j=0;
    	HashMap<Character, Integer> old = new HashMap<>();
    	for(int i=0;i<s.length();i++) {
    		if(old.containsKey(s.charAt(i))) {
    			old.put(s.charAt(i),old.get(s.charAt(i))+1);
    		}
    		else {
    			old.put(s.charAt(i),1);
    		}
    	}
    	Integer l=old.get(s.charAt(0));
    	
    	for(Character ce : old.keySet()) {
    		Integer k=old.get(ce);
    		if(l==k) {
    			
    		}else if(l-k==1 || l-k==-1 || k==1) {
    			j++;
    		}
    		else {
    			if(l-k>=2 || l-k<=-2) {
    				return "NO";
    			}
    		}
    		if(j>=2) {
    			return "NO";
    		}
    	}
    	
    	return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);
        System.out.println(result);
      /*  bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }
}
