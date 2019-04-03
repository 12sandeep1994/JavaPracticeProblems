package stringManipulation;

import java.util.Scanner;
import java.util.Stack;

public class PCTbrackets {

	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		n=scanner.nextInt();
		scanner.nextLine();
		//boolean res=true;
		for(int i=0;i<n;i++) {
			boolean res=true;
			String s = scanner.nextLine();
			Stack<Character> characters = new Stack<>();
			char[] a = s.toCharArray();
			for(int j=0;j<a.length;j++) {
				if(a[j]=='(' || a[j]=='{' || a[j]=='[') {
					characters.push(a[j]);
				}
				else if(a[j]==')') {
					if(characters.pop()=='(') {
						//continue;
					}else {
						res=false;
						break;
					}
				}
				else if(a[j]=='}') {
					if(characters.pop()=='{') {
						//continue;
					}else {
						res=false;
						break;
					}
				}
				else if(a[j]==']') {
					if(characters.pop()=='[') {
						//continue;
					}else {
						res=false;
						break;
					}
				}
				else {
					//ontinue;
				}
			}
			if(res)
			System.out.println("TRUE");
			else
				System.out.println("FALSE");
		}
	}

}
