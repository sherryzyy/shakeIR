//import org.tartarus.snowball.SnowballStemmer;

import java.awt.*;
import java.awt.List;
import java.io.*;
import java.util.*;

/**
 * Created by sherry on 2017/9/28.
 */
public class InvertedIndex {
    class Info {
        private int docfreq;//how many doc has this word
        private int totalfreq;//word total frequency in all files
        TreeMap<Integer, List> posIndex;//docID+word position
        TreeMap<Integer, Integer> wordfreq;//word in each files,<docID,freq>


        public Info() {
            posIndex = new TreeMap<>();
            wordfreq = new TreeMap<>();
        }

        public Info(int docfreq, TreeMap<Integer, List> posIndex, TreeMap<Integer, Integer> wordfreq) {
            this.docfreq = docfreq;
            this.posIndex = posIndex;
            this.wordfreq = wordfreq;
        }

    }

    HashMap<String, Integer> docIndex;
    TreeMap<String, Info> InvertedIndex;

    public InvertedIndex() {
        this.docIndex = new HashMap<>();
        InvertedIndex = new TreeMap<>();
    }

    public InvertedIndex(HashMap<String, Integer> docIndex, TreeMap<String, Info> invertedIndex) {
        this.docIndex = docIndex;
        InvertedIndex = invertedIndex;
    }

    public void getFileIndex() {
        File file = new File("Shakespeare");
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

    public void getWordFrequency() throws IOException {
        BufferedReader bufr = new BufferedReader(new FileReader("docIndex.txt"));
        BufferedWriter bufw = new BufferedWriter(new FileWriter("wordIndex.txt"));
        BufferedReader bufrDoc = null;
        String docIDandPath = null;

        while ((docIDandPath = bufr.readLine()) != null) {
            String[] docInfo = docIDandPath.split("\t");
            Integer docID = Integer.parseInt(docInfo[0]);
            String docPath = docInfo[1];
            bufrDoc = new BufferedReader(new FileReader(docPath));
            String wordLine = null;
            while ((wordLine = bufrDoc.readLine()) != null) {
                String[] words = wordLine.split("\\W");
                for (String wordOfDoc : words) {
                    if (!wordOfDoc.equals("")) {
                        getWordFrequencyHelp(wordOfDoc, docID);
                    }
                }
            }
        }
        //write result in wordIndex.txt
        String writeinfo = null;
        Set keys = InvertedIndex.keySet();
        if (keys != null) {
            Iterator iterator = keys.iterator();
            while (iterator.hasNext()) {
                Object key = iterator.next();

                Info value = (Info) InvertedIndex.get(key);
                writeinfo = key + "\t" + value.totalfreq;
                Set entry = value.wordfreq.entrySet();
                Iterator iterator1 = entry.iterator();
                while (iterator1.hasNext()) {
                    Map.Entry fre = (Map.Entry) iterator1.next();
                    writeinfo+="\t"+fre.getKey();
                }

                bufw.write(writeinfo);
                bufw.newLine();
                bufw.flush();
            }
        }
        bufw.close();
        bufr.close();
        bufrDoc.close();
    }


    private void getWordFrequencyHelp(String wordOfDoc, Integer docID) {
        wordOfDoc = wordOfDoc.toLowerCase();
        if (!InvertedIndex.containsKey(wordOfDoc)) {//first apperence in counting
            Info tmp = new Info();
            tmp.wordfreq.put(docID, 1);
            tmp.totalfreq+=1;
            InvertedIndex.put(wordOfDoc, tmp);
        } else {
            Info tmp = InvertedIndex.get(wordOfDoc);
            Integer count = tmp.wordfreq.get(docID);
            count = ((count == null) ? 1 : count++);//first apperence in this docID
            tmp.wordfreq.put(docID, count);
            tmp.totalfreq+=1;
            InvertedIndex.put(wordOfDoc, tmp);
        }
    }
}
