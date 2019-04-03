package dynamicProgramming;

import java.util.Scanner;

public class SubsetNew {

	
	
	  public static void main(String args[]) {
	        Subset ss = new Subset();
	        int arr[] = {1, 3, 5, 5, 2, 1, 1, 6};
	       // System.out.println(ss.partition(arr));

	       // int arr1[] = {91,91,91, 92,92,92,93,93,93,94,94,94,95,95,95,96,96,97,97,97,98,98,98,99,99,99,100,100,100,101,101,101,102,102,102,103,103,103};
	        //int arr1[] = {2,2,2,3,3,6,1,1};
	        Scanner scanner = new Scanner(System.in);
	       // int arr1[] = {100,100,200};
	        int n = scanner.nextInt();
	        int N,A,B;
	        int k=0;
	        for(int p=0;p<n;p++) {
	        	k=0;
	        	N =  scanner.nextInt();
	        	A =  scanner.nextInt();
	        	B =  scanner.nextInt();
	        	int totalsum = (2*B+1)*N;
	        	int arr2[] = new int[totalsum];
	        	for( int s=0;s<(B+1);s++) {
	        		for(int u=0;u<N;u++) {
	        		arr2[k++]=A-(B-s);
	        		}
	        		//arr2[k++]=A-(B-j);
	        		//arr2[k++]=A-(B-j);
	        	}
	        	for( int s=0;s<(B);s++) {
	        		for(int u=0;u<N;u++) {
	        		arr2[k++]=A+(B-s);
	        		}
	        		//arr2[k++]=A+(B-j);
	        		//arr2[k++]=A+(B-j);
	        	}
	        	//ss.subsetSum(arr2, (A*N));
	        	int total = A*N;


	            boolean T[][] = new boolean[totalsum + 1][total + 1];
	            int W[][] = new int[totalsum + 1][total + 1];
	            for (int i = 0; i <= totalsum; i++) {
	                T[i][0] = true;
	            }

	            for (int i = 1; i <= totalsum; i++) {
	                for (int j = 1; j <= total; j++) {
	                    if (j - arr2[i - 1] >= 0) {
	                        T[i][j] = T[i - 1][j] || T[i - 1][j - arr2[i - 1]];
	                        
	                        if(T[i - 1][j] && T[i - 1][j - arr2[i - 1]])
	                            W[i][j] = Subset.minimum(W[i - 1][j],( W[i - 1][j - arr2[i - 1]] + Subset.convertLessThanOneThousand(arr2[i - 1]).length()));             
	                    
	                        else if(T[i - 1][j]) {
	                        	W[i][j] = W[i - 1][j];
	                        }
	                        else if(T[i - 1][j - arr2[i - 1]]) {
	                        	W[i][j] = W[i - 1][j - arr2[i - 1]] + Subset.convertLessThanOneThousand(arr2[i - 1]).length();
	                        }
	                    }
	                    else {
	                        T[i][j] = T[i-1][j];
	                        if(T[i - 1][j]) {
	                        	W[i][j] = W[i - 1][j];
	                        }
	                    }
	                }
	            }
	            
	          /*  for (int i = 0; i <= input.length; i++) {
	                for (int j = 0; j <= total; j++) {
	                	System.out.print(W[i][j]+" ");
	                }
	                System.out.println();
	                }*/
	            
	         //   solutions(T,W, total, input);
	            
	            

	            /* 	for(int i=input.length;i>0;i--) {
	             		if(T[i][total]==true) {
	             			if(T[i-1][(total)-input[i-1]]) {
	             				System.out.print(input[i-1] + " ");
	             			int j = (total)-input[i-1];
	             			int k=i-1;
	             			while(T[k][j]) {
	             				if((j-input[k-1] > -1) && T[k-1][j-input[k-1]]) {
	             					System.out.print(input[k-1]+ " ");
	             					k = k-1;
	             					j = j-input[k-1];
	             					
	             				}else if(T[k-1][j]) {
	             					k = k-1;
	             				}
	             			}
	             		}else {
	             			break;
	             		}
	             		}
	             		System.out.println();
	             	}*/
	             	int minimum = 99999;
	             	int indexi = 0;
	             	for(int i=arr2.length;i>0;i--) {
	             		//System.out.println(W[i][total]);
	             		if(W[i][total]>0 && W[i][total]<=minimum) {
	             			minimum = W[i][total];
	             			indexi = i;
	             		}
	             	}
	             	//System.out.println(input[indexi-1]);
	             	
	             	System.out.println(minimum);
	             	System.out.println(W[indexi][total]);
	             	while(T[indexi][total]) {
	             		
	             		if(indexi >0 && (W[indexi-1][(total)]==minimum)) {
	             			indexi = indexi-1;
	             		}
	             		else if(indexi >0 && ((total)-arr2[indexi-1]) > -1 && T[indexi-1][(total)-arr2[indexi-1]]){
	             			System.out.print(arr2[indexi-1] + " ");
	             			minimum = minimum - Subset.convertLessThanOneThousand(arr2[indexi-1]).length();
	             			total = (total)-arr2[indexi-1];
	             			indexi = indexi-1;
	             			
	             		}
	             		
	             		if(indexi==0) {
	             			break;
	             		}
	             	}
	             	
	             
	           // return T[input.length][total];

	        
	        	
	        }
	       // System.out.print(ss.subsetSum(arr1, (291)));

	    }
}
