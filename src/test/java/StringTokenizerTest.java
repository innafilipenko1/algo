import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class StringTokenizerTest {

    @Test
    public void test() throws IOException {
        InputStream in = Mockito.mock(InputStream.class);
        StringTokenizer reader = new StringTokenizer(in);

        when(in.read()).thenReturn((int) 'a', (int) ' ', (int) 'b' - 1);
        when(in.available()).thenReturn(3, 2, 1, 0);


        List<String> actual = new ArrayList<String>();
        Iterator<String> iterator = reader.iterator();

        while (iterator.hasNext()) {
            String word = iterator.next();
            actual.add(word);
        }

        List<String> expected = new ArrayList<String>();
        expected.add("a");
        expected.add("b");

        assertEquals(2, actual.size());
        assertEquals(expected, actual);
    }
}
