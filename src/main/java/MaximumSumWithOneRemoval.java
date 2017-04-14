import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MaximumSumWithOneRemoval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- != 0) {
            int nums = sc.nextInt();
            List<Integer> input = new ArrayList<>();
            while (nums-- != 0) {
                input.add(sc.nextInt());
            }
            long result = input.get(0);
            result = Long.max(result, maximumContiguosSum(input));
            for (int i = 0; i < input.size(); i++) {
                int backup = input.get(i);
                if(backup<0) {
                    input.remove(i);
                    result = Long.max(result, maximumContiguosSum(input));
                    input.add(i, backup);
                }
            }
            System.out.println(result);
        }
    }

    public static long maximumContiguosSum(List<Integer> input) {
        long maxSum = input.get(0);
        long currentSum = 0;
        for (Integer num : input) {
            currentSum += num;
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }


}
