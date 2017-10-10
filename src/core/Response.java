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

    /**
     * Response the web query, process the raw query, build inverted index, query
     * @param rawquery
     * @return a list of webResult to web page
     * @throws IOException
     */
    public ArrayList<webResult> getResponse(String rawquery) throws IOException {

        /*preprocess query*/
        ArrayList<String> querylist = InvertedIndex.preprocess(rawquery.split("\\s+"));
        String query = String.join(" ", (String[]) querylist.toArray(new String[0]));

        /*only excute once*/
        if (invertedIndex == null) {
            invertedIndex=new InvertedIndex();
            invertedIndex.getFileIndex();
            invertedIndex.getWordFrequency();
        }

    /*query*/
        QueryParser queryParser = new QueryParser();
        BooleanExpression booleanExpression = queryParser.parse(query);
        ArrayList<Integer> num = queryParser.match(invertedIndex);

        /*no result*/
        if (num.contains(-1)) {
            return null;
        }
        int len = 1000;//read bytes
        ArrayList<webResult> rtn = new ArrayList<>();
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
