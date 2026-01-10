package AoC_2025.day05.b;

import java.util.*;

public class RangeList {
    private List<Range> ranges;

    public RangeList() {
        this.ranges = new ArrayList<>();
    }

    public RangeList add(String s) {
        Arrays.stream(s.split("\n")).map(RangeList::toRange).forEach(ranges::add);
        return this;
    }

    private static Range toRange(String s) {
        return toRange(s.split("-"));
    }

    private static Range toRange(String[] split) {
        return new Range(toLong(split[0]), toLong(split[1]));
    }

    private static Long toLong(String s) {
        return Long.parseLong(s);
    }

    public RangeList sort() {
        ranges.sort(Comparator.comparingLong(Range::from));
        return reduces();
    }


    private RangeList reduces() {
        RangeList merged = new RangeList();

        merged.add(ranges.getFirst());
        ranges.stream().skip(1).forEach(range -> accumulate(merged, range));

        return merged;
        }

    private void add(Range range) {
        ranges.add(range);
    }

    private void accumulate(RangeList list, Range nextRange) {
        Range lastRange = list.removeLast();
        list.addAll(lastRange.mergeOrConcat(nextRange));
    }

    public Range removeLast() {
        return ranges.removeLast();
    }

    public void addAll(Collection<? extends Range> c) {
        ranges.addAll(c);
    }

    @Override
    public boolean equals(Object other) {
        RangeList otherRangeList = (RangeList) other;
        return this.size() == otherRangeList.size() &&
                java.util.stream.IntStream.range(0, this.size())
                        .allMatch(i -> this.get(i).equals(otherRangeList.get(i)));
    }

    public Range get(int i){
        return this.ranges.get(i);
    }

    private int size() {
        return ranges.size();
    }

    public boolean contains(Long num) {
        return ranges.stream().anyMatch(r -> r.contains(num));
    }

    public Long numbersAvailable(){
        return ranges.stream().mapToLong(Range::numbersInRange).sum();
    }
}
