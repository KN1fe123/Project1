package entity;

import java.util.List;
import java.util.Map;

/*
 * Calculates midterm grades
 * @author Abhishek Chandak,Rishiraj Bhosale
 * @datecreated 3rd March 2019
 * */
public class WeightedTotalStrategy extends TotalStrategy implements GradingStrategy   {
	List<Grade> managedGrade;
	Map<String, Double> courseWeights;
	Double weight;
	Double weightedTotal;
	
	WeightedTotalStrategy() {
		//initialize courseWeights map to null
		courseWeights = null;
		weight = 0.0;
		weightedTotal = 0.0;
	}
	
	
	public WeightedTotalStrategy(Map<String, Double> weights) {
		courseWeights = weights;
	}
	
	/*
	 * calculates grades total of list of Grade objects passed
	 * @referenceDoc Glossary_Gradient.pdf
	 * @weightedtotal = summation ()
	 * @param key = course grade, PAs, HWs
	 * @return Grade = key (course grade, PAs, HWs), corresponding WEIGHTED total grade
	 * throws SizeException
	 * */
	public Grade calculate(String key, List<Grade> grade) throws SizeException {
		managedGrade = grade;
		
		//handle grade cases
		if (grade == null || grade.size() == 0) throw new SizeException("WeightedTotalStrategy passed null grade object");
		
		//if courseWeights is null
		if (courseWeights == null) {
			weight = 0.0;
		} if (!courseWeights.containsKey(key)) {
			weight = 0.0;
		} else {
			//retrieve weight from mentioned key, along with missing checks of null
			weight = Missing.doubleValue(courseWeights.get(key));
			
			if (weight < 0.0) weight = 0.0;
		}
		
		//calculate weighted total
		//formula: summation (weights*grades)
		for (int i = 0; i < grade.size(); i++) {
			weightedTotal += weight * Missing.doubleValue(grade.get(i).getValaue());
		}
		
		//return the weightedTotal grade
		return new Grade(key, weightedTotal);
	}
}
