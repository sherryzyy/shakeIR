package src.BooleanExpression;

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
        return invertedIndex.InvertedIndex.get(term).posting;
    }

    @Override
    public String toString() {
        return this.term;
    }
}
