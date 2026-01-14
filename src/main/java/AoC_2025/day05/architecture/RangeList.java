package AoC_2025.day05.architecture;

import java.util.*;

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

    public Range get(int i) {
        return this.ranges.get(i);
    }

    public boolean contains(Long num) {
        return ranges.stream().anyMatch(r -> r.contains(num));
    }

    public Long numbersAvailable(){
        return ranges.stream().mapToLong(Range::numbersInRange).sum();
    }
}
