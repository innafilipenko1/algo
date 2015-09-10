import java.util.ArrayList;
import java.util.List;

public class CSVParser {

    public List<List<String>> parse(String s) {

        List<List<String>> table = new ArrayList<>();
        List<String> firstRow = new ArrayList<>();


        String[] rows = s.split("\n");
        String[] firstCells = rows[0].split(",");
        for (String cell : firstCells) {
            firstRow.add(cell);
        }
        table.add(firstRow);


        int prev = firstCells.length;
        int maxCells = firstCells.length;
        boolean insideComma = false;
        int start = 0;


        for (int i = 1; i < rows.length; i++) {

            //String[] cells = rows[i].split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);

            ArrayList<String> cells = new ArrayList<>();

            for (int j = 0; j < rows[i].length(); j++) {
                char c = rows[i].charAt(j);
                if (c == '\"') {
                    insideComma = !insideComma;
                }
                boolean atLastChar = (j == rows[i].length() - 1);

                if (atLastChar) {
                    if (c == ',')
                        cells.add(rows[i].substring(start, rows[i].length() - 1));
                    else {
                        cells.add(rows[i].substring(start));
                    }
                } else if (c == ',' && !insideComma) {

                    cells.add(rows[i].substring(start, j));
                    start = j + 1;
                }

            }
            start = 0;

            List<String> newRow = new ArrayList<>();
            for (String cell : cells) {
                newRow.add(cell);
            }
            table.add(newRow);

            int n = prev - cells.size();
            if (n > 0) {
                for (int j = 0; j < n; j++) {
                    newRow.add("");
                }
            }
            prev = cells.size();

            if (maxCells < cells.size()) {
                maxCells = cells.size();
            }
        }

        if (firstCells.length < maxCells)

        {
            for (int i = 1; i < maxCells; i++) {
                firstRow.add("");
            }
        }


        return table;
    }
}
