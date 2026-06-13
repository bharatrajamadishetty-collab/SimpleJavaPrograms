import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class MultiIndexMatrix {
    static int[][] removeIntervals(int[][] intervals) {
        int[][] merged = IntStream.range(0, intervals.length)
                .mapToObj(i -> intervals[i])
                .sorted((a, b) -> Integer.compare(a[0], b[0]))
                .collect(
                        () -> new ArrayList<int[]>(),
                        (list, interval) -> {
                            if (list.isEmpty() || list.get(list.size() - 1)[1] < interval[0]) {
                                list.add(interval);
                            } else {
                                int[] last = list.get(list.size() - 1);
                                last[1] = Math.max(last[1], interval[1]);
                            }
                        },
                        ArrayList::addAll)
                .toArray(new int[0][]);
        return merged;
    }

    void main() {
        int[][] intervals = {
                { 1, 3 },
                { 2, 6 },
                { 8, 10 },
                { 15, 18 }
        };

        for (int i = 1, j = 1; i < intervals.length && j < intervals[i].length; i++, j++) {
            if (intervals[i - 1][j] >= intervals[i][j - 1]) {
                intervals[i - 1][j] = intervals[i][j];
                while (i <= intervals.length - 1) {
                    if (i == intervals.length - 1) {
                        intervals = Arrays.copyOf(intervals, intervals.length - 1);
                    } else {
                        intervals[i][j - 1] = intervals[i + 1][j - 1];
                        intervals[i][j] = intervals[i + 1][j];
                        i++;
                    }
                }
            }
        }
        IO.println(Arrays.deepToString(intervals));
        IO.println(Arrays.deepToString(removeIntervals(intervals)));
    }

}
