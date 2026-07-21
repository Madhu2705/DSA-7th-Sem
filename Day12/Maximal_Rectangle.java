import java.util.*;
public class Maximal_Rectangle {
  public static int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i];

            while (!st.isEmpty() && h < heights[st.peek()]) {
                int height = heights[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;

                maxArea = Math.max(maxArea, height * width);
            }

            st.push(i);
        }

        return maxArea;
    }

    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int[] heights = new int[matrix[0].length];
        int max = 0;

        for (char[] row : matrix) {
            for (int j = 0; j < row.length; j++) {
                if (row[j] == '1')
                    heights[j]++;
                else
                    heights[j] = 0;
            }

            max = Math.max(max, largestRectangleArea(heights));
        }

        return max;
    }

    public static void main(String[] args) {
        char[][] matrix = {
            {'1','0','1','0','1'},
            {'0','1','0','0','1'},
            {'0','0','1','1','1'},
            {'1','0','0','0','1'}
        };

        System.out.println(maximalRectangle(matrix));
    }
} 

