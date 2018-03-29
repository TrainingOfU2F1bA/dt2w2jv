package cn.school.thoughtworks.section2;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PracticeA {
    Map<String, Integer> countSameElements(List<String> collection1) {
        return collection1.stream().collect(Collectors.toMap(
                x->x,
                x->1,
                (ov,nv)->ov+1
        ));
    }
}
