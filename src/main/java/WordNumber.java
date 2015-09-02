import java.util.HashSet;
import java.util.Set;

public class WordNumber {


    public int count(String input) {
        int count = 0;
        if (input!=null) {
            Set<Character> alphabet = new HashSet<>();
            for (int i = 0; i < 26; i++) {
                char c = (char) ('a' + i);
                char big = (char)('A'+i);
                alphabet.add(c);
                alphabet.add(big);
            }
            boolean isLetter = false;
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (alphabet.contains(c)) {
                    isLetter = true;
                } else {
                    if (isLetter) {
                        count++;
                        isLetter = false;
                    }

                }
            }
            if (isLetter) {
                count++;
            }
        }
        return count;
    }
}
