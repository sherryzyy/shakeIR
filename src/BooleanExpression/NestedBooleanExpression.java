package BooleanExpression;

import java.util.HashSet;

public class NestedBooleanExpression implements BooleanExpression {

   private BooleanExpression nestedBooleanExpression;


    @Override
    public boolean evaluate(HashSet<String> dictionary) {
        return nestedBooleanExpression.evaluate(dictionary);
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
