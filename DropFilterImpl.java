package entity;

import java.util.Collections;
import java.util.List;

import entity.SizeException;


public class DropFilterImpl implements Filter {
	
	boolean shouldDropLowest;
	boolean shouldDropHighest;
	DropFilter dropFilter;
	
	public DropFilterImpl() {
		dropFilter = new DropFilter(shouldDropLowest, shouldDropHighest);
	}
	
	public DropFilterImpl(boolean shouldDropLowest, boolean shouldDropHighest) {
		this.shouldDropLowest = shouldDropLowest;
		this.shouldDropHighest = shouldDropHighest;
	}

	
	@Override
	public List<Grade> apply(List<Grade> grades) throws SizeException {
		int numberOfGrades = grades.size();
		List<Grade> managedGrades;
		Grade minimumGrade;
		Grade maximumGrade;
		double gradeVal = 0.0;
		
		if (grades.equals(null) || grades.isEmpty()) 
			throw new SizeException("grades passed to DropFilter null");
		
		if (numberOfGrades == 1)
			throw new SizeException("grades list contains fewer elements than that are to be dropped");
		
		if ((shouldDropLowest == shouldDropHighest == true) && numberOfGrades == 2) 
			throw new SizeException("grades list contains same number of elements that are to be dropped");
		
		managedGrades = grades;
		
		if (shouldDropLowest == true) {
			minimumGrade = Collections.min(grades);
			managedGrades.remove(minimumGrade);
		}
		
		if (shouldDropHighest == true) {
			maximumGrade = Collections.max(grades);
			managedGrades.remove(maximumGrade);
		}
		return managedGrades;
	}
	
}
