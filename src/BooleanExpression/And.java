package BooleanExpression;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class And implements BinaryBooleanOperator {

    public static final String TEXT="AND";
    public static final And INSTANCE=new And();

    public And() {
    }

    @Override
    public ArrayList<Integer> evaluate(BooleanExpression left, BooleanExpression right, InvertedIndex invertedIndex) {
        ArrayList<Integer> leftrtn=left.evaluate(invertedIndex);
        ArrayList<Integer> rightrtn=right.evaluate(invertedIndex);
        ArrayList<Integer> rtn=new ArrayList<>();

        int i=0;
        int j=0;

        while(i<leftrtn.size()&&j<rightrtn.size()){

        }
    }

    @Override
    public String toString() {
        return TEXT;
    }
}
