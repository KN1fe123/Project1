package testing;

import static org.junit.jupiter.api.Assertions.*;
import entity.Missing;
import org.junit.jupiter.api.Test;
/*
 * Author: Anirudh desiraju , Shubham Oberoi
 */
class MissingTest {

	@Test
	void test() {
		Missing obj1 = new Missing();
		double d1 = obj1.doubleValue(5.0);
		double d2 = obj1.doubleValue(10.0,2);
		double d3 = obj1.doubleValue(null,2);
		double d4 = obj1.doubleValue(null);
		
		
		System.out.println("d1 : " + d1);
		System.out.println("d2 : " + d2);
		System.out.println("d3 : " + d3);
		System.out.println("d4 : " + d4);
	}

}
