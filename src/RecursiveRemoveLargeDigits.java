import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RecursiveRemoveLargeDigits {

    List<Integer> getdigits(int n, List<Integer> list) {
        if(n > 9){
            int a = n%10;
            n = n/10;
            list.add(a);
            return getdigits(n, list);
        }
        list.add(n);
        return list;
    }

    public static void main(String []args) {
        RecursiveRemoveLargeDigits r = new RecursiveRemoveLargeDigits();
        int n = 31462985; //Remove adjacent large digits from right to left to get smallest number 1285
        List<Integer> digits = r.getdigits(n, new ArrayList<>());
        List<Integer> filteredNumber = IntStream.range(0, digits.size()-1).filter(x -> {
            if(digits.get(x) > digits.get(x+1)){
                return false;
            }
            return true;
        }).mapToObj(digits::get).collect(Collectors.toList()).reversed();
        Integer filteredNumberInt = Integer.parseInt(filteredNumber.stream().map(String::valueOf).collect(Collectors.joining()));
        System.out.println("The filtered number is "+filteredNumberInt);
    }

}
