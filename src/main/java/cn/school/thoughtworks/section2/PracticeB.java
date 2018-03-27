package cn.school.thoughtworks.section2;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class PracticeB {
    Map<String, Integer> countSameElements(List<String> collection1) {
        HashMap<String, Integer> map = new HashMap<>();
        collection1.stream().map(mapToEntry()).forEach(countThenPut(map));
        return map;
    }

    private Function<String, Map.Entry<String, Integer>> mapToEntry() {
        return x -> {
            int i = x.lastIndexOf('-');
            return new AbstractMap.SimpleEntry<String, Integer>(
                    x.substring(0,i!=-1?i:x.length()),
                    Integer.valueOf(i!=-1?x.substring(i+1):"1")
            );
        };
    }

    private Consumer<Map.Entry<String, Integer>> countThenPut(HashMap<String, Integer> map) {
        return x -> {
            String key = x.getKey();
            if (!map.containsKey(key)) {
                map.put(key,x.getValue());
            }else {
                map.put(key,map.get(key)+1);
            }
        };
    }
}
