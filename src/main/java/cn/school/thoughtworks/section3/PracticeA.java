package cn.school.thoughtworks.section3;

import java.util.List;
import java.util.Map;

public class PracticeA {
    Map<String, Integer> createUpdatedCollection(Map<String, Integer> collectionA, Map<String, List<String>> collectionB) {
        collectionB.values().stream().flatMap(x -> x.stream()).forEach(x -> {
            collectionA.computeIfPresent(x,(k,v)->v-1);
        });
        return collectionA;
    }
}
