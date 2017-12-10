import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by mdev on 7/17/17.
 */
public class HelloFunction {
    public static void main(String[] args) {
        final Integer transform = transform(10, n -> n * 10);
        final Integer transform1 = transform1(10, 20, (n1, n2) -> n1 * n2);
        final Integer transform3 = transform1(10, 20, HelloFunction::multiplier);
        System.out.println("transform = " + transform3);
    }

    public static Integer multiplier(int num1, int num2) {
        return num1 * num2;
    }

    public static Integer transform(int num, Function<Integer, Integer> mathMethod) {
        return mathMethod.apply(num);
    }

    public static Integer transform1(int num1, int num2, BiFunction<Integer, Integer, Integer> mathMethod) {
        return mathMethod.apply(num1, num2);
    }
}

