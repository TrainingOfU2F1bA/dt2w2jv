package cn.school.thoughtworks.section2;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PracticeC {
    Map<String, Integer> countSameElements(List<String> collection1) {
        return collection1.stream().collect(Collectors.toMap(
                x -> replaceColon().apply(replaceBracket().apply(x)).split("-")[0],
                getQuantity(),
                (ov, nv) -> ov + nv
        ));
    }

    private Function<String, String> replaceBracket() {
        return x -> {
            int i = x.lastIndexOf("[");
            int k = x.lastIndexOf("]");
            if (i != -1 && k != -1) {
                int m = Integer.parseInt(x.substring(i + 1, k));
                return x.substring(0, i) + "-" + m;
            }
            return x;
        };
    }

    private Function<String, String> replaceColon() {
        return x -> {
            int i = x.lastIndexOf(":");
            if (i != -1) {
                char[] chars = x.toCharArray();
                chars[i] = '-';
                x = new String(chars);
            }
            return x;
        };
    }

    private Function<String, Integer> getQuantity() {
        return x -> {
            int i = x.lastIndexOf('-');
            return Integer.valueOf(i != -1 ? x.substring(i + 1) : "1");
        };
    }

}
