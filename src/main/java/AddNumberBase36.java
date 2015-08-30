import java.util.HashMap;
import java.util.Map;

public class AddNumberBase36 {

    public static String add(String a, String b) {

        try {
            a = a.toLowerCase();
            b = b.toLowerCase();
        } catch (Exception e) {
            return "Input value is NULL.";
        }

        int carry = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int k = 0; k < 10; k++) {
            map.put((char) ('0' + k), k);
        }

        for (int l = 0; l < 36; l++) {
            map.put((char) ('a' + l), l + 10);
        }

        int sum = 0;
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0) {
            char v1 = (i >= 0) ? a.charAt(i--) : '0';
            char v2 = (j >= 0) ? b.charAt(j--) : '0';

            int digitA = 0;
            int digitB = 0;
            try {
                digitA = map.get(v1);
                digitB = map.get(v2);
            } catch (NullPointerException e) {
                return "Input values are not within range of Base36 count system!";
            }

            sum = digitA + digitB + carry;
            carry = sum / 36;
            sum = sum % 36;

            char result = (sum < 10) ? (char) ('0' + sum) : (char) ('a' + (sum - 10));

            sb.append(result);
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();

    }
}
