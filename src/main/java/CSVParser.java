import java.util.ArrayList;
import java.util.List;

public class CSVParser {

    public List<List<String>> parse2(String s) {
        CsvState state = CsvState.Init;
        ParseData data = new ParseData();
        for (int i = 0; i < s.length(); i++) {
            state = state.next(s.charAt(i), data);
        }
        return data.getResult();
    }

    public List<List<String>> parse(String s) {

        List<List<String>> table = new ArrayList<>();

        List<String> row = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean isQuotes = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ',' && !isQuotes) {
                row.add(sb.toString());
                sb = new StringBuilder();
            } else if (c == '\n' && isQuotes) {
                sb.append(c);
            } else if (c == '\n') {
                row.add(sb.toString());
                sb = new StringBuilder();
                table.add(row);
                row = new ArrayList<>();
            } else if (c == '"') {
                isQuotes = !isQuotes;
            } else {
                sb.append(c);
            }
        }

        row.add(sb.toString());
        table.add(row);
        return table;

    }
}
