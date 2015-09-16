import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CSVParserTest {

    CSVParser solution;

    @Before
    public void createSolution() {
         solution = new CSVParser();
    }

    @Ignore
    @Test
    public void check(){
        System.out.println("\"one,three\"\n<,\",\"\n,\n\"\"\"two\"\"\",");

    }

    @Test
    public void givenSeveralWordsDividedByComma_WhenParse_ThenOneTableRowReturned(){
        List<List<String>> actual = solution.parse("one,two");

        List<List<String>> expected = new ArrayList<>();
        List<String> row = new ArrayList<>();
        row.add("one");
        row.add("two");

        expected.add(row);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void givenSeveralWordsDividedByCommaAndNewLine_WhenParse_ThenSeveralTableRowsReturned(){
        List<List<String>> actual = solution.parse("one,two\nthree,");


        List<String> firstRow = new ArrayList<>();
        firstRow.add("one");
        firstRow.add("two");

        List<String> secondRow = new ArrayList<>();
        secondRow.add("three");
        secondRow.add("");

        List<List<String>> expected = new ArrayList<>();
        expected.add(firstRow);
        expected.add(secondRow);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void givenNothingBetweenWordsDividedByCommaAndNewLine_WhenParse_ThenSeveralTableRowsReturnedWithEmptyCellInsteadNothing(){
        List<List<String>> actual = solution.parse("one,,two\nthree,,four");

        List<String> firstRow = new ArrayList<>();
        firstRow.add("one");
        firstRow.add("");
        firstRow.add("two");

        List<String> secondRow = new ArrayList<>();
        secondRow.add("three");
        secondRow.add("");
        secondRow.add("four");

        List<List<String>> expected = new ArrayList<>();
        expected.add(firstRow);
        expected.add(secondRow);

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void givenSeveralWordsInOneCellEmptyRowAndWordInDoubleQuotes_WhenParse_ThenSeveralTableRowReturned(){
        List<List<String>> actual = solution.parse("\"one,three\",\n<,\",\"\n,\n\"\"\"two\"\"\",");

        List<List<String>> expected = new ArrayList<>();
        List<String> firstRow = new ArrayList<>();
        String firstCell = "one,three";
        firstRow.add(firstCell);
        firstRow.add("");
        List<String> secondRow = new ArrayList<>();
        secondRow.add("<");
        secondRow.add(",");
        List<String> thirdRow = new ArrayList<>();
        thirdRow.add("");
        thirdRow.add("");
        List<String> fourthRow = new ArrayList<>();
        fourthRow.add("\"two\"");
        fourthRow.add("");

        expected.add(firstRow);
        expected.add(secondRow);
        expected.add(thirdRow);
        expected.add(fourthRow);

        Assert.assertEquals(firstCell, actual.get(0).get(0));
        Assert.assertEquals(2, actual.get(0).size());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void givenBreakLineBetweenWordsInCell_WhenFormat_ThenWordsAreNotBreakenInRows(){
        List<List<String>> actual = solution.parse("\"one\n,three\"");

        List<List<String>> expected = new ArrayList<>();
        List<String> firstRow = new ArrayList<>();
        firstRow.add("one\n,three");

        expected.add(firstRow);
        Assert.assertEquals(expected, actual);

    }



}
