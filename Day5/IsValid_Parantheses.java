import java.util.*;

public class Main {

    public static int valid(String s) {
        int low = 0, high = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                low++;
                high++;
            } else if (ch == ')') {
                if (low > 0) low--;
                high--;
            } else { // '*'
                if (low > 0) low--;
                high++;
            }

            if (high < 0)
                return 0;
        }

        return low == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(valid(s));
    }
}