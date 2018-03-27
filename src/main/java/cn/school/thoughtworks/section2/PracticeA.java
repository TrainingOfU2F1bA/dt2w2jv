package cn.school.thoughtworks.section2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracticeA {
    Map<String,Integer> countSameElements(List<String> collection1) {
        HashMap<String, Integer> map = new HashMap<>();
        collection1.stream().forEach(x->{
            if (!map.containsKey(x)) map.put(x,1);
            else map.put(x,map.get(x)+1);
        });
        return map;
    }
}
