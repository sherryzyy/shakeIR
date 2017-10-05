import BooleanExpression.BooleanExpression;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sherry on 2017/9/28.
 */
public class Main {
    private static BooleanExpression.InvertedIndex invertedIndex=new BooleanExpression.InvertedIndex();



    public static void main(String[] args) throws IOException {



        invertedIndex.getFileIndex();
        invertedIndex.getWordFrequency();

        QueryParser queryParser=new QueryParser();
        Scanner sc=new Scanner(System.in);
        String query=sc.nextLine();
        BooleanExpression booleanExpression=queryParser.parse(query);

        List<Integer> matchedDocumentIndices=new ArrayList<>();




    }
}
