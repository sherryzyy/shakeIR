package BooleanExpression;

import java.util.HashSet;

public interface UnaryBooleanOperator {

    boolean evaluate(BooleanExpression booleanExpression, HashSet<String> dictionary);
}
