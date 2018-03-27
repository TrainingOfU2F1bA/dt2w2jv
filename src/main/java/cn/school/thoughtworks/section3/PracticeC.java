package cn.school.thoughtworks.section3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracticeC {
    Map<String, Integer> createUpdatedCollection(List<String> collectionA, Map<String, List<String>> object) {
        //实现练习要求，并改写该行代码。
        Map<String, Integer> collection3 = countSameElements(collectionA);
        return createUpdatedCollection(collection3,object);
    }

    Map<String, Integer> countSameElements(List<String> collection1) {
        HashMap<String, Integer> map = new HashMap<>();
        collection1.stream().forEach(x -> {
            if (!map.containsKey(x)) map.put(x, 1);
            else map.put(x, map.get(x) + 1);
        });
        return map;
    }

    Map<String, Integer> createUpdatedCollection(Map<String, Integer> collectionA, Map<String, List<String>> object) {
        object.values().stream().flatMap(x -> x.stream()).forEach(x -> {
            if (collectionA.containsKey(x)) {
                Integer integer = collectionA.get(x);
                collectionA.put(x, integer < 3 ? integer : integer - integer / 3);
            }
        });
        return collectionA;
    }
}
