package BooleanExpression;

import java.util.ArrayList;
import java.util.HashSet;

public class Term implements BooleanExpression {

    private String term;

    public Term(String term) {
        this.term = term;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public ArrayList<Integer> evaluate(InvertedIndex invertedIndex) {
        ArrayList<Integer> rtn = new ArrayList<>();
        if (invertedIndex.InvertedIndex.get(term) == null) {
            rtn.add(-1);
        } else {
            rtn = invertedIndex.InvertedIndex.get(term).posting;
        }

        return rtn;
    }

    @Override
    public String toString() {
        return this.term;
    }
}
