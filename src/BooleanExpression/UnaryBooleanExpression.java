package BooleanExpression;

import java.util.HashSet;

public class UnaryBooleanExpression implements BooleanExpression {

    private UnaryBooleanOperator unaryBooleanOperator;
    private BooleanExpression booleanExpression;

    @Override
    public boolean evaluate(HashSet<String> dictionary) {
        return unaryBooleanOperator.evaluate(booleanExpression, dictionary);
    }

    public UnaryBooleanOperator getUnaryBooleanOperator() {
        return unaryBooleanOperator;
    }

    public void setUnaryBooleanOperator(UnaryBooleanOperator unaryBooleanOperator) {
        this.unaryBooleanOperator = unaryBooleanOperator;
    }

    public BooleanExpression getBooleanExpression() {
        return booleanExpression;
    }

    public void setBooleanExpression(BooleanExpression booleanExpression) {
        this.booleanExpression = booleanExpression;
    }

    @Override
    public String toString() {
        return unaryBooleanOperator.toString() + booleanExpression.toString();

    }
}
