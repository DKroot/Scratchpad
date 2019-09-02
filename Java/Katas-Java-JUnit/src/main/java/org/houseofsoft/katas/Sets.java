package org.houseofsoft.katas;

import java.util.HashSet;
import java.util.Set;

public class Sets {

    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    public static <T> Set<T> diff(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.removeAll(b);
        return result;
    }

}
