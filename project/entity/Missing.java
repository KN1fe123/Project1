package entity;


/*
 * Author: Abhishek Chandak,Rishiraj Bhosale
 */

public class Missing{
	

	    private static double Missing_Value = 0.0;
	  
	   public static double doubleValue(Double number)
	   {
	       if(number == null)
	       {
	           
	           return Missing_Value;
	       }
	       else
	       {
	           return number;
	       }
	   }
	   public static double doubleValue(Double number, double missingValue)
	   {
	       if(number == null)	       {
	           return missingValue;
	       }
	       else
	       {
	           return number.doubleValue();
	       }
	   }
	  
	}