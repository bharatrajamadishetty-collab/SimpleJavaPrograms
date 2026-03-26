import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class TopStocksArray {

    public static void main(String args[]){
        List<Integer> numbers = Arrays.asList(100, 80, 60, 70, 60, 75, 85);
        Set<Integer> num = new LinkedHashSet<>();
        IntStream.range(0, numbers.size()-1).forEach(x -> {
            if(numbers.get(x)<numbers.get(x+1)){
                num.add(numbers.get(x));
            }
            if(x == numbers.size()-2){
                num.add(numbers.get(x+1));
            }
        });
        System.out.println(num);

        //find the longest contiguous subarray where each element is greater than the previous one
        int[] nums = { 100, 80, 60, 70, 80, 95, 60, 75, 85 };
        List<Integer> longestIncreasingSubarray = IntStream.range(0, nums.length)
                .filter(i -> i == 0 || nums[i] <= nums[i - 1])
                .mapToObj(i -> IntStream.iterate(i, j -> j + 1)
                        .takeWhile(j -> j < nums.length && (j == i || nums[j] > nums[j - 1]))
                        .mapToObj(j -> nums[j])
                        .toList())
                .filter(seq -> seq.size() > 1)
                .max((a, b) -> Integer.compare(a.size(), b.size()))
                .orElse(List.of());
 
        System.out.println(longestIncreasingSubarray);
    }

}
