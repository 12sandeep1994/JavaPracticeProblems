package dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class OptimalPay {

	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<>();
		//ArrayList<Integer> bills = new ArrayList<>();
		
		HashMap<Integer, Integer> output = new HashMap<>();
		int toBePaid;
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for(int i=0;i<n;i++) {
			input.add(scanner.nextInt());
		//	bills.add(0);
		}
		toBePaid = scanner.nextInt();
		int optimalSolution[] = new int[toBePaid+1];
		int bills[] = new int[toBePaid+1];
		for(int i=1;i<=toBePaid;i++) {
			optimalSolution[i]= 9999;
			bills[i]= -1;
			for(int j=0;j<input.size();j++) {
				if(!(i-input.get(j)<0)) {
					int temp =1 + optimalSolution[i-input.get(j)];
					if(temp<optimalSolution[i]) {
						optimalSolution[i]= temp;
						bills[i]= j;
					}
				}
			}
		}
		
		System.out.println(optimalSolution[toBePaid]);
		System.out.println("Solution");
		while(toBePaid>0 && bills[toBePaid]>=0) {
			System.out.println(input.get(bills[toBePaid]));
			toBePaid = toBePaid - input.get(bills[toBePaid]);
		}
	}
}
