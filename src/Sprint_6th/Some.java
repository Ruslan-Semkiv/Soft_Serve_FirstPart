package Sprint_6th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

class MyUtilss {
    public static int findMaxByCondition(List<Integer> numbers, Predicate<Integer> pr) {
//
//        int maxByCondition = 0;
//
//        for (Integer i : numbers) {
//            if (pr.test(i)) {
//                maxByCondition = i.intValue();
//            }
//        }
//        return maxByCondition;
        return numbers.stream().filter(pr).max(Integer::compareTo).get();
    }
}

class Users {
    public final List<Integer> values = new ArrayList<Integer>();

    int getFilterdValue(BiFunction<List<Integer>, Predicate<Integer>, Integer> biFunction, Predicate<Integer> p) {

        return biFunction.apply(values, p);
    }

    int getMaxValueByCondition(Predicate<Integer> predicate) {

        BiFunction<List<Integer>, Predicate<Integer>, Integer> biFunction = MyUtilss::findMaxByCondition;

        return getFilterdValue(biFunction,predicate);
    }
}
