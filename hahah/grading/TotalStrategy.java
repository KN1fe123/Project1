
package grading;
import java.util.LinkedList;

public class TotalStrategy extends WeightedTotalStrategy{
   public Grade calculate(String givenKey, LinkedList<Grade> grading) throws SizeException {
       @SuppressWarnings("unused")
       double localWeight = 0.0;
       double average = 0.0;
      
       //Security Check
       if (weight.equals(null)) {
           throw new SizeException("Map of weights given is null");
       } else if(weight.isEmpty()) {
           throw new SizeException("map of wieghts is empty. Size = 0");
       }else {
           for(int i=0 ;i < grading.size(); i++) {
               //if user's key exist in weight map, use key's weight accordingly.
               if (weight.containsKey(grading.get(i).getKey())) {
                   localWeight = weight.get(grading.get(i).getKey());
                   if (localWeight < 0.0)
                   {
                       localWeight = 0;
                   }
               }
               //No weight = assume 1.0// assumes Null is accounted
               else {      
                   localWeight = 1.0;
                   //find a way to use missing class to obtain Missing value
                  
               }
               //Begin Calculating Total(Grade Value * weight)
               if (grading.get(i).getValue() == 0.0) {
                   average += Missing.doubleValue(grading.get(i).getValue());
               } else {
                   average += grading.get(i).getValue() * localWeight;
               }
              
           }
           Grade gradedTotal = new Grade(givenKey,average);
           return gradedTotal;
       }      
   }
}