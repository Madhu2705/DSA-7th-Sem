import java.util.*;
import java.io.*;

public class Main {

    static class Solution {

        public int minRemoval(int n, int[][] intervals) {

            Arrays.sort(intervals, (a, b) -> {
                if (a[1] != b[1])
                    return a[1] - b[1];
                return a[0] - b[0];
            });

            int remove = 0;
            int end = intervals[0][1];

            for (int i = 1; i < n; i++) {
                if (intervals[i][0] < end) {
                    remove++;
                } else {
                    end = intervals[i][1];
                }
            }

            return remove;
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] intervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }

        Solution obj = new Solution();
        System.out.println(obj.minRemoval(n, intervals));
    }
}