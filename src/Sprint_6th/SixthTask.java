package Sprint_6th;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.BiFunction;

class MyUtils {
    public static int findMaxByCondition(List<Integer> numbers, Predicate<Integer> pr) {
        Optional<Integer> optionalInt = Optional.of(numbers.stream().filter(pr).max(Integer::compareTo).get());
        return optionalInt.get();
    }
}

class User {
    public final List<Integer> values = new ArrayList<>();

    public int getFilterdValue(BiFunction<List<Integer>,Predicate<Integer>,Integer> function,Predicate<Integer> predicate){
        return function.apply(values,predicate);
    }

    int getMaxValueByCondition(Predicate<Integer> predicate) {
        return MyUtils.findMaxByCondition(values,predicate);
    }
}
