package entity;

import java.util.List;

/*
	Author: Swapnali Shrikhande
	Date Created: 27th February 2019
*/

public interface Filter {
	List<Grade> apply (List<Grade> grades) throws SizeException;
}
