package Sprint_6th;

import java.util.Arrays;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
 class MyUtils1 {

    public static int getCount(int [] arrays ,Predicate<Integer> predicate) {
       int count = 0;
        for(Integer integer: arrays){
            if(predicate.test(integer)){
             count++;
            }
        }
            return count;
//        return Math.toIntExact(Arrays.stream(arrays).filter((IntPredicate) predicate).count());
    }
}
