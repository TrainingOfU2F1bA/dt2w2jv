package cn.school.thoughtworks.section2;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PracticeB {
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
}
