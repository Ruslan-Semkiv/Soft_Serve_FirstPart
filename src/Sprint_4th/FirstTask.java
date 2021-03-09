package Sprint_4th;

import java.util.*;

public class FirstTask {
    //  key      value
    //  number   name
    public static Map<String, List<String>> createNotebook(Map<String, String> phones) {
        Map<String, List<String>> myMaps = new HashMap<>();
        for (Map.Entry <String,String> item : phones.entrySet()) {
            if(!myMaps.containsKey(item.getValue())){
                myMaps.put(item.getValue(), new ArrayList<>());
            }
            myMaps.get(item.getValue()).add(item.getKey());
        }
        return myMaps;
    }
}

