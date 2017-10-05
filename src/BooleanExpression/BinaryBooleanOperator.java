package BooleanExpression;

import java.util.HashSet;

public interface BinaryBooleanOperator {

    boolean evaluate (BooleanExpression left, BooleanExpression right, HashSet<String> dictionary);
}
