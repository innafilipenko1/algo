

public class BreakLine {


    public String format(String word, int width) {


        StringBuilder sb = new StringBuilder();

        int lastSpace = -1; //no whitespace
        int count = 0; //for characters counting
        int additionalCharacters = 0; //when \n is added
        int countFromSpace = 0; //for characters counting appended after whitespace


        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (count == 0 && c == ' ') {
                additionalCharacters--;
                continue;
            }

            sb.append(c);
            count++;

            if (c == ' ') {
                lastSpace = i;
            }

            if (lastSpace > 0 && count < width) {
                countFromSpace++;
            }

            if (width <= count && i < word.length()-1) {
                if (lastSpace > 0) {
                    sb.setCharAt(lastSpace + additionalCharacters, '\n');
                } else {
                    sb.append("\n");
                    additionalCharacters++;
                }
                lastSpace = -1;
                count = countFromSpace;
                countFromSpace = 0;

            }
        }

        return sb.toString();

    }
}
