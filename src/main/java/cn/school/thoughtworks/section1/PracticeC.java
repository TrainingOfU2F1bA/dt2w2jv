package cn.school.thoughtworks.section1;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PracticeC {
    List<String> collectSameElements(List<String> collection1, Map<String,List<String>> collection2) {
        //实现练习要求，并改写该行代码。
        HashSet<String> set= new HashSet<>(collection2.values().stream().flatMap(x -> x.stream()).collect(Collectors.toList()));
        return collection1.stream().filter(x->set.contains(x)).collect(Collectors.toList());
    }
}
