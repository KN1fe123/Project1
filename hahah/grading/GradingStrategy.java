package grading;

import java.util.*;
public interface GradingStrategy {
   public Grade calculate(String key, List<Grade> grading) throws SizeException;
}