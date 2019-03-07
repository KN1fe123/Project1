package testing;
/*
 * Author: Anirudh desiraju , Shubham Oberoi
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entity.Grade;




public class GradeTest {

@Test
public void testIllegalException() {
assertThrows( IllegalArgumentException.class, () -> { Grade grade =new Grade("",9.0); } );
}
@Test
public void gradeConstructor() {
Grade grade = new Grade("PA");
assertEquals(0.0, grade.getValaue().doubleValue());
}
@Test
public void compareC1() {
Grade grade1 = new Grade("H.W",10.0);
Grade grade2 = new Grade("H.W",null);
assertEquals(-1,grade2.compareTo(grade1));
}
}


