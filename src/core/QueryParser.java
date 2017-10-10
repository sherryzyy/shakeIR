package core;

import BooleanExpression.*;
import antlr4Generated.QueryLanguageLexer;
import antlr4Generated.QueryLanguageParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import core.QueryListener;

import java.util.ArrayList;
import java.util.List;



public class QueryParser {
    private BooleanExpression booleanExpression;

    /**
     * parse query using antlr4
     * @param query
     * @return booleanExpression
     */
    public BooleanExpression parse(String query){
        QueryLanguageLexer lexer=new QueryLanguageLexer(new ANTLRInputStream(query.toLowerCase()));
        QueryLanguageParser parser=new QueryLanguageParser(new CommonTokenStream(lexer));
        QueryListener queryListener=new QueryListener();
        parser.addParseListener(queryListener);
        parser.parse();
        booleanExpression=queryListener.getOperand();
        System.out.println("PARSED QUERY: " + booleanExpression + "\n");
        return booleanExpression;
    }

    /**
     * bool query
     * @param invertedIndex
     * @return the list of result docID
     */
    public ArrayList<Integer> match(InvertedIndex invertedIndex){
        if(invertedIndex !=null&&invertedIndex.InvertedIndex.size()>0){
            return booleanExpression.evaluate(invertedIndex);
        }
       return null;
    }
}
