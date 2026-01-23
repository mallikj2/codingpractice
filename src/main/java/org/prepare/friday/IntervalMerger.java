package org.prepare.friday;

import java.util.*;

public class IntervalMerger {

    // Interval as a record (Java 17 feature)
    public record Interval(int start, int end) {}

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return Collections.emptyList();
        }

        // Step 1: Sort by start time
        intervals.sort(Comparator.comparingInt(Interval::start));

        List<Interval> merged = new ArrayList<>();
        Interval current = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval next = intervals.get(i);

            if (next.start <= current.end) {
                // Overlap → merge
                current = new Interval(current.start, Math.max(current.end, next.end));
            } else {
                // No overlap → push current and move on
                merged.add(current);
                current = next;
            }
        }

        // Add the last interval
        merged.add(current);

        return merged;
    }

    // Demo
    public static void main(String[] args) {
        List<Interval> intervals = List.of(
                new Interval(1, 3),
                new Interval(8, 10),
                new Interval(2, 6),
                new Interval(15, 18)
        );

        List<Interval> merged = merge(new ArrayList<>(intervals));
        merged.forEach(i -> System.out.println("[" + i.start() + ", " + i.end() + "]"));
    }
}
