package software.ulpgc.kata3.clean.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Barchart {
    private final String title;
    private final Map<String, Integer> counts;

    public Barchart(String title) {
        this.title = title;
        this.counts = new HashMap<>();
    }

    public String getTitle() {
        return title;
    }

    public void add(String key, Integer value){counts.put(key,value);}

    public Set<String > getCategory(){return counts.keySet();}


    public int getValue(String key) {return counts.getOrDefault(key,0);}

}
