package cn.school.thoughtworks.section3;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class PracticeD {
    Map<String,Integer> createUpdatedCollection(List<String> collectionA, Map<String,List<String>> object) {
        //实现练习要求，并改写该行代码。
        Map<String, Integer> collection3 = countSameElements(collectionA);
        return createUpdatedCollection(collection3,object);
    }

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
                map.put(key,map.get(key)+x.getValue());
            }
        };
    }

    Map<String,Integer> createUpdatedCollection(Map<String, Integer> collectionA, Map<String, List<String>> object) {
        object.values().stream().flatMap(x -> x.stream()).forEach(x -> {
                collectionA.computeIfPresent(x,(k,v)->v<3?v:v-v/3);
        });
        return collectionA;
    }
}
