import java.util.Arrays;
import java.util.Scanner;


public class DoubleKadane {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- != 0) {
            int total = sc.nextInt();
            long[] input = new long[total];
            for (int i = 0; i < total; i++) {
                input[i] = sc.nextLong();
            }
            long max = getResult(total, input);
            System.out.println(max);
        }
    }

    public static long getResult(int total, long[] input) {
        long[] kadane1 = new long[total];
        long[] kadane2 = new long[total];
        long currentSum = 0;
        for (int i = 0; i < total; i++) {
            currentSum += input[i];
            if (currentSum < 0)
                currentSum = 0;
            kadane1[i] = currentSum;
        }
//        System.out.println(Arrays.toString(kadane1));
        currentSum = 0;
        for (int i = total - 1; i >= 0; i--) {
            currentSum += input[i];
            if (currentSum < 0)
                currentSum = 0;
            kadane2[i] = currentSum;
        }
        long max = 0;
        for (int i = 0; i < total; i++) {
            max += input[i];
        }
//        System.out.println(Arrays.toString(kadane2));
        for (int i = 0; i < total; i++) {
            max = Long.max(max, (i >= 1 ? kadane1[i - 1] : 0) + (i < total - 1 ? kadane2[i + 1] : 0));
        }
        boolean allNegative = true;

        for (int i = 0; i < total; i++) {
            allNegative = allNegative && (input[i] < 0);
        }
        if (allNegative) {
            max = Long.MIN_VALUE;
            for (int i = 0; i < total; i++) {
                max = Long.max(max, input[i]);
            }
        }
        return max;
    }
}
