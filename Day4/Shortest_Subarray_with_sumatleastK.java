import java.util.*;

public class Shortest_Subarray_with_sumatleastK {
    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                sum += nums[j];

                if (sum >= k) {
                    minLength = Math.min(minLength, j - i + 1);
                    break; 
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = {2, -1, 2,3};
        int k = 3;

        System.out.println(shortestSubarray(nums, k));
    }
}
