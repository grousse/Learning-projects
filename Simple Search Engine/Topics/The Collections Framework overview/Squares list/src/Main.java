import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

class CollectionUtils {

    public static Collection<Integer> pow2(Collection<Integer> numbers) {
        // write your code here
        Collection<Integer> collection = new ArrayList<>();
        numbers.forEach(col -> collection.add((int) Math.pow(col,2)));
        return collection;
    }
}

/* Please, do not modify this I/O code */
public class Main {
    public static void main(String[] args) {
        int [] a = {3, 0, 3, 9, 2, 1};
       int r = 7;
        for (int i = 0; i < a.length; i++) {
            r += a[i] * a[i];
        }

        r = 13;
        r += a[a[0]];
        r -= a[a[a.length-1]];
//
        r = 0;
        for (int i = 0; i < a.length; i = i + 1) {
            if (a[i] < a.length) {
                r += a[i];
            }
        }
        System.out.println(r);

    }
}