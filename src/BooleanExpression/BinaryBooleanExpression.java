package BooleanExpression;

import java.util.HashSet;

public class BinaryBooleanExpression implements BooleanExpression {

    private BooleanExpression left;
    private BooleanExpression right;
    private BinaryBooleanOperator binaryBooleanOperator;

    @Override
    public boolean evaluate(InvertedIndex invertedIndex) {
        return binaryBooleanOperator.evaluate(left, right, invertedIndex);
    }

    public BooleanExpression getLeft() {
        return left;
    }

    public void setLeft(BooleanExpression left) {
        this.left = left;
    }

    public BooleanExpression getRight() {
        return right;
    }

    public void setRight(BooleanExpression right) {
        this.right = right;
    }

    public BinaryBooleanOperator getBinaryBooleanOperator() {
        return binaryBooleanOperator;
    }

    public void setBinaryBooleanOperator(BinaryBooleanOperator binaryBooleanOperator) {
        this.binaryBooleanOperator = binaryBooleanOperator;
    }

    @Override
    public String toString() {
        return
                left.toString() + binaryBooleanOperator.toString() + right.toString();
    }
}
