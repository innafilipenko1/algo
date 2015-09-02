

public class BreakLine {

    public String format(String word, int width) {


        StringBuilder sb = new StringBuilder();
        sb.append(word);
        if(width<word.length()){
            sb.insert(width, "\n");
        }
        return sb.toString();
    }
}
