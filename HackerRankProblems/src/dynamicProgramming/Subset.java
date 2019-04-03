package dynamicProgramming;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Subset {
	static int N;

	static int A;

	static int B;
	
	static int[] cost = new int[10000];
	
	static ArrayList<Integer> sol = new ArrayList<>();

	  private static final String[] tensNames = {
	    "",
	    "ten",
	    "twenty",
	    "thirty",
	    "forty",
	    "fifty",
	    "sixty",
	    "seventy",
	    "eighty",
	    "ninety"
	  };

	  private static final String[] numNames = {
	    "",
	    "one",
	    "two",
	    "three",
	    "four",
	    "five",
	    "six",
	    "seven",
	    "eight",
	    "nine",
	    "ten",
	    "eleven",
	    "twelve",
	    "thirteen",
	    "fourteen",
	    "fifteen",
	    "sixteen",
	    "seventeen",
	    "eighteen",
	    "nineteen"
	  };

	//  private EnglishNumberToWords() {}

	  static String convertLessThanOneThousand(int n) {
		  String soFar;
		  int number = n;
		  String a = Integer.toString(number);
		  String first = "" ;
		  boolean flag = false;
		  if(a.length()==4) {
			  flag = true;
			  first = numNames[number / 1000];
			 char[] b = a.toCharArray();
			 char[] c = new char[3];
			 c[0]= b[1];
			 c[1] = b[2];
			 c[2] = b[3];
			 a=new String(c);
			 number=Integer.parseInt(a);
			 //soFar.append(" thousand and ");
		  }
	    
	    
	    

	    if (number % 100 < 20){
	    	 soFar= numNames[number % 100];
	      number /= 100;
	    }
	    else {
	    	 soFar = numNames[number % 10];
	      number /= 10;

	      soFar = tensNames[number % 10] + soFar;
	      number /= 10;
	    }
	    if (number == 0) return soFar;
	   // soFar.(numNames[number] + " hundred");
	    
	    if(flag)
	    return first + " thousand and" + numNames[number] + " hundred" + soFar.toString();
	    else
	    return numNames[number] + " hundred" + soFar.toString();
	  
	  }

    public boolean subsetSum(int input[], int total) {

        boolean T[][] = new boolean[input.length + 1][total + 1];
        int W[][] = new int[input.length + 1][total + 1];
        for (int i = 0; i <= input.length; i++) {
            T[i][0] = true;
        }

        for (int i = 1; i <= input.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (j - input[i - 1] >= 0) {
                    T[i][j] = T[i - 1][j] || T[i - 1][j - input[i - 1]];
                    
                    if(T[i - 1][j] && T[i - 1][j - input[i - 1]])
                        W[i][j] = Subset.minimum(W[i - 1][j],( W[i - 1][j - input[i - 1]] + cost[(input[i - 1])]));             
                
                    else if(T[i - 1][j]) {
                    	W[i][j] = W[i - 1][j];
                    }
                    else if(T[i - 1][j - input[i - 1]]) {
                    	W[i][j] = W[i - 1][j - input[i - 1]] + cost[(input[i - 1])];
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
        
        solutions(T,W, total, input);
        
        return T[input.length][total];

    }
    
    public static int minimum(int a,int b) {
    	if(a==0) return b;
    	if( b==0) return a;
    	return a<b?a:b;
    }
    
    public void solutions(boolean T[][],int W[][],int weight,int input[]) {
   /* 	for(int i=input.length;i>0;i--) {
    		if(T[i][weight]==true) {
    			if(T[i-1][(weight)-input[i-1]]) {
    				System.out.print(input[i-1] + " ");
    			int j = (weight)-input[i-1];
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
    	int minimum = 0;
    	int indexi = input.length;
    	//int startindex = 
    	int atleast = 0;
    	//int min = 99999;
    	System.out.println(T[indexi][weight]);
    	System.out.println(W[indexi][weight]);
    	System.out.println("*************");
    	
   	do {
    		minimum = 99999;
    		
    	for(int i=indexi;i>0;i--) {
    		//System.out.println(W[i][weight]);
    		//System.out.println(W[i][weight]);
    		if(atleast>0) {
    		if(W[i][weight]>=atleast && W[i][weight]<minimum) {
    			minimum = W[i][weight];
    			indexi = i;
    		}
    		}
    		else {
    			if(W[i][weight]>0 && W[i][weight]<minimum) {
        			minimum = W[i][weight];
        			indexi = i;
        		}
    		}
    	}
    	atleast = minimum;
    	indexi -=1;
    	}
    	//System.out.println("*************");
    	//System.out.println(input[indexi-1]);
    	while(!isvalid(T,W,minimum,indexi+1,weight,input)) ;
    		
    	//printSubsetsRec(input,input.length,weight,sol,T);
    	
    	for(int y=0;y<sol.size();y++) {
    		System.out.println("Solution"+sol.get(y));
    	}
    	indexi+=1;
    	System.out.println(minimum);
    	System.out.println(W[indexi][weight]);
    	while(T[indexi][weight]) {
    		
    		if(indexi >0 && (W[indexi-1][(weight)]==minimum)) {
    			indexi = indexi-1;
    		}
    		else if(indexi >0 && ((weight)-input[indexi-1]) > -1 && T[indexi-1][(weight)-input[indexi-1]]){
    			System.out.print(input[indexi-1] + " ");
    			minimum = minimum -cost[(input[indexi-1])];
    			weight = (weight)-input[indexi-1];
    			indexi = indexi-1;
    			
    		}
    		
    		if(indexi==0) {
    			break;
    		}
    	}
    	
    }

    boolean isvalid(boolean T[][],int W[][],int minimum,int indexi,int weight,int input[]) {
    	boolean valid= false;
    	//int[] a =new int[N];
    	int ind = 0;
    	int con = 0;
    	int k=0;
    	if(indexi<1)
    		return false;
    	
	while(T[indexi][weight]) {
    		
    		if(indexi >0 && (W[indexi-1][(weight)]==minimum)) {
    			indexi = indexi-1;
    		}
    		else if(indexi >0 && ((weight)-input[indexi-1]) > -1 && T[indexi-1][(weight)-input[indexi-1]]/* && (con+input[indexi-1])<((A*(ind+1))+B) && (ind+1)<N*/){
    			//System.out.print(input[indexi-1] + " ");
    			con += input[indexi-1];
    			ind++;
    			sol.add(k, input[indexi-1]);
    			k++;
    			if(con > ((A*ind)+B)) {
    				return false;
    			}
    			/*if(ind>N) {
    				return false;
    			}*/
    			if(con==weight && ind == N) {
    				return true;
    			}
    			minimum = minimum - cost[(input[indexi-1])];
    			weight = (weight)-input[indexi-1];
    			indexi = indexi-1;
    			
    		}/*else if(T[indexi-1][(weight)]) {
    			indexi = indexi-1;
    		}*//*else {
    			minimum = minimum + cost[sol.get(k)];
    			weight = (weight)+sol.get(k);
    			k--;
    			indexi=indexi+1;
    			
    		}*//*else {
    			return false;
    		}*/
    		
    		if(indexi==1) {
    			break;
    		}
    	}
	
	
    	return false;
    }

    static void display(ArrayList<Integer> v) 
    { 
       System.out.println(v); 
    } 
       
    // A recursive function to print all subsets with the 
    // help of dp[][]. Vector p[] stores current subset. 
    static void printSubsetsRec(int arr[], int i, int sum,  
                                         ArrayList<Integer> p,boolean dp[][]) 
    { 
        // If we reached end and sum is non-zero. We print 
        // p[] only if arr[0] is equal to sun OR dp[0][sum] 
        // is true. 
        if (i == 0 && sum != 0 && dp[0][sum]) 
        { 
            p.add(arr[i]); 
            int f = 0;
            for(int g=0;g<p.size();g++) {
            	f+=p.get(g);
            }
            if(((p.size()*A)+B)<f && p.size()==N) {
            display(p); }
            p.clear(); 
            return; 
        } 
       
        // If sum becomes 0 
        if (i == 0 && sum == 0) 
        { 
        	int f = 0;
            for(int g=0;g<p.size();g++) {
            	f+=p.get(g);
            }
            if(((p.size()*A)+B)<f && p.size()==N) {
            display(p); }
            p.clear(); 
            return; 
        } 
       
        // If given sum can be achieved after ignoring 
        // current element. 
        if (dp[i-1][sum]) 
        { 
            // Create a new vector to store path 
            ArrayList<Integer> b = new ArrayList<>(); 
            b.addAll(p); 
            printSubsetsRec(arr, i-1, sum, b,dp); 
        } 
       
        // If given sum can be achieved after considering 
        // current element. 
        if (sum >= arr[i] && dp[i-1][sum-arr[i]]) 
        { 
            p.add(arr[i]); 
            printSubsetsRec(arr, i-1, sum-arr[i], p,dp); 
        } 
    } 
    
    public static void main(String args[]) throws IOException {
        Subset ss = new Subset();
        int arr[] = {1, 3, 5, 5, 2, 1, 1, 6};
       // System.out.println(ss.partition(arr));

        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Sandeep\\Workspaces\\ProjectWorkSpace\\HackerRankProblems\\src\\dynamicProgramming\\input.txt"));
        for(int i=0;i<10000;i++) {
        	String[] a = bufferedReader.readLine().split(" ");
        	cost[i] = Integer.parseInt(a[1]);
        }
        
        
        // int arr1[] = {91,91,91, 92,92,92,93,93,93,94,94,94,95,95,95,96,96,97,97,97,98,98,98,99,99,99,100,100,100,101,101,101,102,102,102,103,103,103};
      //  int arr1[] = {20,40,20,39,21,20,19,1,38,22,20,18,2,37,23,20,17,3,36,24,20,16,4,35,25,20,15,5,34,26,20,14,6,33,27,20,13,7,32,28,20,12,8,31,29,20,11,9,30,30,20,10,20,40,20,39,21,20,19,1,38,22,20,18,2,37,23,20,17,3,36,24,20,16,4,35,25,20,15,5,34,26,20,14,6,33,27,20,13,7,32,28,20,12,8,31,29,20,11,9,30,30,20,10};
        Scanner scanner = new Scanner(System.in);
       // int arr1[] = {100,100,200};
        int n = scanner.nextInt();
        
        int k=0;
        for(int i=0;i<n;i++) {
        	k=0;
        	N =  scanner.nextInt();
        	A =  scanner.nextInt();
        	B =  scanner.nextInt();
        	int total = 0;
        	if((A-B) == 0)
        		total = (2*B)*N;
        	else
        	 total = (2*B+1)*N;
        	// k=total-1;
        	int arr2[] = new int[total];
        	for( int j=0;j<(B+1);j++) {
        		for(int u=0;u<N;u++) {
        			if(A-(B-j)!=0)
        		arr2[k++]=A-(B-j);
        		}
        		//arr2[k++]=A-(B-j);
        		//arr2[k++]=A-(B-j);
        	}
        	for( int j=B;j>(0);j--) {
        		for(int u=0;u<N;u++) {
        		arr2[k++]=A+((B+1)-j);
        		}
        		//arr2[k++]=A+(B-j);
        		//arr2[k++]=A+(B-j);
        	}
        	
        	ss.subsetSum(arr2, (A*N));
        }
       // System.out.print(ss.subsetSum(arr1, (291)));

    }
}
