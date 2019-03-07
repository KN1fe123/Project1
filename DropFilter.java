package entity;

import java.util.List;

import entity.SizeException;

/**
 * This class drops the lowest value or highest
 * value score from List<Grade>
 * 
 * @version 1.0
 * @author  Abhishek Chandak,Rishiraj Bhosale
 * @dateCreated 27th February 2019 
 *
 */

public class DropFilter implements Filter {
	
	//declare boolean decision variables to drop lowest/highest score
	boolean shouldDropLowest;
	boolean shouldDropHighest;
	DropFilter dropFilter;
	
	//default constructor must construct DropFilter obejct
	DropFilter() {
		dropFilter = new DropFilter(shouldDropLowest, shouldDropHighest);
	}
	
	public DropFilter(boolean shouldDropLowest, boolean shouldDropHighest) {
		this.shouldDropLowest = shouldDropLowest;
		this.shouldDropHighest = shouldDropHighest;
	}

	
	/**
	 * Drop grade if lowest/highest grade decision is to drop it,
	 * It is assumed that grades list is not null, if found null
	 * it throws SizeException
	 * 
	 * @param List<Grade> list containing grades
	 * @return  new list with dropped grade
	 * @throws SizeException
	 */
	@Override
	public List<Grade> apply(List<Grade> grades) throws SizeException {
		int numberOfGrades = grades.size();
		List<Grade> managedGrades;
		double minimumGrade = Double.MAX_VALUE;
		double maximumGrade = Double.MIN_VALUE;
		double gradeVal = 0.0;
		
		if (grades == null) 
			throw new SizeException("grades passed to DropFilter null");
		
		//if list contains fewer elements than that are to be dropped, throw SizeException
		if (numberOfGrades == 1)
			throw new SizeException("grades list contains fewer elements than that are to be dropped");
		
		//if list contains same number of elements that are to be dropped
		if ((shouldDropLowest == shouldDropHighest == true) && numberOfGrades == 2) 
			throw new SizeException("grades list contains same number of elements that are to be dropped");
		
		//if appropriate size of list then create alias of grades list
		managedGrades = grades;
		
		//calculate minimumGrade value
		if (shouldDropLowest == true) {
			for (Grade eachGrade : grades) {
				if ((gradeVal = eachGrade.getValaue()) < minimumGrade)
					minimumGrade = gradeVal;
			}
		}
		
		//calculate maximumGrade value
		if (shouldDropHighest == true) {
			for (Grade eachGrade : grades) {
				if ((gradeVal = eachGrade.getValaue()) > maximumGrade)
					maximumGrade = gradeVal;
			}
		}
		
		//drop the minimum and maximum grade values
		/*
		 * for (Grade eachGrade : grades) { if ((eachGrade.getValaue() == minimumGrade)
		 * || (eachGrade.getValaue() == maximumGrade)) managedGrades.remove(eachGrade);
		 * }
		 */
		
		//return the new alias list
		return managedGrades;
	}
	
}
