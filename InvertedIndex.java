import org.tartarus.snowball.SnowballStemmer;
import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by sherry on 2017/9/28.
 */
public class InvertedIndex {
    class Info {
        private int docfreq;//
        TreeMap<Integer, List> posIndex;//docID position
        TreeMap<Integer, Integer> wordfreq;//word in each files,<docID,freq>

        public Info() {
            posIndex = null;
            wordfreq = null;
        }

        public Info(int docfreq, TreeMap<Integer, List> posIndex, TreeMap<Integer, Integer> wordfreq) {
            this.docfreq = docfreq;
            this.posIndex = posIndex;
            this.wordfreq = wordfreq;
        }
    }

    HashMap<String, Integer> docIndex;
    HashMap<String, Info> InvertedIndex;


    public void getFileIndex() {
        File file = new File("src/Shakespeare");
        File[] filelist = file.listFiles();
        BufferedWriter bufw = null;
        try {
            bufw = new BufferedWriter(new FileWriter("docIndex.txt"));
            for (int i = 0; i < filelist.length; i++) {
                String docPath = filelist[i].getAbsolutePath();
                bufw.write(i + "\t" + docPath);
                bufw.newLine();
                bufw.flush();
            }
        } catch (IOException e) {
            System.out.println("打开文件失败");
            e.printStackTrace();
        } finally {
            if (bufw != null) {
                try {
                    bufw.close();
                } catch (IOException e) {
                    System.out.println("关闭文件失败");
                    e.printStackTrace();
                }
            }
        }

    }

    public void getWordFrequency() {
        BufferedReader bufr = null;
        BufferedReader bufrDoc = null;
        BufferedWriter bufw = null;

        try {
            bufr = new BufferedReader(new FileReader("docIndex.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            bufw = new BufferedWriter(new FileWriter("wordIndex.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String docIDandPath = null;

        try {
            while ((docIDandPath = bufr.readLine()) != null) {
                String[] docInfo = docIDandPath.split("\t");
                Integer docID = Integer.parseInt(docInfo[0]);
                String docPath=docInfo[1];
                bufrDoc=new BufferedReader(new FileReader(docPath));
                String wordLine=null;
                while((wordLine=bufrDoc.readLine())!=null){
                    String[] words=wordLine.split("\\W");
                    for(String wordOfDoc:words){
                        if(!wordOfDoc.equals("")){
                            getWordFrequencyHelp(wordOfDoc,docID);
                        }
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

private void getWordFrequencyHelp(String wordOfDoc,Integer docID){
    SnowballStemmer
 }
