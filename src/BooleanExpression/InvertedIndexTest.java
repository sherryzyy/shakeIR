package BooleanExpression;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class InvertedIndexTest {
    @org.junit.Test
    public void getFileIndex() throws Exception {
        String rawquery="laughed and caesar";
        ArrayList<String> querylist=InvertedIndex.preprocess(rawquery.split("\\s+"));
        String query=String.join(" ",querylist.toArray());
    }

}