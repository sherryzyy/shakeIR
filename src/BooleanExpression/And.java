package BooleanExpression;

import java.util.HashSet;

public class And implements BinaryBooleanOperator {

    public static final String TEXT="AND";
    public static final And INSTANCE=new And();

    public And() {
    }

    @Override
    public boolean evaluate(BooleanExpression left, BooleanExpression right, HashSet<String> dictionary) {
        return left.evaluate(dictionary)&&right.evaluate(dictionary);
    }

    @Override
    public String toString() {
        return TEXT;
    }
}
