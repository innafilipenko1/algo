import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BreakLineTest {

    BreakLine solution;

    @Before
    public void before(){
        solution = new BreakLine();
    }

    @Test
    public void givenWordLongerThanWidth_WhenFormat_ThenWordIsCut(){
        String actual = solution.format("one", 2);
        Assert.assertEquals("on\ne", actual);
    }

    @Test
    public void givenWordShorterThanWidth_WhenFormat_ThenWordIsNotCut(){
        String actual = solution.format("one", 5);
        Assert.assertEquals("one", actual);
    }

    @Test
    public void givenWordFewTimesLongerThanWidth_WhenFormat_ThenWordIsCutSeveralTimes(){
        String actual = solution.format("onetwo", 2);
        Assert.assertEquals("on\net\nwo", actual);
    }

    @Test
    public void givenNextWordLongerThanWidth_WhenFormat_ThenNextWordIsWrapped(){
        String actual = solution.format("12 two", 4);
        Assert.assertEquals("12\ntwo", actual);
    }

    @Test
    public void givenSpaceBeforeAndAfterWordsInLine_WhenFormat_ThenSpaceIsRemovedIfFirstAndLastInNewLine(){
        String actual = solution.format(" firstword o'kay 78 139 secondword ", 5);
        Assert.assertEquals("first\nword\no'kay\n78\n139\nsecon\ndword\n", actual);
    }

}
