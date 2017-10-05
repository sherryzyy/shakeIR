package BooleanExpression;

import java.util.ArrayList;
import java.util.HashSet;

public interface UnaryBooleanOperator {

    ArrayList<Integer> evaluate(BooleanExpression booleanExpression, InvertedIndex invertedIndex);
}
