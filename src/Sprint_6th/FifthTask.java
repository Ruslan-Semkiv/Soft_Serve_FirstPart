package Sprint_6th;

import java.util.function.Predicate;
import java.util.Set;

class MyUtils5 {

    static Predicate<Integer> getPredicateFromSet (Set<Predicate<Integer>> sumOfPredicate){
        Predicate<Integer> sum = sumOfPredicate.iterator().next();
        for(Predicate<Integer> one: sumOfPredicate){
            sum = sum.and(one);
        }
        return sum;
    }

}

