
public class Sliding_Window {
    public static void findSubarray(int[] arr, int target) {

        int left = 0;
        int sum = 0;

        for (int right = 0; right < arr.length; right++) {

            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {
                System.out.println("Left Index : " + left);
                System.out.println("Right Index: " + right);
                return;
            }
        }

        System.out.println("No subarray found");
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int target = 12;

        findSubarray(arr, target);
    }
}

