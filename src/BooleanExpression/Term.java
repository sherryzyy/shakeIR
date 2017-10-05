package BooleanExpression;

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
    public boolean evaluate(HashSet<String> dictionary) {
        return dictionary.contains(this.term);
    }

    @Override
    public String toString() {
        return this.term;
    }
}
