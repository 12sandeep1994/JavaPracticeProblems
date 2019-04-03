package dynamicProgramming;

public class NumbersToEnglish {

	  private static final String[] tensNames = {
	    "",
	    " ten",
	    " twenty",
	    " thirty",
	    " forty",
	    " fifty",
	    " sixty",
	    " seventy",
	    " eighty",
	    " ninety"
	  };

	  private static final String[] numNames = {
	    "",
	    " one",
	    " two",
	    " three",
	    " four",
	    " five",
	    " six",
	    " seven",
	    " eight",
	    " nine",
	    " ten",
	    " eleven",
	    " twelve",
	    " thirteen",
	    " fourteen",
	    " fifteen",
	    " sixteen",
	    " seventeen",
	    " eighteen",
	    " nineteen"
	  };

	//  private EnglishNumberToWords() {}

	  private static String convertLessThanOneThousand(int n) {
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
	  
	  public static void main(String[] args) {
		    System.out.println("*** " + NumbersToEnglish.convertLessThanOneThousand(0) + "***" +  NumbersToEnglish.convertLessThanOneThousand(0).length());
		    System.out.println("*** " + NumbersToEnglish.convertLessThanOneThousand(1) + "***" +  NumbersToEnglish.convertLessThanOneThousand(1).length());
		    System.out.println("*** " + NumbersToEnglish.convertLessThanOneThousand(45)  + "***" +  NumbersToEnglish.convertLessThanOneThousand(45).length());
		    System.out.println("*** " + NumbersToEnglish.convertLessThanOneThousand(100) + "***" +  NumbersToEnglish.convertLessThanOneThousand(100).length());
		    System.out.println("*** " + NumbersToEnglish.convertLessThanOneThousand(118)  + "***" +  NumbersToEnglish.convertLessThanOneThousand(118).length());
		    System.out.println("*** " + NumbersToEnglish.convertLessThanOneThousand(200) + "***" +  NumbersToEnglish.convertLessThanOneThousand(200).length());
		    System.out.println("*** " + NumbersToEnglish.convertLessThanOneThousand(219));
		    System.out.println("*** " + NumbersToEnglish.convertLessThanOneThousand(845));
		    System.out.println("*** " + NumbersToEnglish.convertLessThanOneThousand(801));
		    System.out.println("*** " + NumbersToEnglish.convertLessThanOneThousand(9316));
	  }
}
	  
	  