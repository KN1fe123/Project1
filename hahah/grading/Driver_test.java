package grading;
//Make changes in the number of inputs as per instructor
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Driver_test {

       public static void main(String[] args) throws SizeException {
           Grade first = new Grade("atttt", 20.0);
           Grade second = new Grade("abbcc", 18.00);  
           Grade third = new Grade("aaaaa",15.0);
           Grade fourth = new Grade("abbbb", 20.00);
           Grade fifth = new Grade("fifthGrade", 20.0);
           Grade sixth = new Grade("sixthGrade", 20.0);
           Grade seventh = new Grade("seventhGrade", 5.0);
      
           System.out.println(second.compareTo(first));
          
           //Test weighted total strat
           Map<String, Double> weightSet = new HashMap<String,Double>();
           weightSet.put("11111", 1.0);
           weightSet.put("22222", 1.5);
           weightSet.put("33333", 1.0);
           weightSet.put("44444", -0.1);
           weightSet.put("55555", 0.0);
           WeightedTotalStrategy wts = new WeightedTotalStrategy(weightSet);
          
           ArrayList<Grade> gradeList = new ArrayList<Grade>();
           gradeList.add(first);
           gradeList.add(second);
           gradeList.add(third);
           gradeList.add(fourth);
           gradeList.add(fifth);
           gradeList.add(sixth);
           gradeList.add(seventh);
          
           Grade total = new Grade("");
           total = wts.calculate("aaaaa", gradeList);
           System.out.println(total.toString());
          
           //Drop filter
           DropFilter filter = new DropFilter(true,false);
           gradeList = filter.apply(gradeList);
           System.out.println(gradeList.toString());
          
       }
  
}