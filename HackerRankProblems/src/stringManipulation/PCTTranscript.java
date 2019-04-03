package stringManipulation;

import java.util.ArrayList;
import java.util.Scanner;

public class PCTTranscript {

	public static void main(String[] args) {
		String a= "av;";
		
		ArrayList<String> name = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		String[] names = scanner.nextLine().split(" ");
		if(names.length==3) {
			System.out.println(names[2]+" "+names[0]+" "+names[1]);
		}
		else if(names.length==2) {
			if(names[1].endsWith("a") || names[1].endsWith("e") || names[1].endsWith("i") || names[1].endsWith("o") || names[1].endsWith("u")
					|| names[1].endsWith("A") || names[1].endsWith("E") || names[1].endsWith("I") || names[1].endsWith("O") || names[1].endsWith("U")) {
				System.out.println(names[1]+" "+names[0]);
			}
			else {
				System.out.println(names[0]+" "+names[1]);
			}
		}
		else {
			System.out.println(names[0]);
		}
	}
	

}
