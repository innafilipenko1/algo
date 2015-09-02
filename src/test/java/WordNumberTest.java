import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WordNumberTest {

    WordNumber solution;

    @Before
    public void before(){
        solution = new WordNumber();
    }

    @Test
    public void givenTwoWords_WhenCount_ResultIs2(){
        int actual = solution.count("one two");
        Assert.assertEquals(2, actual);
    }

    @Test
    public void givenTwoNumbers_WhenCount_ResultIs0(){
        int actual = solution.count("4 4");
        Assert.assertEquals(0, actual);
    }


    @Test
    public void givenNull_WhenCount_ResultIs0(){
        int actual = solution.count(null);
        Assert.assertEquals(0, actual);
    }
    @Test
    public void givenEmptyString_WhenCount_ResultIs0(){
        int actual = solution.count("");
        Assert.assertEquals(0, actual);
    }
    @Test
    public void givenStringWithUpperCaseLetter_WhenCount_ResultIs1(){
        int actual = solution.count("HanryAnna");
        Assert.assertEquals(1, actual);
    }
    @Test
    public void givenSpacesBetweenWords_WhenCount_ResultIs2(){
        int actual = solution.count("Hanry                        Anna");
        Assert.assertEquals(2, actual);
    }

    @Test
    public void givenSpecialCharactersBetweenWords_WhenCount_ResultIs2(){
        int actual = solution.count("%^&*+__Hanry#$%^&*@Anna%^&*(");
        Assert.assertEquals(2, actual);
    }

    @Test
    public void givenSpecialCharacters_WhenCount_ResultIs0(){
        int actual = solution.count("!@$%^&*(()*(&^^%      $$%^&%$##@!#^)+");
        Assert.assertEquals(0, actual);
    }


}
