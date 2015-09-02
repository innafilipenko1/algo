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



}
