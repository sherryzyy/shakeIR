package BooleanExpression;

import java.util.ArrayList;
import java.util.HashSet;

public class Or implements BinaryBooleanOperator {
    public static final String TEXT = "OR";
    public static final Or INSTANCE = new Or();

    public Or() {
    }

    @Override
    public ArrayList<Integer> evaluate(BooleanExpression left, BooleanExpression right, InvertedIndex invertedIndex) {
        ArrayList<Integer> leftrtn = left.evaluate(invertedIndex);
        ArrayList<Integer> rightrtn = right.evaluate(invertedIndex);
        ArrayList<Integer> rtn = new ArrayList<>();
    /*have nonexistent word*/
        if (leftrtn.contains(-1)) {
            return rightrtn;
        } else if (rightrtn.contains(-1)) {
            return leftrtn;
        } else if (leftrtn.contains(-1) && rightrtn.contains(-1)) {
            rtn.add(-1);
            return rtn;
        } else {
            int i = 0;
            int j = 0;

            while (i < leftrtn.size() && j < rightrtn.size()) {
                if (leftrtn.get(i) == rightrtn.get(j)) {
                    rtn.add(leftrtn.get(i));
                    i++;
                    j++;
                } else if (leftrtn.get(i) < rightrtn.get(j)) {
                    rtn.add(leftrtn.get(i));
                    i++;
                } else {
                    rtn.add(rightrtn.get(j));
                    j++;
                }
            }
            if (i < leftrtn.size()) {
                for (; i < leftrtn.size(); i++) {
                    rtn.add(leftrtn.get(i));
                }
            }
            if (j < rightrtn.size()) {
                for (; j < rightrtn.size(); j++) {
                    rtn.add(rightrtn.get(j));
                }
            }
            return rtn;
        }
    }

    @Override
    public String toString() {
        return TEXT;
    }
}
