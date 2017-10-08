package src.core;

import src.BooleanExpression.*;

import java.io.IOException;
import java.util.List;


/**
 * Created by sherry on 2017/9/28.
 */
public class Response {

    private static InvertedIndex invertedIndex=new InvertedIndex();



    public List<Integer> getResponse(String query) throws IOException {

        invertedIndex.getFileIndex();
        invertedIndex.getWordFrequency();
        QueryParser queryParser=new QueryParser();
        BooleanExpression booleanExpression=queryParser.parse(query);
       return queryParser.match(invertedIndex);

    }



}
