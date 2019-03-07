package testing;
/*
 * Author: Anirudh desiraju , Shubham Oberoi
 */


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import entity.DropFilter;
import entity.DropFilterImpl;
import entity.Grade;
import entity.SizeException;

class DropFilterTest {
@Test
public void testSizeExceptionNull() {
List<Grade> grades = new ArrayList<Grade>();
DropFilterImpl dropFilterImpl = new DropFilterImpl();
assertThrows( SizeException.class, () -> { dropFilterImpl.apply(grades); } );
}
@Test
public void testSizeExceptionOne() {
DropFilterImpl dropFilterImpl = new DropFilterImpl();
Grade grade1 = new Grade("H.W", 10.0);
List<Grade> grades = new ArrayList<Grade>();
grades.add(grade1);
assertThrows( SizeException.class, () -> { dropFilterImpl.apply(grades); } );
}
//It returns correct value with dropFilterImpl
@Test
public void testEliminateLowest() throws SizeException {
DropFilterImpl dropFilterImpl = new DropFilterImpl(true,false);
List<Grade> grades;
grades = new ArrayList<Grade>();
Grade grade;
double[] arr = new double[] {10.0,2.0,3.0,6.0,8.0,9.0};
for (int i=0; i<6; i++)
{
grade = new Grade("PA"+i, arr[i]);
grades.add(grade);
}
assertEquals("[PA0:  10.0, PA2:   3.0, PA3:   6.0, PA4:   8.0, PA5:   9.0]", dropFilterImpl.apply(grades).toString());
}
}


