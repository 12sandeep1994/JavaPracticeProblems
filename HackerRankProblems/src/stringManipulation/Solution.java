package stringManipulation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
    	int n=0;
    	HashMap<Character, Integer> old = new HashMap<>();
    	HashMap<Character, Integer> ne = new HashMap<>();
    	for(int i=0;i<a.length();i++) {
    		if(old.containsKey(a.charAt(i))) {
    			old.put(a.charAt(i),old.get(a.charAt(i))+1);
    		}
    		else {
    			old.put(a.charAt(i),1);
    		}
    	}
    	
    	for(int i=0;i<b.length();i++) {
    		if(ne.containsKey(b.charAt(i))) {
    			ne.put(b.charAt(i),ne.get(b.charAt(i))+1);
    		}
    		else {
    			ne.put(b.charAt(i),1);
    		}
    	}
    	
    	for(Character ce : old.keySet()) {
    		
			int oldn= old.get(ce);
    		if(ne.containsKey(ce)) {
    		int nen= ne.get(ce);
    		int res = oldn-nen;
    		if(res<0) {
    			res*=-1;
    		}
    		n = n+res;
    		}else {
    			n = n+oldn;
    		}
    		
    	}
    	for(Character ce : ne.keySet()) {
    		int nen=ne.get(ce);
    		if(!old.containsKey(ce)) {
    			n = n+nen;
    		}
    	}
    	return n;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);
/*
        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();
*/
        System.out.println(res);
        scanner.close();
    }
}
