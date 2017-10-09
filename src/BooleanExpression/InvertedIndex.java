package BooleanExpression;//import org.tartarus.snowball.SnowballStemmer;

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

        ArrayList<Integer> posting;
        TreeMap<Integer, Integer> posIndex;//docID+word position(last appearance)
        TreeMap<Integer, Integer> wordfreq;//word in each files,<docID,freq>


        public Info() {
            posting=new ArrayList<>();
            posIndex = new TreeMap<>();
            wordfreq = new TreeMap<>();
        }

        public Info(int docfreq, TreeMap<Integer,Integer> posIndex, TreeMap<Integer, Integer> wordfreq) {
            this.docfreq = docfreq;
            this.posIndex = posIndex;
            this.wordfreq = wordfreq;
        }

    }

    public HashMap<Integer,String> docIndex;
    public TreeMap<String, Info> InvertedIndex;

    public InvertedIndex() {
        this.docIndex = new HashMap<>();
        InvertedIndex = new TreeMap<>();
    }

    public InvertedIndex(HashMap<Integer,String> docIndex, TreeMap<String, Info> invertedIndex) {
        this.docIndex = docIndex;
        InvertedIndex = invertedIndex;
    }

    public void getFileIndex() {
        File file = new File(getClass().getClassLoader().getResource("Shakespeare").getFile());
        File[] filelist = file.listFiles();
        BufferedWriter bufw = null;
        try {
            bufw = new BufferedWriter(new FileWriter("docIndex.txt"));
            for (int i = 0; i < filelist.length; i++) {
                String docPath = filelist[i].getAbsolutePath();
                bufw.write(i + "\t" + docPath);
                bufw.newLine();
                bufw.flush();
                docIndex.put(i,docPath);
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
            Integer ByteRecord=0;
            while ((wordLine = bufrDoc.readLine()) != null) {
                ByteRecord+=wordLine.getBytes().length;
                String[] words = wordLine.split("\\W");
                for (String wordOfDoc : words) {
                    if (!wordOfDoc.equals("")) {
                        getWordFrequencyHelp(wordOfDoc, docID,ByteRecord);
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
                writeinfo = key + "\t" + value.docfreq;
                Set entry = value.wordfreq.entrySet();
                Iterator iterator1 = entry.iterator();
                while (iterator1.hasNext()) {
                    Map.Entry fre = (Map.Entry) iterator1.next();
                    writeinfo+="\t"+fre.getKey();
                    value.posting.add(Integer.parseInt(fre.getKey().toString()));
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


    private void getWordFrequencyHelp(String wordOfDoc, Integer docID,Integer ByteRecord) {
        wordOfDoc = wordOfDoc.toLowerCase();
        if (!InvertedIndex.containsKey(wordOfDoc)) {//first apperence in counting
            Info tmp = new Info();
            tmp.wordfreq.put(docID, 1);
            tmp.docfreq+=1;
            tmp.totalfreq+=1;
            tmp.posIndex.put(docID,ByteRecord);
            InvertedIndex.put(wordOfDoc, tmp);

        } else {
            Info tmp = InvertedIndex.get(wordOfDoc);
            Integer count = tmp.wordfreq.get(docID);
            if(count==null){//first apperence in this docID
                count=1;
                tmp.docfreq+=1;
            }else{
                count++;
            }
            tmp.wordfreq.put(docID, count);
            tmp.totalfreq+=1;
            tmp.posIndex.put(docID,ByteRecord);
            InvertedIndex.put(wordOfDoc, tmp);
        }
    }
}
