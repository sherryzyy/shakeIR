package BooleanExpression;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;

public class Not implements UnaryBooleanOperator {
    public static final String TEXT="NOT";
    public static final Not INSTANCE=new Not();

    public Not() {
    }

    @Override
    public ArrayList<Integer> evaluate(BooleanExpression booleanExpression, InvertedIndex invertedIndex) {

        ArrayList<Integer> posting=booleanExpression.evaluate(invertedIndex);
        ArrayList<Integer> rtn=new ArrayList<>();
        int flag=invertedIndex.docIndex.size();

        for(int i=0;i<flag;i++){
            if(posting.contains(i)){continue;}
            else{
                rtn.add(i);
            }
        }
       return rtn;
    }

    @Override
    public String toString() {
        return TEXT;
    }
}
