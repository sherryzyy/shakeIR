package src.BooleanExpression;

import java.util.ArrayList;
import java.util.HashSet;

public class NestedBooleanExpression implements BooleanExpression {

   private BooleanExpression nestedBooleanExpression;


    @Override
    public ArrayList<Integer> evaluate(InvertedIndex invertedIndex) {
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
