package Sprint_6th;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println(MyUtils1.getCount(new int[]{1, 2, 3, -1, -5, 0}, i -> i > 2));
    }
}
