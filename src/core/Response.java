package src.core;

import src.BooleanExpression.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by sherry on 2017/9/28.
 */
public class Response {

    private static InvertedIndex invertedIndex = new InvertedIndex();


    public ArrayList<webResult> getResponse(String query) throws IOException {

        ArrayList<webResult> rtn = new ArrayList<>();
        invertedIndex.getFileIndex();
        invertedIndex.getWordFrequency();
        QueryParser queryParser = new QueryParser();
        BooleanExpression booleanExpression = queryParser.parse(query);
        ArrayList<Integer> num = queryParser.match(invertedIndex);
        int len = 100;//read bytes
        for (Integer docID : num) {

            String url = invertedIndex.docIndex.get(docID);
            File file = new File(url);
            FileInputStream stream = new FileInputStream(file);
            byte[] b = new byte[len];
            stream.read(b);
            String title = file.getName();
            String content = new String(b);
            webResult tmp = new webResult(title, content, url);
            rtn.add(tmp);
        }
        return rtn;
    }


}
