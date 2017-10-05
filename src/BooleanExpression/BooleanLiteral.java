package BooleanExpression;

import java.util.HashSet;

public class BooleanLiteral implements BooleanExpression {

    public static final BooleanLiteral TRUE=new BooleanLiteral(true);
    public static final BooleanLiteral FALSE=new BooleanLiteral(false);

    private boolean value;

    public BooleanLiteral(boolean value) {
        this.value = value;
    }

    @Override
    public boolean evaluate(InvertedIndex invertedIndex) {
        return this.value;
    }

    @Override
    public String toString() {
        return Boolean.toString(value);
    }
}
