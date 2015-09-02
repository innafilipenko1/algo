import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddNumberBase36Test {

    AddNumberBase36 solution;

    @Before
    public void before(){
        solution = new AddNumberBase36();
    }

    @Test
    public void given5And2_WhenAdd_ThenResultIs7() {

        String actual = solution.add("5", "2");
        Assert.assertEquals("Result is not 7, but " + actual, "7", actual);
    }

    @Test
    public void givenIAdd9And1ThenResultIsA() {

        String actual = solution.add("9", "1");
        Assert.assertEquals("a", actual);
    }

    @Test
    public void givenIAddZAnd1ThenResultIs10() {

        String actual = solution.add("z", "1");
        Assert.assertEquals("10", actual);
    }

    @Test
    public void givenIAddABCAnd091ThenResultIsAKD() {

        String actual = solution.add("ABC", "091");
        Assert.assertEquals("akd", actual);
    }

    @Test
    public void givenIAddZAndEmptyValueThenResultIsZ() {

        String actual = solution.add("z", "");
        Assert.assertEquals("z", actual);
    }

    @Test
    public void givenIAddTwoEmptyValuesThenResultIsEmpty() {

        String actual = solution.add("", "");
        Assert.assertEquals("", actual);
    }

    @Test
    public void givenIAddSpecialSymbolsThenRangeMessageIsReturned() {

        String actual = solution.add("@", "#");
        Assert.assertEquals("Input values are not within range of Base36 count system!", actual);
    }

    @Test
    public void givenIAddZAndNULLThenNULLMessageIsReturned() {

        String actual = solution.add("z", null);
        Assert.assertEquals("Input value is NULL.", actual);
    }
}
