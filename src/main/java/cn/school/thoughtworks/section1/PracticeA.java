package cn.school.thoughtworks.section1;

import java.util.*;
import java.util.stream.Collectors;

public class PracticeA {
    List<String> collectSameElements(List<String> collection1, List<String> collection2) {
        //实现练习要求，并改写该行代码。
        HashSet<String> set = new HashSet<>(collection2);
        return collection1.stream().filter(x->set.contains(x)).collect(Collectors.toList());
    }
}
