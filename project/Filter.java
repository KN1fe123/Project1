package entity;

import java.util.List;

/*
	Author: Rishiraj Bhosale
	Date Created: 27th February 2019
*/

public interface Filter {
	List<Grade> apply (List<Grade> grades) throws SizeException;
}
