package cn.school.thoughtworks.section2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracticeA {
    Map<String,Integer> countSameElements(List<String> collection1) {
        HashMap<String, Integer> map = new HashMap<>();
        collection1.stream().forEach(x->map.compute(x,(k,v)->v==null?1:v+1));
        return map;
    }
}
