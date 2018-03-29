package cn.school.thoughtworks.section3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PracticeC {
    Map<String, Integer> createUpdatedCollection(List<String> collectionA, Map<String, List<String>> object) {
        //实现练习要求，并改写该行代码。
        Map<String, Integer> collection3 = countSameElements(collectionA);
        return createUpdatedCollection(collection3,object);
    }

    Map<String, Integer> countSameElements(List<String> collection1) {
        return collection1.stream().collect(Collectors.toMap(
                x->x,
                x->1,
                (ov,nv)->ov+1
        ));
    }

    Map<String,Integer> createUpdatedCollection(Map<String, Integer> collectionA, Map<String, List<String>> object) {
        object.values().stream().flatMap(x -> x.stream()).forEach(x -> {
                collectionA.computeIfPresent(x,(k,v)->v<3?v:v-v/3);
        });
        return collectionA;
    }
}
