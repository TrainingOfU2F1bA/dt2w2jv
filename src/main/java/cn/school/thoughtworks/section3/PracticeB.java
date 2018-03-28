package cn.school.thoughtworks.section3;

import java.util.List;
import java.util.Map;

public class PracticeB {
    Map<String,Integer> createUpdatedCollection(Map<String, Integer> collectionA, Map<String, List<String>> object) {
        object.values().stream().flatMap(x -> x.stream()).forEach(x -> {
                collectionA.computeIfPresent(x,(k,v)->v<3?v:v-v/3);
        });
        return collectionA;
    }
}
