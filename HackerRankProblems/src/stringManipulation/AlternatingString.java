package stringManipulation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AlternatingString {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        int i=0;
        int n=0;
        while(i<s.length()){
            Character a = s.charAt(i);
            i++;
            while(i < s.length() && (s.charAt(i)==a)  ){
                i++;
                n++;
            }
        }
        return n;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);
            System.out.println(result );
/*syso
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();*/
        }

        //bufferedWriter.close();

        scanner.close();
    }
}
