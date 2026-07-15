import java.util.*;
public class Power_Set {
  public static void generateSubsequences(String str, int index,
                                            String current,
                                            List<String> result) {

        if (index == str.length()) {
            if (!current.isEmpty()) {
                result.add(current);
            }
            return;
        }
        generateSubsequences(str, index + 1,
                             current + str.charAt(index), result);

        generateSubsequences(str, index + 1,
                             current, result);
    }

    public static void main(String[] args) {

        String str = "abc";
        List<String> result = new ArrayList<>();

        generateSubsequences(str, 0, "", result);

        System.out.println("Non-empty Subsequences:");
        for (String s : result) {
            System.out.println(s);
        }
    }
}
