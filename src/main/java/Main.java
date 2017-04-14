import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- != 0) {
            int nums = sc.nextInt();
            List<Long> input = new ArrayList<>();
            while (nums-- != 0) {
                input.add(sc.nextLong());
            }
            Long currentSum = (long) 0;
            Long maxSum = Long.valueOf(input.get(0));
            List<Long> backupList = new ArrayList<>();
            for (Long num : input) {
                for (int i = 0; i < backupList.size(); i++) {
                    long newSum = backupList.get(i) + num;
                    if (newSum > maxSum) {
                        maxSum = newSum;
                    }
                    backupList.set(i, newSum);
                }
                if (num < 0) {
                    backupList.add(currentSum);
                }
                currentSum += num;
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
                if (currentSum < 0) currentSum = Long.valueOf(0);
            }
            System.out.println(maxSum);
        }
    }

}
