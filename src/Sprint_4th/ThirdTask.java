package Sprint_4th;
import java.util.*;

public class ThirdTask {
}


class MyUtila {
    // Code
    public boolean listMapCompare(List<String> list, Map<String, String> map) {
        Set<String> listSet = new HashSet<>(list);
        Set<String> mapSet = new HashSet<>(map.values());

        return listSet.containsAll(mapSet);
    }
}
