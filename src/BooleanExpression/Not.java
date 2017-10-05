package BooleanExpression;

import java.util.HashSet;

public class Not implements UnaryBooleanOperator {
    public static final String TEXT="NOT";
    public static final Not INSTANCE=new Not();

    public Not() {
    }

    @Override
    public boolean evaluate(BooleanExpression booleanExpression, HashSet<String> dictionary) {
       return !booleanExpression.evaluate(dictionary);
    }

    @Override
    public String toString() {
        return TEXT;
    }
}
