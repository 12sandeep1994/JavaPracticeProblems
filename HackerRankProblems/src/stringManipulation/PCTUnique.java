package stringManipulation;

import java.util.HashMap;
import java.util.Scanner;

public class PCTUnique {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[]	input = scanner.nextLine().split("\\s+");
		HashMap<String, Integer> a = new HashMap<>();
		for(String s : input) {
			String b = s.toLowerCase();
			if(a.containsKey(b)) {
				a.put(b, a.get(b)+1);
			}
			else {
				a.put(b, 1);
			}
		}
		System.out.println(a.size());
	}

}
