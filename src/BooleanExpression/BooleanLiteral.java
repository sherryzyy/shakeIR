package BooleanExpression;

import java.util.ArrayList;
import java.util.HashSet;

public class BooleanLiteral implements BooleanExpression {

    public static final BooleanLiteral TRUE=new BooleanLiteral(true);
    public static final BooleanLiteral FALSE=new BooleanLiteral(false);

    private boolean value;

    public BooleanLiteral(boolean value) {
        this.value = value;
    }

    @Override
    public ArrayList<Integer> evaluate(InvertedIndex invertedIndex) {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return Boolean.toString(value);
    }
}
