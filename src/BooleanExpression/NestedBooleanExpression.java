package BooleanExpression;

import java.util.HashSet;

public class NestedBooleanExpression implements BooleanExpression {

   private BooleanExpression nestedBooleanExpression;


    @Override
    public boolean evaluate(InvertedIndex invertedIndex) {
        return nestedBooleanExpression.evaluate(invertedIndex);
    }

    public BooleanExpression getNestedBooleanExpression() {
        return nestedBooleanExpression;
    }

    public void setNestedBooleanExpression(BooleanExpression nestedBooleanExpression) {
        this.nestedBooleanExpression = nestedBooleanExpression;
    }

    @Override
    public String toString() {
        return "("+nestedBooleanExpression.toString()+")";
    }
}
