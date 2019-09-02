package org.houseofsoft.katas;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given a finite number of sets, compute "Venn split", that is a set of largest disjoint sets, comprising the initial
 * sets.<br>
 * For example: {1, 2, 3}. {1, 2, 4}, {1, 2, 5} -> {1, 2}, {3}, {4}, {5}
 */
public class VennSplit<T> {

    public static <T> Set<Set<T>> of(Set<Set<T>> inputSets) {
        List<Set<T>> result = new ArrayList<>(); // Using List for direct access to elements by index
        Queue<Set<T>> processingQueue = new LinkedList<>(inputSets);
        Set<T> s;
        while ((s = processingQueue.poll()) != null) {
            if (s.size() == 0) { // skip empty sets
                continue;
            }
            int index = 0;
            for (Set<T> v : result) {
                Set<T> intersection = Sets.intersection(v, s);

                if (intersection.size() > 0) {
                    // "Slice" s and v
                    Set<T> d1 = Sets.diff(v, s);
                    if (d1.size() > 0) {
                        // Reduce v to v-s
                        result.set(index, d1); // direct access: not possible if it were a Set

                        // Enqueue v*s
                        processingQueue.add(intersection);
                    }

                    // Reduce s to s-v
                    s = Sets.diff(s, v);
                    if (s.size() == 0) {
                        break;
                    }
                }

                index++;
            }
            if (s.size() > 0) { // the remaining slice out of s is a Venn set
                result.add(s);
            }
        }

        return new HashSet<Set<T>>(result);
    }
}
