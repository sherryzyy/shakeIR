package BooleanExpression;

import java.util.ArrayList;
import java.util.HashSet;

public interface BinaryBooleanOperator {

    ArrayList<Integer> evaluate (BooleanExpression left, BooleanExpression right, InvertedIndex invertedIndex);
}
