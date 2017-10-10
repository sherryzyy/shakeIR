package core;

import BooleanExpression.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by sherry on 2017/9/28.
 */
public class Response {

    private static InvertedIndex invertedIndex;


    public ArrayList<webResult> getResponse(String rawquery) throws IOException {

        /*preprocess query*/
        ArrayList<String> querylist = InvertedIndex.preprocess(rawquery.split("\\s+"));
        String query = String.join(" ", (String[]) querylist.toArray(new String[0]));

        if (invertedIndex == null) {
            invertedIndex=new InvertedIndex();
            invertedIndex.getFileIndex();
            invertedIndex.getWordFrequency();
        }
        ArrayList<webResult> rtn = new ArrayList<>();

        QueryParser queryParser = new QueryParser();
        BooleanExpression booleanExpression = queryParser.parse(query);
        ArrayList<Integer> num = queryParser.match(invertedIndex);
        /*no result*/
        if (num.contains(-1)) {
            return null;
        }
        int len = 1000;//read bytes
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
