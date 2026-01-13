package AoC_2025.day05.b;

import java.util.*;
import java.util.stream.IntStream;

public record RangeList(List<Range> ranges) {

    public RangeList reduces() {
        return reduces(new ArrayList<>());
    }

    private RangeList reduces(ArrayList<Range> rangeList) {
        rangeList.add(ranges.getFirst());
        ranges.stream().skip(1).forEach(range -> accumulate(rangeList, range));
        return new RangeList(rangeList);
    }


    private void accumulate(List<Range> list, Range nextRange) {
        list.addAll(list.removeLast().mergeOrConcat(nextRange));
    }

    @Override
    public boolean equals(Object other) {
        RangeList otherRangeList = (RangeList) other;
        return this.size() == otherRangeList.size() &&
                IntStream.range(0, this.size())
                        .allMatch(i -> this.get(i).equals(otherRangeList.get(i)));
    }

    public Range get(int i) {
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
