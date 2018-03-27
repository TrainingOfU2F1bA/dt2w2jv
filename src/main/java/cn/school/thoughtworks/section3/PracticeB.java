package cn.school.thoughtworks.section3;

import java.util.List;
import java.util.Map;

public class PracticeB {
    Map<String,Integer> createUpdatedCollection(Map<String, Integer> collectionA, Map<String, List<String>> object) {
        object.values().stream().flatMap(x -> x.stream()).forEach(x -> {
            if (collectionA.containsKey(x)) {
                Integer integer = collectionA.get(x);
                collectionA.put(x, integer<3?integer:integer-integer/3);
            }
        });
        return collectionA;
    }
}
