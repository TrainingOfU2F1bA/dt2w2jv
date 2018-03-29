package cn.school.thoughtworks.section3;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PracticeD {
    Map<String,Integer> createUpdatedCollection(List<String> collectionA, Map<String,List<String>> object) {
        //实现练习要求，并改写该行代码。
        Map<String, Integer> collection3 = countSameElements(collectionA);
        return createUpdatedCollection(collection3,object);
    }

   Map<String, Integer> countSameElements(List<String> collection1) {
        return collection1.stream().collect(Collectors.toMap(
                x->x.split("-")[0],
                getQuantity(),
                (ov,nv)-> ov+ nv
        ));
    }

    private Function<String, Integer> getQuantity() {
        return x->{
            int i = x.lastIndexOf('-');
            return Integer.valueOf(i!=-1?x.substring(i+1):"1");
        };
    }

    Map<String,Integer> createUpdatedCollection(Map<String, Integer> collectionA, Map<String, List<String>> object) {
        object.values().stream().flatMap(x -> x.stream()).forEach(x -> {
                collectionA.computeIfPresent(x,(k,v)->v<3?v:v-v/3);
        });
        return collectionA;
    }
}
