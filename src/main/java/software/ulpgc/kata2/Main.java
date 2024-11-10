package software.ulpgc.kata2;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\crazy\\Downloads\\title.basics.tsv");
        List<Title> titles = new TsvFileTitleReader(file).read();
        HashMap<Title.TitleType, Integer> histogram = new HashMap<>();
        for (Title title : titles) {
            histogram.put(title.getTitleType(), histogram.getOrDefault(title.getTitleType(),0) + 1);
        }
        for (Title.TitleType titleType : histogram.keySet()) {
            System.out.println(titleType + " " + histogram.get(titleType));
        }
    }
}
