package grading;

public class Missing {
	   final private static double DEFAULT_MISSING_VALUE = 0.0;
	  
	   public static double doubleValue(Double number)
	   {
	       if(number.equals(null))
	       {
	           //print default
	           return DEFAULT_MISSING_VALUE;
	       }
	       else
	       {
	           return number *2;
	       }
	   }
	   public static double doubleValue(Double number, double missingValue)
	   {
	       if(number.equals(null))
	       {
	           return missingValue;
	       }
	       else
	       {
	           return missingValue * number;
	       }
	   }
	  
	}