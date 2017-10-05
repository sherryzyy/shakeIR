package BooleanExpression;

import java.util.HashSet;

public class Or implements BinaryBooleanOperator {
    public static final String TEXT="OR";
    public static final Or INSTANCE=new Or();

    public Or() {
    }

    @Override
    public boolean evaluate(BooleanExpression left, BooleanExpression right,InvertedIndex invertedIndex) {
        return left.evaluate(invertedIndex)||right.evaluate(invertedIndex);
    }

    @Override
    public String toString() {
        return TEXT;
    }
}
