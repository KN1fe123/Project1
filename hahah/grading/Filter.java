package grading;

import java.util.ArrayList;
import java.util.List;




public interface Filter {
   public List<Grade> apply(List<Grade> grading) throws SizeException;
}


