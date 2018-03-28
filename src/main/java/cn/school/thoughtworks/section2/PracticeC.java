package cn.school.thoughtworks.section2;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class PracticeC {
    Map<String, Integer> countSameElements(List<String> collection1) {
        HashMap<String, Integer> map = new HashMap<>();
        collection1.stream().map(replaceColon()).map(replaceBracket()).map(mapToEntry()).forEach(countThenPut(map));
        return map;
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

    private Function<String, Map.Entry<String, Integer>> mapToEntry() {
        return x -> {
            int i = x.lastIndexOf('-');
            return new AbstractMap.SimpleEntry<String, Integer>(
                    x.substring(0, i != -1 ? i : x.length()),
                    Integer.valueOf(i != -1 ? x.substring(i + 1) : "1")
            );
        };
    }

    private Consumer<Map.Entry<String, Integer>> countThenPut(HashMap<String, Integer> map) {
        return x -> {
            String key = x.getKey();
            Integer value = x.getValue();
            map.compute(key,(k,v)->v==null?value:v+value);
        };
    }
}
