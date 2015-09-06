

public class BreakLine {


    public String format(String word, int width) {


        StringBuilder sb = new StringBuilder();

        int lastSpace = -1;//no whitespace
        int count = 0;
        int additionalCharacters = 0;


        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(count==0 && c == ' '){
                additionalCharacters--;
                continue;
            }

            sb.append(c);
            count++;

            if (c == ' ') {
                lastSpace = i;
            }

            if (count >= width && i < word.length() - 1) {
                if (lastSpace > 0) {
                    sb.setCharAt(lastSpace+additionalCharacters, '\n');
                } else {
                    sb.append("\n");
                    additionalCharacters++;
                }
                lastSpace = -1;
                count = 0;
            }
        }

        return sb.toString();
    }
}
